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

import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor
public class ConclaveClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConclaveClient.class);

    private final UserApi userApi;

    private final OrganisationApi orgApi;


    private final OrganisationRoleApi organisationRoleApi;

    private final OrganisationIdentityProviderApi organisationIdentityProviderApi;

    private final ConfigurationServicesApi configurationApi;

    private final OrganisationAutoValidationApi organisationAutoValidationApi;

    private final OrganisationContactApi orgContactApi;

    private final UserContactApi userContactApi;

    private final OrganisationUserApi orgUserApi;


    public UserEditResponseInfo createUser(final UserProfileEditRequestInfo userDto) throws ApiException {
        LOGGER.info("Creating a conclave user.");
        return userApi.userProfilePost(userDto);
    }

    public UserProfileResponseInfo getUser(final User user) throws ApiException {
        LOGGER.info("Getting user.");
        return userApi.userProfileGet(user.getEmail(), false, false, "");
    }
    public UserListResponseInfo getAllOrgUsers(final String organisationId) throws ApiException {
        LOGGER.info("Getting All conclave users.");
        return orgUserApi.organisationProfileOrganisationIdUsersGet(organisationId, null, null, null, null, null, null, null, null, null);
    }

    public UserEditResponseInfo updateUserRole(final UserProfileEditRequestInfo userDto) throws ApiException {
        LOGGER.info("Updating role(s) for User: " + userDto.getUserName());
        return userApi.userProfilePut(userDto, userDto.getUserName());
    }

    public void createConclaveOrg(final OrganisationProfileInfo orgDto) throws ApiException {
        LOGGER.info("Creating a conclave organisation.");
        orgApi.organisationProfilePost(orgDto);
    }

    public Integer getIdentityProviderId(final String organisationId) throws ApiException {
        LOGGER.info("Getting organisation identity provider Id for organisationId: " + organisationId);
        List<OrgEligibleIdentityProvider> identityProviders = organisationIdentityProviderApi.organisationProfileOrganisationIdIdentityProvidersGet(organisationId);
        return identityProviders.stream().filter(idp -> idp.getName().equalsIgnoreCase("User ID and password")).toList().get(0).getId();
    }

    public List<OrganisationRole> getAllConfiguredRoles() throws ApiException {
        LOGGER.info("Getting all configured Roles. ");
        return configurationApi.configurationServiceRolesGet();
    }

    public List<OrganisationRole> getOrganisationRoles(String organisationId) throws ApiException {
        LOGGER.info("Getting all roles for the Organisation. ");
       return organisationRoleApi.organisationProfileOrganisationIdRolesGet(organisationId);
    }

    public void updateOrganisationRole(final String organisationId, final OrganisationAutoValidationRoleUpdate roleUpdate) throws ApiException {
        LOGGER.info("Updating role(s) of the Organisation. ");
        organisationAutoValidationApi.organisationProfileOrganisationIdValidationAutoSwitchPut(organisationId, roleUpdate);
    }

    public void createOrganisationContact(String organisationId, ContactRequestInfo contactRequestInfo) throws ApiException {
        LOGGER.info("Creating a contact for organisation.");
        orgContactApi.contactServiceOrganisationsOrganisationIdContactsPost(organisationId, contactRequestInfo);
    }

    public void createUserContact(String userId, ContactRequestInfo contactRequestInfo) throws ApiException {
        LOGGER.info("Creating a user contact.");
        userContactApi.contactServiceUserContactsPost(contactRequestInfo, userId);
    }

}
