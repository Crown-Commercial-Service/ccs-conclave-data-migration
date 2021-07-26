package uk.gov.ccs.conclave.data.migration.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import uk.gov.ccs.swagger.sso.ApiException;
import uk.gov.ccs.swagger.sso.api.UserApi;
import uk.gov.ccs.swagger.sso.model.UserEditResponseInfo;
import uk.gov.ccs.swagger.sso.model.UserProfileEditRequestInfo;

@Component
public class ConclaveUserClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConclaveUserClient.class);

    final UserApi userApi;

    public ConclaveUserClient(UserApi userApi) {
        this.userApi = userApi;
    }


    public UserEditResponseInfo createUser(final UserProfileEditRequestInfo userDto) throws ApiException {
        LOGGER.info("Creating a conclave user.");
        return userApi.usersPost(userDto);
    }

}
