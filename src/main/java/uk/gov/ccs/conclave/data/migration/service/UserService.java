package uk.gov.ccs.conclave.data.migration.service;

import org.springframework.stereotype.Service;
import uk.gov.ccs.conclave.data.migration.client.ConclaveClient;
import uk.gov.ccs.swagger.dataMigration.model.User;
import uk.gov.ccs.swagger.sso.ApiException;
import uk.gov.ccs.swagger.sso.model.UserProfileEditRequestInfo;
import uk.gov.ccs.swagger.sso.model.UserRequestDetail;
import uk.gov.ccs.swagger.sso.model.UserTitle;

import java.util.List;

import static uk.gov.ccs.conclave.data.migration.service.ErrorService.SSO_USER_ERROR_MESSAGE;
import static uk.gov.ccs.conclave.data.migration.service.ErrorService.USER_MIGRATION_SUCCESS;

@Service
public class UserService {

    private final ConclaveClient conclaveUserClient;

    private final ErrorService errorService;

    public UserService(ConclaveClient conclaveUserClient, ErrorService errorService) {
        this.conclaveUserClient = conclaveUserClient;
        this.errorService = errorService;
    }

    private UserProfileEditRequestInfo populateUserProfileInfo(User user, String organisationId, Integer identityProvideId) {

        UserProfileEditRequestInfo userDto = new UserProfileEditRequestInfo();
        userDto.setTitle(UserTitle.fromValue(user.getTitle()));
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setUserName(user.getEmail());
        userDto.setOrganisationId(organisationId);
        UserRequestDetail detail = new UserRequestDetail();
        detail.setIdentityProviderId(identityProvideId);
        userDto.setDetail(detail);
        return userDto;
    }

    public boolean migrateUsers(List<User> users, OrgMigrationResponse response) {
        boolean status = true;
        for (User user : users) {
            UserProfileEditRequestInfo userDto = populateUserProfileInfo(user, response.getOrganisationId(), response.getIdentityProviderId());
            try {
                conclaveUserClient.createUser(userDto);
                errorService.saveUserDetailWithStatusCode(user, USER_MIGRATION_SUCCESS, 200, response.getOrganisation());

            } catch (ApiException e) {
                status = false;
                errorService.saveUserDetailWithStatusCode(user, SSO_USER_ERROR_MESSAGE + e.getMessage(), e.getCode(), response.getOrganisation());
            }
        }
        return status;
    }


}
