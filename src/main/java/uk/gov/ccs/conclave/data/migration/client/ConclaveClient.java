package uk.gov.ccs.conclave.data.migration.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import uk.gov.ccs.swagger.sso.ApiException;
import uk.gov.ccs.swagger.sso.api.OrganisationApi;
import uk.gov.ccs.swagger.sso.api.UserApi;
import uk.gov.ccs.swagger.sso.model.IdentityProviderDetail;
import uk.gov.ccs.swagger.sso.model.OrganisationProfileInfo;
import uk.gov.ccs.swagger.sso.model.UserEditResponseInfo;
import uk.gov.ccs.swagger.sso.model.UserProfileEditRequestInfo;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ConclaveClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConclaveClient.class);

    final UserApi userApi;

    final OrganisationApi orgApi;

    public ConclaveClient(UserApi userApi, OrganisationApi orgApi) {
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

    public Integer getIdentityProviderId(final String organisationId) throws ApiException {
        LOGGER.info("Getting organisation identity provider Id");
        List<IdentityProviderDetail> identityProviders = orgApi.organisationsOrganisationIdIdentityProvidersGet(organisationId);
        return identityProviders.stream().filter(idp -> idp.getName().equalsIgnoreCase("User ID and password")).collect(Collectors.toList()).get(0).getId();

    }

}
