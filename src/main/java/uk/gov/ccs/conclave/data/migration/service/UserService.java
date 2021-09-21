package uk.gov.ccs.conclave.data.migration.service;

import org.springframework.stereotype.Service;
import uk.gov.ccs.conclave.data.migration.client.ConclaveClient;
import uk.gov.ccs.conclave.data.migration.domain.Org;
import uk.gov.ccs.swagger.dataMigration.model.Organisation;
import uk.gov.ccs.swagger.dataMigration.model.User;
import uk.gov.ccs.swagger.sso.ApiException;
import uk.gov.ccs.swagger.sso.model.UserProfileEditRequestInfo;
import uk.gov.ccs.swagger.sso.model.UserRequestDetail;
import uk.gov.ccs.swagger.sso.model.UserTitle;

import java.util.List;

import static uk.gov.ccs.conclave.data.migration.service.ErrorService.SSO_IDENTITY_PROVIDER_ERROR_MESSAGE;
import static uk.gov.ccs.conclave.data.migration.service.ErrorService.SSO_USER_ERROR_MESSAGE;

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

    public void migrateUsers(Organisation organisation, String organisationId) {
        List<User> users = organisation.getUser();
        Integer identityProviderId;
        Org org = null;
        try {
            identityProviderId = conclaveUserClient.getIdentityProviderId(organisationId);
            for (User user : users) {
                UserProfileEditRequestInfo userDto = populateUserProfileInfo(user, organisationId, identityProviderId);
                try {
                    conclaveUserClient.createUser(userDto);
                } catch (ApiException e) {
                    if (org == null) {
                        org = errorService.saveOrgDetailsWithStatusCode(organisation, SSO_USER_ERROR_MESSAGE + e.getMessage(), e.getCode());
                    }
                    errorService.saveUserDetailWithStatusCode(user, SSO_USER_ERROR_MESSAGE + e.getMessage(), e.getCode(), org);
                }
            }

            errorService.saveOrgDetailsWithStatusCode(organisation, "Success", 200);

        } catch (ApiException e) {
            errorService.logWithStatus(organisation, SSO_IDENTITY_PROVIDER_ERROR_MESSAGE + e.getMessage(), e.getCode());
        }

    }
}
