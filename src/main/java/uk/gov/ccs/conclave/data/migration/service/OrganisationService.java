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

@Service
public class OrganisationService {

    private final CiiOrgClient ciiOrgClient;

    private final ConclaveClient conclaveClient;

    public OrganisationService(CiiOrgClient ciiOrgClient, ConclaveClient conclaveClient) {
        this.ciiOrgClient = ciiOrgClient;
        this.conclaveClient = conclaveClient;
    }


    public String migrateOrganisation(Organisation org) throws ApiException, uk.gov.ccs.swagger.sso.ApiException {
        OrgMigration ciiResponse = migrateOrgToCii(org);
        String organisationId = migrateOrgToConclave(ciiResponse, org);
        migrateOrgContact(ciiResponse, organisationId);
        return organisationId;
    }

    private void migrateOrgContact(OrgMigration ciiResponse, String organisationId) throws uk.gov.ccs.swagger.sso.ApiException {
        ContactPoint contactPoint = ciiResponse.getContactPoint();
        if (isOrgContactDetailPresent(contactPoint)) {
            conclaveClient.createOrganisationContact(organisationId, populateContact(contactPoint));
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

    private OrgMigration migrateOrgToCii(Organisation org) throws ApiException {
        return ciiOrgClient.createCiiOrganisation(org.getSchemeId(), org.getIdentifierId());
    }

    private String migrateOrgToConclave(OrgMigration ciiResponse, Organisation org) throws uk.gov.ccs.swagger.sso.ApiException {
        OrganisationProfileInfo conclaveOrgProfile = populateConclaveOrg(ciiResponse, org);
        return conclaveClient.createConclaveOrg(conclaveOrgProfile);
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
