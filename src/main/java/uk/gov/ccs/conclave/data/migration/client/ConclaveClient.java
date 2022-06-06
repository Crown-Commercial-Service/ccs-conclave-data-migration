package uk.gov.ccs.conclave.data.migration.client;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
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

    private final ConfigurationApi configurationApi;

    private final OrganisationContactApi orgContactApi;

    private final UserContactApi userContactApi;


    public UserEditResponseInfo createUser(final UserProfileEditRequestInfo userDto) throws ApiException {
        LOGGER.info("Creating a conclave user.");
        return userApi.usersPost(userDto);
    }

    public void createConclaveOrg(final OrganisationProfileInfo orgDto) throws ApiException {
        LOGGER.info("Creating a conclave organisation.");
        orgApi.organisationsPost(orgDto);
    }

    public Integer getIdentityProviderId(final String organisationId) throws ApiException {
        LOGGER.info("Getting organisation identity provider Id for organisationId: " + organisationId);
        List<IdentityProviderDetail> identityProviders = orgApi.organisationsOrganisationIdIdentityProvidersGet(organisationId);
        return identityProviders.stream().filter(idp -> idp.getName().equalsIgnoreCase("User ID and password")).collect(toList()).get(0).getId();

    }
    public List<OrganisationRole> getAllConfiguredRoles() throws ApiException {
        System.out.println("HERE --> 2");
        LOGGER.info("Getting all configured Roles. ");
        return configurationApi.configurationsRolesGet();
    }

    public List<OrganisationRole> getOrganisationRoles(String organisationId) throws ApiException {
        LOGGER.info("Getting all roles for the Organisation. ");
        return orgApi.organisationsOrganisationIdRolesGet(organisationId);
    }

    public void updateOrganisationRole(final String organisationId, final OrganisationRoleUpdate roleUpdate) throws ApiException {
        LOGGER.info("Updating role(s) of the Organisation. ");
        orgApi.organisationsOrganisationIdRolesPut(organisationId, roleUpdate);
    }

    public void createOrganisationContact(String organisationId, ContactRequestInfo contactRequestInfo) throws ApiException {
        LOGGER.info("Creating a contact for organisation.");
        orgContactApi.organisationsOrganisationIdContactsPost(organisationId, contactRequestInfo);
    }

    public void createUserContact(String userId, ContactRequestInfo contactRequestInfo) throws ApiException {
        LOGGER.info("Creating a user contact.");
        userContactApi.usersContactsPost(contactRequestInfo, userId);
    }

}
