package uk.gov.ccs.conclave.data.migration.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import uk.gov.ccs.swagger.sso.ApiException;
import uk.gov.ccs.swagger.sso.api.OrganisationApi;
import uk.gov.ccs.swagger.sso.api.UserApi;
import uk.gov.ccs.swagger.sso.model.OrganisationProfileInfo;
import uk.gov.ccs.swagger.sso.model.UserEditResponseInfo;
import uk.gov.ccs.swagger.sso.model.UserProfileEditRequestInfo;

@Component
public class ConclaveUserClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConclaveUserClient.class);

    final UserApi userApi;

    final OrganisationApi orgApi;

    public ConclaveUserClient(UserApi userApi, OrganisationApi orgApi) {
        this.userApi = userApi;
        this.orgApi = orgApi;
    }


    public UserEditResponseInfo createUser(final UserProfileEditRequestInfo userDto) throws ApiException {
        LOGGER.info("Creating a conclave user.");
        return userApi.usersPost(userDto);
    }

    public String createConclaveOrg(final OrganisationProfileInfo orgDto) throws ApiException {
        LOGGER.info("Creating a conclave organisation.");
        return orgApi.organisationsPost(orgDto);
    }

}
