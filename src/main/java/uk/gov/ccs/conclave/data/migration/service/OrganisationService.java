package uk.gov.ccs.conclave.data.migration.service;

import org.springframework.stereotype.Service;
import uk.gov.ccs.conclave.data.migration.client.CiiOrgClient;
import uk.gov.ccs.conclave.data.migration.client.ConclaveClient;
import uk.gov.ccs.swagger.cii.ApiException;
import uk.gov.ccs.swagger.cii.model.Address;
import uk.gov.ccs.swagger.cii.model.ContactPoint;
import uk.gov.ccs.swagger.cii.model.Identifier;
import uk.gov.ccs.swagger.cii.model.OrgMigration;
import uk.gov.ccs.swagger.dataMigration.model.Organisation;
import uk.gov.ccs.swagger.sso.model.*;

import java.util.ArrayList;
import java.util.List;

import static uk.gov.ccs.conclave.data.migration.service.ErrorService.*;

@Service
public class OrganisationService {

    private final CiiOrgClient ciiOrgClient;

    private final ConclaveClient conclaveClient;

    final ErrorService errorService;

    public OrganisationService(CiiOrgClient ciiOrgClient, ConclaveClient conclaveClient, ErrorService errorService) {
        this.ciiOrgClient = ciiOrgClient;
        this.conclaveClient = conclaveClient;
        this.errorService = errorService;
    }


    public String migrateOrganisation(Organisation org) {
        OrgMigration ciiResponse = migrateOrgToCii(org);
        String organisationId = null;
        if (null != ciiResponse) {
            organisationId = migrateOrgToConclave(ciiResponse, org);

            if (organisationId != null) {
                migrateOrgContact(org, ciiResponse, organisationId);
            }
        }

        return organisationId;
    }

    private void migrateOrgContact(Organisation org, OrgMigration ciiResponse, String organisationId) {
        ContactPoint contactPoint = ciiResponse.getContactPoint();
        if (isOrgContactDetailPresent(contactPoint)) {
            try {
                conclaveClient.createOrganisationContact(organisationId, populateContact(contactPoint));
            } catch (uk.gov.ccs.swagger.sso.ApiException e) {
                errorService.logWithStatus(org, SSO_ORG_CONTACT_ERROR_MESSAGE + e.getMessage(), e.getCode());
            }
        }
    }

    private boolean isOrgContactDetailPresent(ContactPoint contactPoint) {
        return (!contactPoint.getName().isEmpty()
                || !contactPoint.getEmail().isEmpty()
                || !contactPoint.getTelephone().isEmpty()
                || !contactPoint.getFaxNumber().isEmpty()
                || !contactPoint.getUri().isEmpty());
    }

    private ContactRequestInfo populateContact(ContactPoint contactPoint) {

        ContactRequestInfo contactRequestInfo = new ContactRequestInfo();
        contactRequestInfo.setContactPointName(contactPoint.getName());
        List<ContactRequestDetail> contacts = new ArrayList<>();
        contacts.add(createContact("EMAIL", contactPoint.getEmail()));
        contacts.add(createContact("PHONE", contactPoint.getTelephone()));
        contacts.add(createContact("FAX", contactPoint.getFaxNumber()));
        contacts.add(createContact("WEB_ADDRESS", contactPoint.getUri()));
        contactRequestInfo.setContacts(contacts);

        return contactRequestInfo;

    }

    private ContactRequestDetail createContact(String name, String value) {
        ContactRequestDetail contactRequestDetail = new ContactRequestDetail();
        contactRequestDetail.setContactType(name);
        contactRequestDetail.setContactValue(value);
        return contactRequestDetail;
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

    private String migrateOrgToConclave(OrgMigration ciiResponse, Organisation org) {
        OrganisationProfileInfo conclaveOrgProfile = populateConclaveOrg(ciiResponse, org);
        String conclaveOrgId = null;
        try {
            conclaveOrgId = conclaveClient.createConclaveOrg(conclaveOrgProfile);

        } catch (uk.gov.ccs.swagger.sso.ApiException e) {
            errorService.logWithStatus(org, SSO_ORG_ERROR_MESSAGE + e.getMessage(), e.getCode());
        }
        return conclaveOrgId;
    }

    private OrganisationProfileInfo populateConclaveOrg(OrgMigration ciiResponse, Organisation org) {
        Identifier identifier = ciiResponse.getIdentifier();
        Address address = ciiResponse.getAddress();

        OrganisationProfileInfo conclaveOrgProfile = new OrganisationProfileInfo();

        OrganisationAddress organisationAddress = populateOrgAddress(address);
        conclaveOrgProfile.setAddress(organisationAddress);

        OrganisationIdentifier organisationIdentifier = populateOrgIdentifier(identifier);
        conclaveOrgProfile.setIdentifier(organisationIdentifier);

        OrganisationDetail organisationDetail = populateOrgDetail(ciiResponse, org);
        conclaveOrgProfile.setDetail(organisationDetail);

        return conclaveOrgProfile;
    }

    private OrganisationDetail populateOrgDetail(OrgMigration ciiResponse, Organisation org) {
        OrganisationDetail organisationDetail = new OrganisationDetail();
        organisationDetail.setOrganisationId(ciiResponse.getOrganisationId());
        organisationDetail.setRightToBuy(org.isRightToBuy());
        return organisationDetail;
    }

    private OrganisationIdentifier populateOrgIdentifier(Identifier ciiIdentifier) {
        OrganisationIdentifier organisationIdentifier = new OrganisationIdentifier();
        organisationIdentifier.setLegalName(ciiIdentifier.getLegalName());
        organisationIdentifier.setUri(ciiIdentifier.getUri());
        return organisationIdentifier;
    }

    private OrganisationAddress populateOrgAddress(Address ciiAddress) {
        OrganisationAddress organisationAddress = new OrganisationAddress();
        organisationAddress.setStreetAddress(ciiAddress.getStreetAddress());
        organisationAddress.setLocality(ciiAddress.getLocality());
        organisationAddress.setPostalCode(ciiAddress.getPostalCode());
        organisationAddress.setRegion(ciiAddress.getRegion());
        return organisationAddress;
    }


}
