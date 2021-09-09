package uk.gov.ccs.conclave.data.migration.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import uk.gov.ccs.swagger.sso.ApiException;
import uk.gov.ccs.swagger.sso.api.OrganisationApi;
import uk.gov.ccs.swagger.sso.api.OrganisationContactApi;
import uk.gov.ccs.swagger.sso.api.UserApi;
import uk.gov.ccs.swagger.sso.model.*;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ConclaveClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConclaveClient.class);

    private final UserApi userApi;

    private final OrganisationApi orgApi;

    private final OrganisationContactApi orgContactApi;

    public ConclaveClient(UserApi userApi, OrganisationApi orgApi, OrganisationContactApi orgContactApi) {
        this.userApi = userApi;
        this.orgApi = orgApi;
        this.orgContactApi = orgContactApi;
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

    public Integer getOrganisationRoleId(final String organisationId, final String roleName) throws ApiException {
        LOGGER.info("Getting roleId for the Organisation role.");
        List<OrganisationRole> roles = orgApi.organisationsOrganisationIdRolesGet(organisationId);
        int roleId = roles.stream().filter(role -> role.getRoleName().equalsIgnoreCase(roleName)).collect(Collectors.toList()).get(0).getRoleId();
        return roleId;

    }

    public void createOrganisationContact(String organisationId, ContactRequestInfo contactRequestInfo) throws ApiException {
        LOGGER.info("Creating a contact for organisation with id " + organisationId);
        orgContactApi.organisationsOrganisationIdContactsPost(organisationId, contactRequestInfo);
    }

}
