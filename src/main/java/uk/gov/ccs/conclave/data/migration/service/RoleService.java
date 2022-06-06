package uk.gov.ccs.conclave.data.migration.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uk.gov.ccs.conclave.data.migration.client.ConclaveClient;
import uk.gov.ccs.swagger.dataMigration.model.OrgRoles;
import uk.gov.ccs.swagger.dataMigration.model.UserRoles;
import uk.gov.ccs.swagger.sso.ApiException;
import uk.gov.ccs.swagger.sso.model.OrganisationRole;
import uk.gov.ccs.swagger.sso.model.OrganisationRoleUpdate;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.EMPTY_LIST;
import static org.apache.commons.collections4.CollectionUtils.isEmpty;
import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;
import static uk.gov.ccs.conclave.data.migration.service.ErrorService.SSO_ROLE_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final ConclaveClient conclaveClient;

    private OrganisationRole filterOrganisationRoleByName(final List<OrganisationRole> roles, final String roleName) throws ApiException {
        return roles.stream().filter(role -> role.getRoleName().equalsIgnoreCase(roleName)).findFirst().orElseThrow(() -> new ApiException(404, roleName + SSO_ROLE_NOT_FOUND));

    }

    public void applyOrganisationRole(final String organisationId, final List<OrgRoles> orgRolesList) throws ApiException {
        if (isNotEmpty(orgRolesList)) {
            List<OrganisationRole> configuredRoles = conclaveClient.getAllConfiguredRoles();
            System.out.println(String.format("HERE -> 3 (configuredRoles):  %s", configuredRoles));
            System.out.println(String.format("HERE -> 4 (orgRolesList):  %s", orgRolesList));
            var rolesToAdd = new ArrayList<OrganisationRole>();
            for (OrgRoles orgRole : orgRolesList) {
                System.out.println(String.format("HERE -> 5 (orgRole.getName()):  %s", orgRole.getName()));
                rolesToAdd.add(filterOrganisationRoleByName(configuredRoles, orgRole.getName()));
            }
            OrganisationRoleUpdate roleUpdate = new OrganisationRoleUpdate();
            roleUpdate.setRolesToAdd(rolesToAdd);
            conclaveClient.updateOrganisationRole(organisationId, roleUpdate);
        }
    }

    public List<Integer> getUserRoleIdsFromRoleNames(final String organisationId, final List<UserRoles> roleNames) throws ApiException {
        if (isEmpty(roleNames)) {
            return EMPTY_LIST;
        }
        List<OrganisationRole> orgRoles = conclaveClient.getOrganisationRoles(organisationId);
        var roleIds = new ArrayList<Integer>();
        for (UserRoles userRole : roleNames) {
            roleIds.add(filterOrganisationRoleByName(orgRoles, userRole.getName()).getRoleId());
        }
        return roleIds;
    }



}
