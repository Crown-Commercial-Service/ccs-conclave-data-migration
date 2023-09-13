package uk.gov.ccs.conclave.data.migration.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.ccs.conclave.data.migration.client.ConclaveClient;
import uk.gov.ccs.swagger.dataMigration.model.OrgRole;
import uk.gov.ccs.swagger.dataMigration.model.Organisation;
import uk.gov.ccs.swagger.sso.ApiException;
import uk.gov.ccs.swagger.sso.model.OrganisationRole;
import uk.gov.ccs.swagger.sso.model.OrganisationRoleUpdate;

import java.util.List;

import static java.util.Collections.EMPTY_LIST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class RoleServiceTest {
    private final String ORGANISATION_ID = "Organisation ID";

    @Mock
    private ConclaveClient conclaveClient;

    @InjectMocks
    private RoleService roleService;

    @Test
    public void shouldNotAddRolesIfNoRoles() throws Exception {
        roleService.applyOrganisationRole(ORGANISATION_ID, new Organisation());

        verify(conclaveClient, times(0)).updateOrganisationRole(any(), any());
    }

    @Test
    public void shouldNotAddRolesIfZeroRoles() throws Exception {
        roleService.applyOrganisationRole(ORGANISATION_ID, new Organisation().orgRoles(EMPTY_LIST));

        verify(conclaveClient, times(0)).updateOrganisationRole(any(), any());
    }

    @Test
    public void shouldNotAddMalformedRoles() throws Exception {
        roleService.applyOrganisationRole(ORGANISATION_ID, new Organisation().orgRoles(List.of(new OrgRole())));

        verify(conclaveClient, times(0)).updateOrganisationRole(any(), any());
    }

    @Test
    public void shouldAddOrgRoles() throws Exception {
        var roleName = "Org Role";
        given(conclaveClient.getAllConfiguredRoles()).willReturn(List.of(new OrganisationRole().roleName(roleName)));

        roleService.applyOrganisationRole(ORGANISATION_ID, new Organisation().orgRoles(List.of(new OrgRole().name(roleName))));

        ArgumentCaptor<OrganisationRoleUpdate> argumentCaptor = ArgumentCaptor.forClass(OrganisationRoleUpdate.class);
        verify(conclaveClient).updateOrganisationRole(eq(ORGANISATION_ID), argumentCaptor.capture());
        assertThat(argumentCaptor.getValue().getRolesToAdd().get(0).getRoleName()).isEqualTo(roleName);
    }

    /*@Test
    public void shouldPassBuyerStatus() throws Exception {
        var roleName = "Org Role";
        given(conclaveClient.getAllConfiguredRoles()).willReturn(List.of(new OrganisationRole().roleName(roleName)));

        roleService.applyOrganisationRole(ORGANISATION_ID, new Organisation().orgRoles(List.of(new OrgRole().name(roleName))).rightToBuy(true));

        ArgumentCaptor<OrganisationRoleUpdate> argumentCaptor = ArgumentCaptor.forClass(OrganisationRoleUpdate.class);
        verify(conclaveClient).updateOrganisationRole(eq(ORGANISATION_ID), argumentCaptor.capture());
        assertThat(argumentCaptor.getValue().isIsBuyer()).isEqualTo(true);
    }*/
}
