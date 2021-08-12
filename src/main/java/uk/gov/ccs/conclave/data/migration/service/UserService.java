package uk.gov.ccs.conclave.data.migration.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import uk.gov.ccs.conclave.data.migration.client.ConclaveClient;
import uk.gov.ccs.swagger.dataMigration.model.User;
import uk.gov.ccs.swagger.sso.ApiException;
import uk.gov.ccs.swagger.sso.model.UserProfileEditRequestInfo;
import uk.gov.ccs.swagger.sso.model.UserRequestDetail;
import uk.gov.ccs.swagger.sso.model.UserTitle;

import java.util.List;
@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final ConclaveClient conclaveUserClient;

    public UserService(ConclaveClient conclaveUserClient) {
        this.conclaveUserClient = conclaveUserClient;
    }

    private UserProfileEditRequestInfo populateUserProfileInfo(User user, String organisationId, Integer identityProvideId) {

        UserProfileEditRequestInfo userDto = new UserProfileEditRequestInfo();
        userDto.setTitle(UserTitle.valueOf(user.getTitle()));
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setUserName(user.getEmail());
        userDto.setOrganisationId(organisationId);
        UserRequestDetail detail = new UserRequestDetail();
        detail.setIdentityProviderId(identityProvideId);
        userDto.setDetail(detail);
        return userDto;
    }

    public void migrateUsers(List<User> users, String organisationId) throws ApiException {
            Integer identityProviderId = conclaveUserClient.getIdentityProviderId(organisationId);
            for (User user : users) {
                UserProfileEditRequestInfo userDto = populateUserProfileInfo(user, organisationId, 1147);
                conclaveUserClient.createUser(userDto);
            }

    }
}
