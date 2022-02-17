package uk.gov.ccs.conclave.data.migration.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import uk.gov.ccs.conclave.data.migration.domain.Org;
import uk.gov.ccs.conclave.data.migration.domain.User;
import uk.gov.ccs.conclave.data.migration.repository.OrganisationRepository;
import uk.gov.ccs.conclave.data.migration.repository.UserRepository;
import uk.gov.ccs.swagger.dataMigration.model.OrgRoles;
import uk.gov.ccs.swagger.dataMigration.model.Organisation;
import uk.gov.ccs.swagger.dataMigration.model.UserRoles;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.ArrayUtils.contains;
import static org.springframework.http.HttpStatus.valueOf;

@Service
@RequiredArgsConstructor
public class ErrorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorService.class);

    public static final String CII_ORG_ERROR_MESSAGE = "Error while creating CII organisation. ";
    public static final String SSO_ORG_ERROR_MESSAGE = "Error while creating SSO Organisation. ";
    public static final String SSO_ORG_CONTACT_ERROR_MESSAGE = "Error while creating SSO Organisation Contact. ";
    public static final String SSO_USER_CONTACT_ERROR_MESSAGE = "Error while creating SSO User Contact. ";
    public static final String SSO_USER_ERROR_MESSAGE = "Error while creating SSO user. ";
    public static final String SSO_ROLE_NOT_FOUND = " Role does not exist. ";
    public static final String SSO_IDENTITY_PROVIDER_ERROR_MESSAGE = "Error while retrieving identity provider of the SSO organisation. ";
    public static final String ORG_MIGRATION_SUCCESS = "Organisation migrated successfully. ";
    public static final String USER_MIGRATION_SUCCESS = "User migrated successfully. ";
    public static final String MIGRATION_STATUS_PARTIAL = "Completed with errors. ";
    public static final String MIGRATION_STATUS_COMPLETE = "Completed with no errors. ";
    static final int[] FATAL_ERROR_CODES = new int[]{401, 429, 500, 501, 502, 503, 504, 505};

    private final OrganisationRepository organisationRepository;

    private final UserRepository userRepository;


    public void logWithStatus(Organisation organisation, String message, Integer statusCode) {
        LOGGER.error(message);
        Org savedOrg = saveOrgDetailsWithStatusCode(organisation, message, statusCode);
        saveAllUserDetailsWithStatusCode(organisation, message, statusCode, savedOrg);
        handleFailure(message, statusCode);
    }

    private void handleFailure(String message, Integer statusCode) {
        if (contains(FATAL_ERROR_CODES, statusCode)) {
            throw new ResponseStatusException(valueOf(statusCode), message);
        }
    }

    public Org saveOrgDetailsWithStatusCode(Organisation organisation, String message, Integer statusCode) {
        Org org = populateOrganisationWithStatus(organisation, message, statusCode);
        return organisationRepository.save(org);

    }

    private void saveAllUserDetailsWithStatusCode(Organisation organisation, String message, Integer statusCode, Org savedOrg) {
        List<uk.gov.ccs.swagger.dataMigration.model.User> usersDto = organisation.getUser();
        if (null != usersDto) {
            Set<User> usersSet = populateAllUsersWithStatus(message, statusCode, usersDto, savedOrg);
            userRepository.saveAll(usersSet);
        }
    }

    public void saveUserDetailWithStatusCode(uk.gov.ccs.swagger.dataMigration.model.User user, String message, Integer statusCode, Org savedOrg) {
        User usersSet = populateUserWithStatus(message, statusCode, savedOrg, user);
        userRepository.save(usersSet);
        handleFailure(message, statusCode);
    }


    private Set<User> populateAllUsersWithStatus(String message, Integer statusCode, List<uk.gov.ccs.swagger.dataMigration.model.User> usersDto, Org org) {
        return usersDto.stream().map(u -> populateUserWithStatus(message, statusCode, org, u)).collect(Collectors.toSet());

    }

    private User populateUserWithStatus(String message, Integer statusCode, Org org, uk.gov.ccs.swagger.dataMigration.model.User u) {
        User user = new User();
        user.setFirstName(u.getFirstName());
        user.setLastName(u.getLastName());
        user.setTitle(u.getTitle());
        user.setEmail(u.getEmail());
        var userRoles = u.getUserRoles();
        if (null != userRoles) {
            user.setUserRoles(userRolesAsString(userRoles));
        }
        user.setContactEmail(u.getContactEmail());
        user.setContactMobile(u.getContactMobile());
        user.setContactPhone(u.getContactPhone());
        user.setContactFax(u.getContactFax());
        user.setContactSocial(u.getContactSocial());
        user.setStatus(statusCode);
        user.setStatusDescription(message);
        user.setOrg(org);
        return user;
    }

    private Org populateOrganisationWithStatus(Organisation organisation, String message, Integer statusCode) {
        Org org = new Org();
        org.setIdentifierId(organisation.getIdentifierId());
        org.setSchemeId(organisation.getSchemeId());
        org.setRightToBuy(organisation.isRightToBuy());
        var orgRoles = organisation.getOrgRoles();
        if (null != orgRoles) {
            org.setOrgRoles(orgRolesAsString(orgRoles));
        }
        org.setStatus(statusCode);
        org.setStatusDescription(message);
        return org;
    }

    private String orgRolesAsString(List<OrgRoles> roles) {
        List<String> rolesList = roles.stream().map(OrgRoles::getName).collect(Collectors.toList());
        return String.join(",", rolesList);
    }

    private String userRolesAsString(List<UserRoles> userRoles) {
        var rolesList = userRoles.stream().map(UserRoles::getName).collect(Collectors.toList());
        return String.join(",", rolesList);
    }


}
