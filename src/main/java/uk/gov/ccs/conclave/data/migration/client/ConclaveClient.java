package uk.gov.ccs.conclave.data.migration.client;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import uk.gov.ccs.swagger.dataMigration.model.User;
import uk.gov.ccs.swagger.sso.ApiException;
import uk.gov.ccs.swagger.sso.api.*;
import uk.gov.ccs.swagger.sso.model.*;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor
public class ConclaveClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConclaveClient.class);

    private final UserApi userApi;

    private final OrganisationApi orgApi;

    private final ConfigurationApi configurationApi;

    private final OrganisationContactApi orgContactApi;

    private final UserContactApi userContactApi;

    private final OrganisationUserApi orgUserApi;


    public UserEditResponseInfo createUser(final UserProfileEditRequestInfo userDto) throws ApiException {
        LOGGER.info("Creating a conclave user.");
        return userApi.usersPost(userDto);
    }

    public UserProfileResponseInfo getUser(final User user) throws ApiException {
        LOGGER.info("Getting user.");
        return userApi.usersGet(user.getEmail());
    }
    public UserListResponse getAllOrgUsers(final String organisationId) throws ApiException {
        LOGGER.info("Getting All conclave users.");
        return orgUserApi.organisationProfileorganisationIdUsersGet(organisationId, null, null, null, null);
    }

    public UserEditResponseInfo updateUserRole(final UserProfileEditRequestInfo userDto) throws ApiException {
        LOGGER.info("Updating role(s) for User: " + userDto.getUserName());
        return userApi.usersPut(userDto, userDto.getUserName());
    }

    public void createConclaveOrg(final OrganisationProfileInfo orgDto) throws ApiException {
        LOGGER.info("Creating a conclave organisation.");
        orgApi.organisationProfilePost(orgDto);
    }

    public Integer getIdentityProviderId(final String organisationId) throws ApiException {
        LOGGER.info("Getting organisation identity provider Id for organisationId: " + organisationId);
        List<IdentityProviderDetail> identityProviders = orgApi.organisationProfileorganisationIdIdentityProvidersGet(organisationId);
        return identityProviders.stream().filter(idp -> idp.getName().equalsIgnoreCase("User ID and password")).collect(toList()).get(0).getId();

    }
    public List<OrganisationRole> getAllConfiguredRoles() throws ApiException {
        LOGGER.info("Getting all configured Roles. ");
        return configurationApi.configurationServiceRolesGet();
    }

    public List<OrganisationRole> getOrganisationRoles(String organisationId) throws ApiException {
        LOGGER.info("Getting all roles for the Organisation. ");
        return orgApi.organisationProfileorganisationIdRolesGet(organisationId);
    }

    public void updateOrganisationRole(final String organisationId, final OrganisationRoleUpdate roleUpdate) throws ApiException {
        LOGGER.info("Updating role(s) of the Organisation. ");
        orgApi.organisationProfileorganisationIdRolesPut(organisationId, roleUpdate);
    }

    public void createOrganisationContact(String organisationId, ContactRequestInfo contactRequestInfo) throws ApiException {
        LOGGER.info("Creating a contact for organisation.");
        orgContactApi.organisationProfileOrganisationIdContactsPost(organisationId, contactRequestInfo);
    }

    public void createUserContact(String userId, ContactRequestInfo contactRequestInfo) throws ApiException {
        LOGGER.info("Creating a user contact.");
        userContactApi.usersContactsPost(contactRequestInfo, userId);
    }

}
