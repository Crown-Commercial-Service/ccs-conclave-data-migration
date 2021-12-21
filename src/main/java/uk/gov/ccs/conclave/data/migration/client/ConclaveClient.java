package uk.gov.ccs.conclave.data.migration.client;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import uk.gov.ccs.swagger.dataMigration.model.OrgRoles;
import uk.gov.ccs.swagger.sso.ApiException;
import uk.gov.ccs.swagger.sso.api.ConfigurationApi;
import uk.gov.ccs.swagger.sso.api.OrganisationApi;
import uk.gov.ccs.swagger.sso.api.OrganisationContactApi;
import uk.gov.ccs.swagger.sso.api.UserApi;
import uk.gov.ccs.swagger.sso.model.*;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static uk.gov.ccs.conclave.data.migration.service.ErrorService.SSO_ROLE_ERROR_MESSAGE;

@Component
@RequiredArgsConstructor
public class ConclaveClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConclaveClient.class);

    private final UserApi userApi;

    private final OrganisationApi orgApi;

    private final ConfigurationApi configurationApi;

    private final OrganisationContactApi orgContactApi;


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

    private OrganisationRole filterOrganisationRoleByName(final List<OrganisationRole> allOrgRoles, final String roleName) throws ApiException {
        return allOrgRoles.stream().filter(role -> role.getRoleName().equalsIgnoreCase(roleName)).findFirst().orElseThrow(() -> new ApiException(SSO_ROLE_ERROR_MESSAGE));

    }

    private void updateOrganisationRole(final String organisationId, final OrganisationRoleUpdate roleUpdate) throws ApiException {
        LOGGER.info("Updating role(s) of the Organisation. ");
        orgApi.organisationsOrganisationIdRolesPut(organisationId, roleUpdate);
    }

    public void applyOrganisationRole(final String organisationId, final List<OrgRoles> orgRolesList) throws ApiException {
        LOGGER.info("Applying specified role(s) to the Organisation with organisationId:" + organisationId);
        List<OrganisationRole> allSsoRoles = configurationApi.configurationsRolesGet();
        var rolesToAdd = new ArrayList<OrganisationRole>();
        for (OrgRoles orgRole : orgRolesList) {
            rolesToAdd.add(filterOrganisationRoleByName(allSsoRoles, orgRole.getName()));
        }
        OrganisationRoleUpdate roleUpdate = new OrganisationRoleUpdate();
        roleUpdate.setRolesToAdd(rolesToAdd);
        updateOrganisationRole(organisationId, roleUpdate);
    }

    public Integer getOrganisationRoleId(final String organisationId, final String roleName) throws ApiException {
        LOGGER.info("Getting roleId for the Org role");
        List<OrganisationRole> roles = orgApi.organisationsOrganisationIdRolesGet(organisationId);
        return roles.stream().filter(role -> role.getRoleName().equalsIgnoreCase(roleName)).collect(toList()).get(0).getRoleId();

    }

    public void createOrganisationContact(String organisationId, ContactRequestInfo contactRequestInfo) throws ApiException {
        LOGGER.info("Creating a contact for organisation.");
        orgContactApi.organisationsOrganisationIdContactsPost(organisationId, contactRequestInfo);
    }

}
