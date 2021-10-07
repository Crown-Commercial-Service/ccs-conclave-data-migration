package uk.gov.ccs.conclave.data.migration.service;

import org.springframework.stereotype.Service;
import uk.gov.ccs.conclave.data.migration.client.CiiOrgClient;
import uk.gov.ccs.conclave.data.migration.client.ConclaveClient;
import uk.gov.ccs.conclave.data.migration.domain.Org;
import uk.gov.ccs.swagger.cii.ApiException;
import uk.gov.ccs.swagger.cii.model.Address;
import uk.gov.ccs.swagger.cii.model.Identifier;
import uk.gov.ccs.swagger.cii.model.OrgMigration;
import uk.gov.ccs.swagger.dataMigration.model.Organisation;
import uk.gov.ccs.swagger.sso.model.OrganisationAddress;
import uk.gov.ccs.swagger.sso.model.OrganisationDetail;
import uk.gov.ccs.swagger.sso.model.OrganisationIdentifier;
import uk.gov.ccs.swagger.sso.model.OrganisationProfileInfo;

import static uk.gov.ccs.conclave.data.migration.service.ErrorService.*;

@Service
public class OrganisationService {

    private final CiiOrgClient ciiOrgClient;

    private final ConclaveClient conclaveClient;

    private final ErrorService errorService;

    private final ContactService contactService;

    public OrganisationService(CiiOrgClient ciiOrgClient, ConclaveClient conclaveClient, ErrorService errorService, ContactService contactService) {
        this.ciiOrgClient = ciiOrgClient;
        this.conclaveClient = conclaveClient;
        this.errorService = errorService;
        this.contactService = contactService;
    }


    public OrgMigrationResponse migrateOrganisation(Organisation org) {
        OrgMigration ciiResponse = migrateOrgToCii(org);
        OrgMigrationResponse response = null;
        if (null != ciiResponse && ciiResponse.getOrganisationId() != null && ciiResponse.getIdentifier() != null) {
            response = migrateOrgToConclave(ciiResponse, org);
        }
        return response;
    }

    private OrgMigrationResponse generateOrgMigrationResponseAndSaveSuccess(Organisation org, String ssoOrgId, Integer idp) {
        OrgMigrationResponse response = null;
        if (idp != null) {
            Org migratedOrg = errorService.saveOrgDetailsWithStatusCode(org, ORG_MIGRATION_SUCCESS, 200);
            response = new OrgMigrationResponse(ssoOrgId, idp, migratedOrg);
        }
        return response;
    }


    private OrgMigration migrateOrgToCii(Organisation org) {
        OrgMigration ciiOrganisation = null;
        try {
            ciiOrganisation = ciiOrgClient.createCiiOrganisation(org.getSchemeId(), org.getIdentifierId());

        } catch (ApiException e) {
            errorService.logWithStatus(org, CII_ORG_ERROR_MESSAGE + e.getMessage(), e.getCode());

        }
        return ciiOrganisation;
    }

    private OrgMigrationResponse migrateOrgToConclave(OrgMigration ciiResponse, Organisation org) {
        OrganisationProfileInfo conclaveOrgProfile = buildOrgProfileRequest(ciiResponse, org);
        String ssoOrgId;
        OrgMigrationResponse response = null;
        try {
            ssoOrgId = conclaveClient.createConclaveOrg(conclaveOrgProfile);
            if (ssoOrgId != null) {
                contactService.migrateOrgContact(org, ciiResponse, ssoOrgId);
                Integer identityProviderId = getIdentityProviderIdOfOrganisation(ssoOrgId, org);
                response = generateOrgMigrationResponseAndSaveSuccess(org, ssoOrgId, identityProviderId);
            }

        } catch (uk.gov.ccs.swagger.sso.ApiException e) {
            errorService.logWithStatus(org, SSO_ORG_ERROR_MESSAGE + e.getMessage(), e.getCode());
        }
        return response;
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

    private Integer getIdentityProviderIdOfOrganisation(String organisationId, Organisation organisation) {
        Integer identityProviderId = null;
        try {
            identityProviderId = conclaveClient.getIdentityProviderId(organisationId);
        } catch (uk.gov.ccs.swagger.sso.ApiException e) {
            errorService.logWithStatus(organisation, SSO_IDENTITY_PROVIDER_ERROR_MESSAGE + e.getMessage(), e.getCode());

        }
        return identityProviderId;
    }

}
