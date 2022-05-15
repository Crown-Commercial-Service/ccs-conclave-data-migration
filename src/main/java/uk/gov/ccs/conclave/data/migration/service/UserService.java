package uk.gov.ccs.conclave.data.migration.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uk.gov.ccs.conclave.data.migration.exception.DataMigrationException;
import uk.gov.ccs.conclave.data.migration.client.ConclaveClient;
import uk.gov.ccs.conclave.data.migration.config.MigrationProperties;
import uk.gov.ccs.swagger.dataMigration.model.User;
import uk.gov.ccs.swagger.sso.ApiException;
import uk.gov.ccs.swagger.sso.model.UserEditResponseInfo;
import uk.gov.ccs.swagger.sso.model.UserProfileEditRequestInfo;
import uk.gov.ccs.swagger.sso.model.UserRequestDetail;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;
import static uk.gov.ccs.conclave.data.migration.service.ErrorService.SSO_USER_ERROR_MESSAGE;
import static uk.gov.ccs.conclave.data.migration.service.ErrorService.USER_MIGRATION_SUCCESS;
import static uk.gov.ccs.swagger.sso.model.UserTitle.fromValue;

@Service
@RequiredArgsConstructor
public class UserService {

    private final ConclaveClient conclaveUserClient;

    private final ErrorService errorService;

    private final MigrationProperties properties;

    private final ContactService contactService;

    private final RoleService roleService;

    private UserProfileEditRequestInfo populateUserProfileInfo(User user, String organisationId, Integer identityProvideId, List<Integer> roleIds) {

        UserProfileEditRequestInfo userDto = new UserProfileEditRequestInfo();
        userDto.setTitle(fromValue(user.getTitle()));
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setUserName(user.getEmail());
        userDto.setOrganisationId(organisationId);
        userDto.sendUserRegistrationEmail(properties.isSendUserRegistrationEmail());
        userDto.setAccountVerified(properties.isAccountVerified());
        UserRequestDetail detail = new UserRequestDetail();
        detail.setIdentityProviderIds(singletonList(identityProvideId));
        if (isNotEmpty(roleIds)) {
            detail.setRoleIds(roleIds);
        }
        userDto.setDetail(detail);

        System.out.println("XC127");

        if (user.isRoleAdmin(roleIds)) {
            System.out.println("WZ310");
            userDto.setMfaEnabled(true);
        }

        return userDto;
    }

    public long migrateUsers(List<User> users, OrgMigrationResponse response) throws DataMigrationException {
        long userFailureCount = 0;
        for (User user : users) {
            try {
                var roleIds = roleService.getUserRoleIdsFromRoleNames(response.getOrganisationId(), user.getUserRoles());
                UserProfileEditRequestInfo userDto = populateUserProfileInfo(user, response.getOrganisationId(), response.getIdentityProviderId(), roleIds);

                UserEditResponseInfo userInfo = conclaveUserClient.createUser(userDto);
                contactService.migrateUserContact(user, userInfo.getUserId(), response.getOrganisation());
                errorService.saveUserDetailWithStatusCode(user, USER_MIGRATION_SUCCESS, 200, response.getOrganisation());

            } catch (ApiException e) {
                userFailureCount++;
                errorService.saveUserDetailWithStatusCode(user, SSO_USER_ERROR_MESSAGE + e.getMessage(), e.getCode(), response.getOrganisation());
            }
        }
        return userFailureCount;
    }


}
