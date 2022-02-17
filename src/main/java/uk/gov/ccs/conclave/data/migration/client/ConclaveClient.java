package uk.gov.ccs.conclave.data.migration.client;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import uk.gov.ccs.swagger.dataMigration.model.OrgRoles;
import uk.gov.ccs.swagger.dataMigration.model.UserRoles;
import uk.gov.ccs.swagger.sso.ApiException;
import uk.gov.ccs.swagger.sso.api.*;
import uk.gov.ccs.swagger.sso.model.*;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.EMPTY_LIST;
import static java.util.stream.Collectors.toList;
import static org.apache.commons.collections4.CollectionUtils.isEmpty;
import static uk.gov.ccs.conclave.data.migration.service.ErrorService.SSO_ROLE_NOT_FOUND;

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

    public String createConclaveOrg(final OrganisationProfileInfo orgDto) throws ApiException {
        LOGGER.info("Creating a conclave organisation.");
        return orgApi.organisationsPost(orgDto);
    }

    public Integer getIdentityProviderId(final String organisationId) throws ApiException {
        LOGGER.info("Getting organisation identity provider Id for organisationId: " + organisationId);
        List<IdentityProviderDetail> identityProviders = orgApi.organisationsOrganisationIdIdentityProvidersGet(organisationId);
        return identityProviders.stream().filter(idp -> idp.getName().equalsIgnoreCase("User ID and password")).collect(toList()).get(0).getId();

    }

    private OrganisationRole filterOrganisationRoleByName(final List<OrganisationRole> roles, final String roleName) throws ApiException {
        return roles.stream().filter(role -> role.getRoleName().equalsIgnoreCase(roleName)).findFirst().orElseThrow(() -> new ApiException(404, roleName + SSO_ROLE_NOT_FOUND));

    }

    private void updateOrganisationRole(final String organisationId, final OrganisationRoleUpdate roleUpdate) throws ApiException {
        LOGGER.info("Updating role(s) of the Organisation. ");
        orgApi.organisationsOrganisationIdRolesPut(organisationId, roleUpdate);
    }

    public void applyOrganisationRole(final String organisationId, final List<OrgRoles> orgRolesList) throws ApiException {
        if (orgRolesList != null && !orgRolesList.isEmpty()) {
            LOGGER.info("Applying specified role(s) to the Organisation with organisationId:" + organisationId);
            List<OrganisationRole> configuredRoles = configurationApi.configurationsRolesGet();
            var rolesToAdd = new ArrayList<OrganisationRole>();
            for (OrgRoles orgRole : orgRolesList) {
                rolesToAdd.add(filterOrganisationRoleByName(configuredRoles, orgRole.getName()));
            }
            OrganisationRoleUpdate roleUpdate = new OrganisationRoleUpdate();
            roleUpdate.setRolesToAdd(rolesToAdd);
            updateOrganisationRole(organisationId, roleUpdate);
        }
    }

    public List<Integer> getUserRoleIdsFromRoleNames(final String organisationId, final List<UserRoles> roleNames) throws ApiException {
        if (isEmpty(roleNames)) {
            return EMPTY_LIST;
        }
        LOGGER.info("Getting user roleIds. ");
        List<OrganisationRole> orgRoles = orgApi.organisationsOrganisationIdRolesGet(organisationId);
        var roleIds = new ArrayList<Integer>();
        for (UserRoles userRole : roleNames) {
            roleIds.add(filterOrganisationRoleByName(orgRoles, userRole.getName()).getRoleId());
        }
        return roleIds;
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
