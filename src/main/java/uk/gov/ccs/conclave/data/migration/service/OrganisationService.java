package uk.gov.ccs.conclave.data.migration.service;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import uk.gov.ccs.conclave.data.migration.client.CiiOrgClient;
import uk.gov.ccs.conclave.data.migration.client.ConclaveClient;
import uk.gov.ccs.conclave.data.migration.domain.Org;
import uk.gov.ccs.conclave.data.migration.exception.DataMigrationException;
import uk.gov.ccs.conclave.data.migration.controller.DataMigrationApiController;
import uk.gov.ccs.swagger.cii.ApiException;
import uk.gov.ccs.swagger.cii.model.Address;
import uk.gov.ccs.swagger.cii.model.Identifier;
import uk.gov.ccs.swagger.cii.model.OrgMigration;
import uk.gov.ccs.swagger.dataMigration.model.Organisation;
import uk.gov.ccs.swagger.sso.model.OrganisationAddress;
import uk.gov.ccs.swagger.sso.model.OrganisationDetail;
import uk.gov.ccs.swagger.sso.model.OrganisationIdentifier;
import uk.gov.ccs.swagger.sso.model.OrganisationProfileInfo;
import java.util.stream.Stream;

import static uk.gov.ccs.conclave.data.migration.service.ErrorService.*;


@Service
@RequiredArgsConstructor
public class OrganisationService {

    private final CiiOrgClient ciiOrgClient;
    private final ConclaveClient conclaveClient;
    private final ErrorService errorService;
    private final ContactService contactService;
    private final RoleService roleService;

    private static final Logger log = LoggerFactory.getLogger(OrganisationService.class);
    private boolean orgExistsInConclave = false;


    public OrgMigrationResponse migrateOrganisation(Organisation org) throws DataMigrationException {

        OrgMigration ciiResponse = migrateOrgToCii(org);
        String organisationId = null;
        Integer identityProviderId = 0;

        if (null != ciiResponse) {
            migrateOrgToConclave(ciiResponse, org);
            organisationId = ciiResponse.getOrganisationId();
           // identityProviderId = getIdentityProviderIdOfOrganisation(organisationId, org);
        }

        return generateOrgMigrationResponseAndSaveSuccess(org, organisationId, identityProviderId);
    }


    private OrgMigrationResponse generateOrgMigrationResponseAndSaveSuccess(Organisation org, String orgId, Integer idp) {
        OrgMigrationResponse response = null;
        if (idp != null && orgId != null) {
            Org migratedOrg = (orgExistsInConclave ?
                    errorService.saveOrgDetailsWithStatusCode(org, SSO_DUPLICATE_ORG_ERROR_MESSAGE, 409) :
                    errorService.saveOrgDetailsWithStatusCode(org, ORG_MIGRATION_SUCCESS, 200));
            response = new OrgMigrationResponse(orgId, idp, migratedOrg);
        }

        return response;
    }


    private OrgMigration migrateOrgToCii(Organisation organisation) throws DataMigrationException {
        OrgMigration ciiOrganisation = null;

        try {
            ciiOrganisation = ciiOrgClient.createCiiOrganisation(organisation.getSchemeId(), organisation.getIdentifierId());

        } catch (ApiException e) {

            if (e.getCode() == 409) {
                ciiOrganisation = new Gson().fromJson(e.getResponseBody(), OrgMigration.class);
            } else {
                errorService.logWithStatus(organisation, CII_ORG_ERROR_MESSAGE, e, e.getCode());
                DataMigrationApiController.responseBody.put(organisation.getSchemeId() + "-" + organisation.getIdentifierId(), CII_ORG_ERROR_MESSAGE + e);
                DataMigrationApiController.responseStatus = HttpStatus.NOT_FOUND;
            }
        }

        return ciiOrganisation;
    }


    private void migrateOrgToConclave(OrgMigration ciiResponse, Organisation organisation) throws DataMigrationException {
        log.debug("Migrating organisation to conclave: {}", organisation);

        try {
            String organisationId = ciiResponse.getOrganisationId();

            if (isNewOrg(ciiResponse) && !hasOrganisationAdmin(organisation)) {
                log.debug("Deleting new organisation without admin...");

                deleteOrgFromCii(organisationId);

                DataMigrationApiController.responseBody.put(organisation.getSchemeId() + "-" + organisation.getIdentifierId(), SSO_ORG_ADMIN_ERROR_MESSAGE);
                DataMigrationApiController.responseStatus = HttpStatus.BAD_REQUEST;

            } else if (isNewOrg(ciiResponse)) {
                log.debug("Migrating new organisation with an admin user present...");

                orgExistsInConclave = false;
                OrganisationProfileInfo conclaveOrgProfile = buildOrgProfileRequest(ciiResponse, organisation);
                conclaveClient.createConclaveOrg(conclaveOrgProfile);
                contactService.migrateOrgContact(organisation, ciiResponse, organisationId);
                roleService.applyOrganisationRole(organisationId, organisation);

            } else {
                log.debug("Organisation already exists. Applying roles...");
                orgExistsInConclave = true;
                roleService.applyOrganisationRole(organisationId, organisation);
            }

        } catch (uk.gov.ccs.swagger.sso.ApiException e) {
            errorService.logWithStatus(organisation, SSO_ORG_ERROR_MESSAGE, e, e.getCode());
            String responseOrgDetails = organisation.getSchemeId() + "-" + organisation.getIdentifierId();
            DataMigrationApiController.responseBody.put(responseOrgDetails, SSO_ORG_ERROR_MESSAGE + e);
            DataMigrationApiController.responseStatus = HttpStatus.BAD_REQUEST;
        }
    }

    private void deleteOrgFromCii(String organisationId) throws DataMigrationException {
        try {
            ciiOrgClient.deleteCiiOrganisation(organisationId);
        } catch (ApiException e) {
            errorService.logWithStatusString(CII_DEL_ORG_ERROR_MESSAGE, e, e.getCode());
        }
    }

    private boolean isNewOrg(OrgMigration ciiResponse) {
        return ciiResponse.getIdentifier() != null;
    }

    private OrganisationProfileInfo buildOrgProfileRequest(OrgMigration ciiResponse, Organisation org) {
        Identifier identifier = ciiResponse.getIdentifier();
        Address address = ciiResponse.getAddress();

        OrganisationProfileInfo conclaveOrgProfile = new OrganisationProfileInfo();

        OrganisationAddress organisationAddress = buildOrgAddress(address);
        conclaveOrgProfile.setAddress(organisationAddress);

        OrganisationIdentifier organisationIdentifier = buildOrgIdentifier(identifier);
        conclaveOrgProfile.setIdentifier(organisationIdentifier);

        OrganisationDetail organisationDetail = buildOrgDetail(ciiResponse, org);
        conclaveOrgProfile.setDetail(organisationDetail);

        return conclaveOrgProfile;
    }

    private OrganisationDetail buildOrgDetail(OrgMigration ciiResponse, Organisation org) {
        OrganisationDetail organisationDetail = new OrganisationDetail();
        organisationDetail.setOrganisationId(ciiResponse.getOrganisationId());
        organisationDetail.setRightToBuy(org.isRightToBuy());
        organisationDetail.setDomainName(org.getDomainName());
        return organisationDetail;
    }

    private OrganisationIdentifier buildOrgIdentifier(Identifier ciiIdentifier) {
        OrganisationIdentifier organisationIdentifier = new OrganisationIdentifier();
        organisationIdentifier.setLegalName(ciiIdentifier.getLegalName());
        organisationIdentifier.setUri(ciiIdentifier.getUri());
        return organisationIdentifier;
    }

    private OrganisationAddress buildOrgAddress(Address ciiAddress) {
        OrganisationAddress organisationAddress = new OrganisationAddress();
        organisationAddress.setStreetAddress(ciiAddress.getStreetAddress());
        organisationAddress.setLocality(ciiAddress.getLocality());
        organisationAddress.setPostalCode(ciiAddress.getPostalCode());
        organisationAddress.setRegion(ciiAddress.getRegion());
        return organisationAddress;
    }

    private Integer getIdentityProviderIdOfOrganisation(String organisationId, Organisation organisation) throws DataMigrationException {
        Integer identityProviderId = null;
        try {
            identityProviderId = conclaveClient.getIdentityProviderId(organisationId);
        } catch (uk.gov.ccs.swagger.sso.ApiException e) {
            errorService.logWithStatus(organisation, SSO_IDENTITY_PROVIDER_ERROR_MESSAGE, e, e.getCode());
        }
        return identityProviderId;
    }

    private static boolean hasOrganisationAdmin(final Organisation organisation) {
        if (organisation == null || organisation.getUser() == null) {
            return false;
        }

        var allUserRoles = organisation
                .getUser()
                .stream()
                .flatMap(user -> user == null || user.getUserRoles() == null ? Stream.empty(): user.getUserRoles().stream());

        return allUserRoles.anyMatch(userRole -> userRole != null && userRole.getName().equals("Organisation Administrator"));
    }

}
