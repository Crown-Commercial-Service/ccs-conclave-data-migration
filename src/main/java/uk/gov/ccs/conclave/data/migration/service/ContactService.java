package uk.gov.ccs.conclave.data.migration.service;

import org.springframework.stereotype.Service;
import uk.gov.ccs.conclave.data.migration.client.ConclaveClient;
import uk.gov.ccs.swagger.cii.model.ContactPoint;
import uk.gov.ccs.swagger.cii.model.OrgMigration;
import uk.gov.ccs.swagger.dataMigration.model.Organisation;
import uk.gov.ccs.swagger.sso.model.ContactRequestDetail;
import uk.gov.ccs.swagger.sso.model.ContactRequestInfo;

import java.util.ArrayList;
import java.util.List;

import static uk.gov.ccs.conclave.data.migration.service.ErrorService.SSO_ORG_CONTACT_ERROR_MESSAGE;

@Service
public class ContactService {

    private final ConclaveClient conclaveClient;

    private final ErrorService errorService;

    public ContactService(ConclaveClient conclaveClient, ErrorService errorService) {
        this.conclaveClient = conclaveClient;
        this.errorService = errorService;
    }

     void migrateOrgContact(Organisation org, OrgMigration ciiResponse, String organisationId) {
        ContactPoint contactPoint = ciiResponse.getContactPoint();
        if (isOrgContactDetailPresent(contactPoint)) {
            try {
                conclaveClient.createOrganisationContact(organisationId, buildContactRequestInfo(contactPoint));
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

    private ContactRequestInfo buildContactRequestInfo(ContactPoint contactPoint) {

        ContactRequestInfo contactRequestInfo = new ContactRequestInfo();
        contactRequestInfo.setContactPointName(contactPoint.getName());
        List<ContactRequestDetail> contacts = new ArrayList<>();
        contacts.add(buildContactRequestDetail("EMAIL", contactPoint.getEmail()));
        contacts.add(buildContactRequestDetail("PHONE", contactPoint.getTelephone()));
        contacts.add(buildContactRequestDetail("FAX", contactPoint.getFaxNumber()));
        contacts.add(buildContactRequestDetail("WEB_ADDRESS", contactPoint.getUri()));
        contactRequestInfo.setContacts(contacts);

        return contactRequestInfo;

    }

    private ContactRequestDetail buildContactRequestDetail(String name, String value) {
        ContactRequestDetail contactRequestDetail = new ContactRequestDetail();
        contactRequestDetail.setContactType(name);
        contactRequestDetail.setContactValue(value);
        return contactRequestDetail;
    }
}
