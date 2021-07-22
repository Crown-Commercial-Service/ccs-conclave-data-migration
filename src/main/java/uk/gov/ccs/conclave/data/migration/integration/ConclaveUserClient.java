package uk.gov.ccs.conclave.data.migration.integration;

import io.swagger.client.ApiException;
import io.swagger.client.api.UserApi;
import io.swagger.client.model.UserEditResponseInfo;
import io.swagger.client.model.UserProfileEditRequestInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConclaveUserClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConclaveUserClient.class);

    @Autowired
    UserApi userApi;


    public UserEditResponseInfo createUser(final UserProfileEditRequestInfo userDto) throws ApiException {
        LOGGER.info("Creating a conclave user.");
        return userApi.usersPost(userDto);
    }

}
