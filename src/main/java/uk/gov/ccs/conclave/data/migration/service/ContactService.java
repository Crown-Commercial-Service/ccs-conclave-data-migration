package uk.gov.ccs.conclave.data.migration.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import uk.gov.ccs.conclave.data.migration.client.ConclaveClient;
import uk.gov.ccs.conclave.data.migration.domain.Org;
import uk.gov.ccs.conclave.data.migration.exception.DataMigrationException;
import uk.gov.ccs.swagger.cii.model.ContactPoint;
import uk.gov.ccs.swagger.cii.model.OrgMigration;
import uk.gov.ccs.swagger.dataMigration.model.Organisation;
import uk.gov.ccs.swagger.dataMigration.model.User;
import uk.gov.ccs.swagger.sso.model.ContactRequestDetail;
import uk.gov.ccs.swagger.sso.model.ContactRequestInfo;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;
import static org.apache.commons.lang3.StringUtils.stripToEmpty;
import static uk.gov.ccs.conclave.data.migration.service.ErrorService.SSO_ORG_CONTACT_ERROR_MESSAGE;
import static uk.gov.ccs.conclave.data.migration.service.ErrorService.SSO_USER_CONTACT_ERROR_MESSAGE;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ConclaveClient conclaveClient;

    private final ErrorService errorService;

    private static final Logger log = LoggerFactory.getLogger(ContactService.class);

    void migrateUserContact(User user, String userId, Org organisation) throws DataMigrationException {
        ContactPoint ciiUserContactPoint = new ContactPoint()
                .name(user.getContactName())
                .email(stripToEmpty(user.getContactEmail()))
                .faxNumber(stripToEmpty(user.getContactFax()).replaceAll("(-| |\\(|\\))", ""))
                .telephone(stripToEmpty(user.getContactPhone()).replaceAll("(-| |\\(|\\))", ""))
                .mobile(stripToEmpty(user.getContactMobile()).replaceAll("(-| |\\(|\\))", ""))
                .uri(stripToEmpty(user.getContactSocial()));

        if (isContactDetailPresent(ciiUserContactPoint)) {
            try {
                conclaveClient.createUserContact(userId, buildContactRequestInfo(ciiUserContactPoint));
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
        return (isNotEmpty(contactPoint.getName()) &&
                  (isNotEmpty(contactPoint.getEmail())
                    || isNotEmpty(contactPoint.getTelephone())
                    || isNotEmpty(contactPoint.getMobile())
                    || isNotEmpty(contactPoint.getFaxNumber())
                    || isNotEmpty(contactPoint.getUri())));
    }

    private ContactRequestInfo buildContactRequestInfo(ContactPoint contactPoint) {
        ContactRequestInfo contactRequestInfo = new ContactRequestInfo().contactPointName(contactPoint.getName());
        List<ContactRequestDetail> contacts = new ArrayList<>();
        if (isNotEmpty(contactPoint.getEmail())) {
            contacts.add(new ContactRequestDetail().contactType("EMAIL").contactValue(contactPoint.getEmail()));
        }
        if (isNotEmpty(contactPoint.getTelephone())) {
            contacts.add(new ContactRequestDetail().contactType("PHONE").contactValue(contactPoint.getTelephone()));
        }
        if (isNotEmpty(contactPoint.getMobile())) {
            contacts.add(new ContactRequestDetail().contactType("MOBILE").contactValue(contactPoint.getMobile()));
        }
        if (isNotEmpty(contactPoint.getFaxNumber())) {
            contacts.add(new ContactRequestDetail().contactType("FAX").contactValue(contactPoint.getFaxNumber()));
        }
        if (isNotEmpty(contactPoint.getUri())) {
            contacts.add(new ContactRequestDetail().contactType("WEB_ADDRESS").contactValue(contactPoint.getUri()));
        }
        contactRequestInfo.setContacts(contacts);

        return contactRequestInfo;
    }
}
