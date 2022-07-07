package uk.gov.ccs.conclave.data.migration.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.ccs.swagger.dataMigration.model.Organisation;
import uk.gov.ccs.swagger.dataMigration.model.User;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static uk.gov.ccs.conclave.data.migration.service.ErrorService.MIGRATION_STATUS_COMPLETE;
import static uk.gov.ccs.conclave.data.migration.service.ErrorService.MIGRATION_STATUS_PARTIAL;

@ExtendWith(MockitoExtension.class)
public class MigrationServiceTest {

    @Mock
    private OrganisationService organisationService;

    @Mock
    private UserService userService;

    @Mock
    private ReportService reportService;

    @InjectMocks
    private MigrationService migrationService;

    @Test
    public void shouldReportNoUsersAsPartialMigration() {
        migrationService.migrate(List.of(new Organisation()));

        verifyNoInteractions(userService);
        verify(reportService).generateReport(any(), any(), any(), anyLong(), anyLong(), eq(MIGRATION_STATUS_PARTIAL));
    }

    @Test
    public void shouldReportSuccessfulMigration() throws Exception {
        given(organisationService.migrateOrganisation(any())).willReturn(new OrgMigrationResponse("organisationId", 1234, null));
        given(userService.migrateUsers(any(), any())).willReturn(0L);

        migrationService.migrate(List.of(new Organisation().user(List.of(new User()))));

        verify(reportService).generateReport(any(), any(), any(), anyLong(), anyLong(), eq(MIGRATION_STATUS_COMPLETE));
    }

    @Test
    public void shouldReportFailedUserMigration() throws Exception {
        given(organisationService.migrateOrganisation(any())).willReturn(new OrgMigrationResponse("organisationId", 1234, null));
        given(userService.migrateUsers(any(), any())).willReturn(1L);

        migrationService.migrate(List.of(new Organisation().user(List.of(new User()))));

        verify(reportService).generateReport(any(), any(), any(), anyLong(), anyLong(), eq(MIGRATION_STATUS_PARTIAL));
    }

    @Test
    public void shouldReturnSummary() throws Exception {
        given(organisationService.migrateOrganisation(any())).willReturn(new OrgMigrationResponse("organisationId", 1234, null));
        given(userService.migrateUsers(any(), any())).willReturn(0L);

        var result = migrationService.migrate(List.of(new Organisation().user(List.of(new User()))));

        assertThat(result).isEmpty();
    }
}
