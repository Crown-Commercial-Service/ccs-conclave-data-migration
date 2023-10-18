package uk.gov.ccs.conclave.data.migration.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import uk.gov.ccs.conclave.data.migration.client.ConclaveClient;
import uk.gov.ccs.conclave.data.migration.controller.DataMigrationApiController;
import uk.gov.ccs.conclave.data.migration.domain.Org;
import uk.gov.ccs.conclave.data.migration.exception.DataMigrationException;
import uk.gov.ccs.swagger.dataMigration.model.OrgRole;
import uk.gov.ccs.swagger.dataMigration.model.Organisation;
import uk.gov.ccs.swagger.dataMigration.model.User;
import uk.gov.ccs.swagger.dataMigration.model.UserRole;
import uk.gov.ccs.swagger.sso.ApiException;
import uk.gov.ccs.swagger.sso.model.*;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.EMPTY_LIST;
import static org.apache.commons.collections4.CollectionUtils.isEmpty;
import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;
import static uk.gov.ccs.conclave.data.migration.service.ErrorService.*;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final ConclaveClient conclaveClient;
    private final ErrorService errorService;
    private static final Logger log = LoggerFactory.getLogger(ContactService.class);

    private OrganisationRole filterOrganisationRoleByName(final List<OrganisationRole> roles, final String roleName) throws ApiException {
        return roles.stream().filter(role -> role.getRoleName().equalsIgnoreCase(roleName)).findFirst().orElseThrow(() -> new ApiException(404, roleName + SSO_ROLE_NOT_FOUND));

    }

    private Boolean checkRoleExistsInOrganisation(final List<OrganisationRole> roles, final String roleName) {
        return roles.stream().anyMatch(role -> role.getRoleName().equalsIgnoreCase(roleName));
    }

    private Boolean checkRoleExistsInUserRoles(final List<RolePermissionInfo> roles, final String roleName) {
        return roles.stream().anyMatch(role -> role.getRoleName().equalsIgnoreCase(roleName));
    }

    public void applyOrganisationRole(final String organisationId, final Organisation organisation) throws ApiException {
        var orgRolesList = organisation.getOrgRoles();

        if (isNotEmpty(orgRolesList) && isNotNull(orgRolesList)) {
            List<OrganisationRole> configuredRoles = conclaveClient.getAllConfiguredRoles();
            List<OrganisationRole> existingRoles = conclaveClient.getOrganisationRoles(organisationId);
            var rolesToAdd = new ArrayList<OrganisationRole>();

            for (OrgRole orgRole : orgRolesList) {
                if(!checkRoleExistsInOrganisation(existingRoles, orgRole.getName())) {
                    if(!checkRoleExistsInOrganisation(configuredRoles, orgRole.getName())) {
                        log.error("{}", ORG_INVALID_ROLES_ERROR);
                        errorService.saveOrgDetailsWithStatusCode(organisation, ORG_INVALID_ROLES_ERROR, 400);
                        DataMigrationApiController.responseMsgArray.add(ORG_INVALID_ROLES_ERROR  + organisation.getIdentifierId());
                        continue;
                    }
                    rolesToAdd.add(filterOrganisationRoleByName(configuredRoles, orgRole.getName()));
                }
            }
            conclaveClient.updateOrganisationRole(
                    organisationId,
                    new OrganisationAutoValidationRoleUpdate().rolesToAdd(rolesToAdd));
        }
    }


    public List<Integer> getExistingUserRoleIdsFromRoleNames(final String organisationId, final List<UserRole> roleNames, final User user, final Org organisation) throws ApiException, DataMigrationException {
        // get all existing roles and add to roleIds this is to prevent overwriting existing roles
        UserProfileResponseInfo existingUser = conclaveClient.getUser(user);
        List<RolePermissionInfo> userRoleInfo = existingUser.getDetail().getRolePermissionInfo();
        int newRoleAdded = 0;
        for(RolePermissionInfo role : userRoleInfo) {
            UserRole existingUserRole = new UserRole();
            existingUserRole.setName(role.getRoleName());
            if (!checkRoleExistsInUserRoles(userRoleInfo, role.getRoleName())) {
                newRoleAdded++;
            }
            if(!roleNames.contains(existingUserRole)) {
                roleNames.add(existingUserRole);
            }
        }
        if(newRoleAdded == 0) {
            // existing user with existing roles only
            errorService.saveUserDetailWithStatusCode(user, SSO_DUPLICATE_USER_ERROR_MESSAGE, 409, organisation);
        }
        var roleIds = getUserRoleIdsFromRoleNames(organisationId, roleNames, user, organisation);
        return roleIds;
    }

    public List<Integer> getUserRoleIdsFromRoleNames(final String organisationId, final List<UserRole> roleNames, final User user, final Org organisation) throws ApiException {
        if (isEmpty(roleNames)) {
            return EMPTY_LIST;
        }
        List<OrganisationRole> orgRoles = conclaveClient.getOrganisationRoles(organisationId);
        var roleIds = new ArrayList<Integer>();
        for (UserRole userRole : roleNames) {
            if(checkRoleExistsInOrganisation(orgRoles, userRole.getName())) {
                roleIds.add(filterOrganisationRoleByName(orgRoles, userRole.getName()).getRoleId());
            } else {
                log.error("{}", USER_INVALID_ROLES_ERROR);
                errorService.saveUserDetailWithStatusCodeWithoutException(user, USER_INVALID_ROLES_ERROR, 400, organisation);
                DataMigrationApiController.responseMsgArray.add(USER_INVALID_ROLES_ERROR  + user.getEmail());
            }
        }
        return roleIds;
    }

    public boolean isNotNull(final List<OrgRole> orgRolesList) {
        for (OrgRole orgRole : orgRolesList) {
            if (orgRole.getName() == null) {
                return false;
            }
        }
        return true;
    }

}
