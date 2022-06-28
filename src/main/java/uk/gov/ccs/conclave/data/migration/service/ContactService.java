package uk.gov.ccs.conclave.data.migration.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import uk.gov.ccs.conclave.data.migration.exception.DataMigrationException;
import uk.gov.ccs.conclave.data.migration.client.ConclaveClient;
import uk.gov.ccs.conclave.data.migration.domain.Org;
import uk.gov.ccs.swagger.cii.model.ContactPoint;
import uk.gov.ccs.swagger.cii.model.OrgMigration;
import uk.gov.ccs.swagger.dataMigration.model.Organisation;
import uk.gov.ccs.swagger.dataMigration.model.User;
import uk.gov.ccs.swagger.sso.model.ContactRequestDetail;
import uk.gov.ccs.swagger.sso.model.ContactRequestInfo;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.*;
import static uk.gov.ccs.conclave.data.migration.service.ErrorService.*;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ConclaveClient conclaveClient;

    private final ErrorService errorService;

    private static final Logger log = LoggerFactory.getLogger(ContactService.class);

    void migrateUserContact(User user, String userId, Org organisation) throws DataMigrationException {
        ContactPoint userContactPoint = new ContactPoint();
        userContactPoint.setEmail(stripToEmpty(user.getContactEmail()));
        userContactPoint.setFaxNumber(user.getContactFax().replaceAll("(-| |\\(|\\))", ""));
        userContactPoint.setTelephone(user.getContactPhone().replaceAll("(-| |\\(|\\))", ""));
        userContactPoint.setMobile(user.getContactMobile().replaceAll("(-| |\\(|\\))", ""));
        userContactPoint.setUri(stripToEmpty(user.getContactSocial()));
        if (isContactDetailPresent(userContactPoint)) {
            try {
                conclaveClient.createUserContact(userId, buildContactRequestInfo(userContactPoint));
            } catch (uk.gov.ccs.swagger.sso.ApiException e) {
                log.error("{}{}: {}", SSO_USER_CONTACT_ERROR_MESSAGE, e.getMessage(), e.getResponseBody());
                errorService.saveUserDetailWithStatusCode(user, SSO_USER_CONTACT_ERROR_MESSAGE + e.getMessage(), e.getCode(), organisation);
            }
        }
    }

    void migrateOrgContact(Organisation org, OrgMigration ciiResponse, String organisationId) throws DataMigrationException {
        ContactPoint contactPoint = ciiResponse.getContactPoint();
        if (isContactDetailPresent(contactPoint)) {
            try {
                conclaveClient.createOrganisationContact(organisationId, buildContactRequestInfo(contactPoint));
            } catch (uk.gov.ccs.swagger.sso.ApiException e) {
                errorService.logWithStatus(org, SSO_ORG_CONTACT_ERROR_MESSAGE, e, e.getCode());
            }
        }
    }

    private boolean isContactDetailPresent(ContactPoint contactPoint) {
        return (isNotEmpty(contactPoint.getName()))
                || isNotEmpty(contactPoint.getEmail())
                || isNotEmpty(contactPoint.getTelephone())
                || isNotEmpty(contactPoint.getMobile())
                || isNotEmpty(contactPoint.getFaxNumber())
                || isNotEmpty(contactPoint.getUri());
    }

    private ContactRequestInfo buildContactRequestInfo(ContactPoint contactPoint) {

        ContactRequestInfo contactRequestInfo = new ContactRequestInfo();
        contactRequestInfo.setContactPointName(contactPoint.getName());
        List<ContactRequestDetail> contacts = new ArrayList<>();
        contacts.add(buildContactRequestDetail("EMAIL", contactPoint.getEmail()));
        contacts.add(buildContactRequestDetail("PHONE", contactPoint.getTelephone()));
        contacts.add(buildContactRequestDetail("MOBILE", contactPoint.getMobile()));
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
