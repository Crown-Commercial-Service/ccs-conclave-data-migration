package uk.gov.ccs.conclave.data.migration.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import uk.gov.ccs.conclave.data.migration.domain.Org;
import uk.gov.ccs.conclave.data.migration.domain.User;
import uk.gov.ccs.conclave.data.migration.repository.OrganisationRepository;
import uk.gov.ccs.conclave.data.migration.repository.UserRepository;
import uk.gov.ccs.swagger.dataMigration.model.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ErrorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorService.class);

    public static final String CII_ORG_ERROR_MESSAGE = "Error while creating CII organisation. ";
    public static final String SSO_ORG_ERROR_MESSAGE = "Error while creating SSO Organisation. ";
    public static final String SSO_ORG_CONTACT_ERROR_MESSAGE = "Error while creating SSO Organisation Contact. ";


    private final OrganisationRepository organisationRepository;

    private final UserRepository userRepository;


    public ErrorService(OrganisationRepository organisationRepository, UserRepository userRepository) {
        this.organisationRepository = organisationRepository;
        this.userRepository = userRepository;
    }


    public void logError(Organisation organisation, String message, Integer statusCode) {
        LOGGER.error(message);
        saveError(organisation, message, statusCode);

    }

    private void saveError(Organisation organisation, String message, Integer statusCode) {
        Org org = populateOrganisationWithStatus(organisation, message, statusCode);
        Org savedOrg = organisationRepository.save(org);
        List<uk.gov.ccs.swagger.dataMigration.model.User> usersDto = organisation.getUser();
        if (null != usersDto) {
            Set<User> usersSet = populateUsersWithStatus(message, statusCode, usersDto, savedOrg);
            userRepository.saveAll(usersSet);
        }
    }

    private Set<User> populateUsersWithStatus(String message, Integer statusCode, List<uk.gov.ccs.swagger.dataMigration.model.User> usersDto, Org org) {
        Set<User> userList = new HashSet<>();
        usersDto.forEach(u -> {
            User user = new User();
            user.setFirstName(u.getFirstName());
            user.setLastName(u.getLastName());
            user.setTitle(u.getTitle());
            user.setEmail(u.getEmail());
            var userRoles = u.getUserRoles();
            if (null != userRoles) {
                var roles = userRoles.stream().map(UserRoles::getName).collect(Collectors.toList());
                user.setUserRoles(String.join(",", roles));
            }
            user.setContactEmail(u.getContactEmail());
            user.setContactMobile(u.getContactMobile());
            user.setContactPhone(u.getContactPhone());
            user.setContactFax(u.getContactFax());
            user.setContactSocial(u.getContactSocial());
            user.setStatus(statusCode);
            user.setStatusDescription(message);
            user.setOrg(org);
            userList.add(user);

        });
        return userList;

    }

    private Org populateOrganisationWithStatus(Organisation organisation, String message, Integer statusCode) {
        Org org = new Org();
        org.setIdentifierId(organisation.getIdentifierId());
        org.setSchemeId(organisation.getSchemeId());
        org.setRightToBuy(organisation.isRightToBuy());
        var orgRoles = organisation.getOrgRoles();
        if (null != orgRoles) {
            var roles = orgRoles.stream().map(OrgRoles::getName).collect(Collectors.toList());
            org.setOrgRoles(String.join(",", roles));
        }
        org.setStatus(statusCode);
        org.setStatusDescription(message);
        return org;
    }

}
