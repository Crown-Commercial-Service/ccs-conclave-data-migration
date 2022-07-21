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

        System.out.println(String.format("\n\n HERE -> 0 (user.getContactEmail()):  %s \n\n", user.getContactEmail()));
        System.out.println(String.format("\n\n HERE -> 1 (user.getContactPointName()):  %s \n\n", user.getContactPointName()));
        System.out.println(String.format("\n\n HERE -> 2 (user.getContactPointName()):  %s \n\n", user.getContactPointName()));
        System.out.println(String.format("\n\n HERE -> 3 (user.getContactFax()):  %s \n\n", user.getContactFax()));
        System.out.println(String.format("\n\n HERE -> 4 (user.getContactPhone()):  %s \n\n", user.getContactPhone()));
        System.out.println(String.format("\n\n HERE -> 5 (user.getContactMobile()):  %s \n\n", user.getContactMobile()));
        System.out.println(String.format("\n\n HERE -> 6 (user.getContactSocial()):  %s \n\n", user.getContactSocial()));

        System.out.println(String.format("\n\n HERE -> 7 (stripToEmpty(user.getContactFax())):  %s \n\n", stripToEmpty(user.getContactFax())));
        System.out.println(String.format("\n\n HERE -> 8 (stripToEmpty(user.getContactEmail())):  %s \n\n", stripToEmpty(user.getContactEmail())));

        ContactPoint ciiUserContactPoint = new ContactPoint()
                .name(user.getContactPointName())
                .email(stripToEmpty(user.getContactEmail()))
                .faxNumber(stripToEmpty(user.getContactFax()).replaceAll("[- ()]", ""))
                .telephone(stripToEmpty(user.getContactPhone()).replaceAll("[- ()]", ""))
                .mobile(stripToEmpty(user.getContactMobile()).replaceAll("[- ()]", ""))
                .uri(stripToEmpty(user.getContactSocial()));

        System.out.println(String.format("\n\n HERE -> 9 (isContactDetailPresent(ciiUserContactPoint)):  %s \n\n", isContactDetailPresent(ciiUserContactPoint)));

        if (isContactDetailPresent(ciiUserContactPoint)) {
            try {
                conclaveClient.createUserContact(userId, buildContactRequestInfo(ciiUserContactPoint));
            } catch (uk.gov.ccs.swagger.sso.ApiException e) {
                log.error("{}{}: {}", SSO_USER_CONTACT_ERROR_MESSAGE, e.getMessage(), e.getResponseBody());
                errorService.saveUserDetailWithStatusCode(user, SSO_USER_CONTACT_ERROR_MESSAGE + e.getMessage(), e.getCode(), organisation);
            }
        } else {
            System.out.println("\n\n HERE -> 10  REPORT ERROR TO DATABASE?!?! \n\n");
            log.error("{}: {}", SSO_USER_CONTACT_ERROR_MESSAGE, "Incomplete Contact Details");
            errorService.saveUserDetailWithStatusCode(user, SSO_USER_CONTACT_ERROR_MESSAGE + "Incomplete Contact Details", 400, organisation);
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
