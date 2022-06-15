package uk.gov.ccs.conclave.data.migration.service;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uk.gov.ccs.conclave.data.migration.exception.DataMigrationException;
import uk.gov.ccs.conclave.data.migration.client.CiiOrgClient;
import uk.gov.ccs.conclave.data.migration.client.ConclaveClient;
import uk.gov.ccs.conclave.data.migration.domain.Org;
import uk.gov.ccs.swagger.cii.ApiException;
import uk.gov.ccs.swagger.cii.model.Address;
import uk.gov.ccs.swagger.cii.model.Identifier;
import uk.gov.ccs.swagger.cii.model.OrgMigration;
import uk.gov.ccs.swagger.dataMigration.model.Organisation;
import uk.gov.ccs.swagger.dataMigration.model.User;
import uk.gov.ccs.swagger.dataMigration.model.UserRoles;
import uk.gov.ccs.swagger.sso.model.OrganisationAddress;
import uk.gov.ccs.swagger.sso.model.OrganisationDetail;
import uk.gov.ccs.swagger.sso.model.OrganisationIdentifier;
import uk.gov.ccs.swagger.sso.model.OrganisationProfileInfo;
import uk.gov.ccs.swagger.dataMigration.model.OrgRoles;

import java.util.ArrayList;
import java.util.List;

import static uk.gov.ccs.conclave.data.migration.service.ErrorService.*;

@Service
@RequiredArgsConstructor
public class OrganisationService {

    private final CiiOrgClient ciiOrgClient;

    private final ConclaveClient conclaveClient;

    private final ErrorService errorService;

    private final ContactService contactService;

    private final RoleService roleService;


    public OrgMigrationResponse migrateOrganisation(Organisation org) throws DataMigrationException {
        OrgMigration ciiResponse = migrateOrgToCii(org);
        String organisationId = null;
        Integer identityProviderId = null;
        if (null != ciiResponse) {
            migrateOrgToConclave(ciiResponse, org);
            organisationId = ciiResponse.getOrganisationId();
            identityProviderId = getIdentityProviderIdOfOrganisation(organisationId, org);
        }

        return generateOrgMigrationResponseAndSaveSuccess(org, organisationId, identityProviderId);
    }


    private OrgMigrationResponse generateOrgMigrationResponseAndSaveSuccess(Organisation org, String orgId, Integer idp) {
        OrgMigrationResponse response = null;
        if (idp != null && orgId != null) {
            Org migratedOrg = errorService.saveOrgDetailsWithStatusCode(org, ORG_MIGRATION_SUCCESS, 200);
            response = new OrgMigrationResponse(orgId, idp, migratedOrg);
        }
        return response;
    }


    private OrgMigration migrateOrgToCii(Organisation org) throws DataMigrationException {
        OrgMigration ciiOrganisation = null;
        try {
            ciiOrganisation = ciiOrgClient.createCiiOrganisation(org.getSchemeId(), org.getIdentifierId());

        } catch (ApiException e) {
            if (e.getCode() == 409) {
                ciiOrganisation = new Gson().fromJson(e.getResponseBody(), OrgMigration.class);
            } else {
                errorService.logWithStatus(org, CII_ORG_ERROR_MESSAGE + e.getMessage(), e.getCode());
            }
        }
        return ciiOrganisation;
    }


    private void migrateOrgToConclave(OrgMigration ciiResponse, Organisation org) throws DataMigrationException {

        System.out.println(String.format("HERE -> 11 (checkForAdminOnNewOrg(org)):  %s", checkForAdminOnNewOrg(org)));
        System.out.println(String.format("HERE -> 12 (isNewOrg(ciiResponse)):  %s", isNewOrg(ciiResponse)));
        System.out.println(String.format("HERE -> 13 (org.getUser()):  %s", org.getUser()));
        System.out.println(String.format("HERE -> 14 (org):  %s", org));

        try {
            String organisationId = ciiResponse.getOrganisationId();
            if (isNewOrg(ciiResponse) && checkForAdminOnNewOrg(org) == false) {
                deleteOrganisation(organisationId);
            } else if (isNewOrg(ciiResponse)) {
                OrganisationProfileInfo conclaveOrgProfile = buildOrgProfileRequest(ciiResponse, org);
                conclaveClient.createConclaveOrg(conclaveOrgProfile);
                contactService.migrateOrgContact(org, ciiResponse, organisationId);
                roleService.applyOrganisationRole(organisationId, org.getOrgRoles());
            } else {
                roleService.applyOrganisationRole(organisationId, org.getOrgRoles());
            }

        } catch (uk.gov.ccs.swagger.sso.ApiException e) {
            errorService.logWithStatus(org, SSO_ORG_ERROR_MESSAGE + e.getMessage(), e.getCode());
        }
    }


    private int deleteOrganisation(String organisationId) throws DataMigrationException {
        OrgMigration ciiResponse = deleteOrgFromCii(organisationId);
        if (null != ciiResponse) {
            System.out.println(String.format("HERE -> 10 (ciiResponse):  %s", ciiResponse));
            return 200;
        }
        return 400;
    }


    private OrgMigration deleteOrgFromCii(String organisationId) throws DataMigrationException {
        OrgMigration ciiOrganisation = null;
        try {
            ciiOrganisation = ciiOrgClient.deleteCiiOrganisation(organisationId);

        } catch (ApiException e) {
            errorService.logWithStatusString(organisationId, CII_DEL_ORG_ERROR_MESSAGE + e.getMessage(), e.getCode());   
        }
        return ciiOrganisation;
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
            errorService.logWithStatus(organisation, SSO_IDENTITY_PROVIDER_ERROR_MESSAGE + e.getMessage(), e.getCode());

        }
        return identityProviderId;
    }

    private Boolean checkForAdminOnNewOrg(final Organisation organisation) {
        for (User user : organisation.getUser()) {
            System.out.println(String.format("HERE -> A (user):  %s", user));
            for (UserRoles userRole : user.getUserRoles()) {
                System.out.println(String.format("HERE -> B (userRole):  %s", userRole));
                System.out.println(String.format("HERE -> C (userRole.getName()):  %s", userRole.getName()));
                System.out.println(String.format("HERE -> D (userRole.getName() == Organisation Administrator):  %s", (userRole.getName() == "Organisation Administrator")));
                System.out.println(String.format("HERE -> E (userRole.isUserRoleAdmin()):  %s", userRole.isUserRoleAdmin()));
                if (userRole.getName() == "Organisation Administrator") {
                    return true;
                }
            }
        }
        System.out.println(String.format("HERE -> X (FALSE):  %s", false));
        return false;
    }

}
