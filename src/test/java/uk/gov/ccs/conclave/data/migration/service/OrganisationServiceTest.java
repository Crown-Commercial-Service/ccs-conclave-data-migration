package uk.gov.ccs.conclave.data.migration.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.ccs.conclave.data.migration.client.CiiOrgClient;
import uk.gov.ccs.conclave.data.migration.client.ConclaveClient;
import uk.gov.ccs.swagger.cii.model.Address;
import uk.gov.ccs.swagger.cii.model.Identifier;
import uk.gov.ccs.swagger.cii.model.OrgMigration;
import uk.gov.ccs.swagger.dataMigration.model.Organisation;
import uk.gov.ccs.swagger.dataMigration.model.User;
import uk.gov.ccs.swagger.dataMigration.model.UserRole;
import uk.gov.ccs.swagger.sso.model.OrganisationProfileInfo;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class OrganisationServiceTest {
    @Mock
    private CiiOrgClient ciiOrgClient;

    @Mock
    private ConclaveClient conclaveClient;

    @Mock
    private ErrorService errorService;

    @Mock
    private ContactService contactService;

    @Mock
    private RoleService roleService;

    @InjectMocks
    private OrganisationService organisationService;

    private Organisation getTestOrganisation() {
        var admin_user = new User().userRoles(List.of(new UserRole().name("Organisation Administrator")));
        return new Organisation().user(List.of(admin_user));
    }

    @Test
    public void shouldSucceed() throws Exception {
        organisationService.migrateOrganisation(getTestOrganisation());
    }

    @Test
    public void shouldMigrateBuyer() throws Exception {
        given(ciiOrgClient.createCiiOrganisation(any(), any())).willReturn(new OrgMigration().identifier(new Identifier()).address(new Address()));
        given(conclaveClient.getIdentityProviderId(any())).willReturn(1);

        organisationService.migrateOrganisation(getTestOrganisation().rightToBuy("true"));

        ArgumentCaptor<OrganisationProfileInfo> argumentCaptor = ArgumentCaptor.forClass(OrganisationProfileInfo.class);
        verify(conclaveClient).createConclaveOrg(argumentCaptor.capture());
        assertThat(argumentCaptor.getValue().getDetail().isRightToBuy()).isEqualTo(true);
    }

    @Test
    public void shouldMigrateSupplier() throws Exception {
        given(ciiOrgClient.createCiiOrganisation(any(), any())).willReturn(new OrgMigration().identifier(new Identifier()).address(new Address()));
        given(conclaveClient.getIdentityProviderId(any())).willReturn(1);

        organisationService.migrateOrganisation(getTestOrganisation().rightToBuy("false"));

        ArgumentCaptor<OrganisationProfileInfo> argumentCaptor = ArgumentCaptor.forClass(OrganisationProfileInfo.class);
        verify(conclaveClient).createConclaveOrg(argumentCaptor.capture());
        assertThat(argumentCaptor.getValue().getDetail().isRightToBuy()).isEqualTo(false);
    }

    @Test
    public void shouldDeleteOrganisationIfNoAdmin() throws Exception {
        given(ciiOrgClient.createCiiOrganisation(any(), any())).willReturn(new OrgMigration().identifier(new Identifier()).address(new Address()).organisationId("org_id"));
        given(conclaveClient.getIdentityProviderId(any())).willReturn(1);

        organisationService.migrateOrganisation(new Organisation());

        verify(ciiOrgClient).deleteCiiOrganisation(eq("org_id"));
    }

    @Test
    public void shouldHandleNullRoles() throws Exception {
        given(ciiOrgClient.createCiiOrganisation(any(), any())).willReturn(new OrgMigration().identifier(new Identifier()).address(new Address()));
        given(conclaveClient.getIdentityProviderId(any())).willReturn(1);

        organisationService.migrateOrganisation(new Organisation().user(List.of(new User())));
    }
}
