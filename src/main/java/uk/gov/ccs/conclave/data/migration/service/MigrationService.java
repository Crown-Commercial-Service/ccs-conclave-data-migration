package uk.gov.ccs.conclave.data.migration.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import uk.gov.ccs.conclave.data.migration.domain.Client;
import uk.gov.ccs.conclave.data.migration.exception.DataMigrationException;
import uk.gov.ccs.swagger.dataMigration.model.Organisation;

import java.time.LocalDateTime;
import java.util.List;

import static java.time.LocalDateTime.now;
import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;
import static org.springframework.http.HttpStatus.valueOf;
import static uk.gov.ccs.conclave.data.migration.service.ErrorService.*;

@Service
@RequiredArgsConstructor
public class MigrationService {

    private final OrganisationService organisationService;

    private final UserService userService;

    private final ReportService reportService;

    private final ErrorService errorService;


    public void migrate(List<Organisation> organisations) {
        LocalDateTime startTime = now();
        long failedUserCount = 0;
        long processedUserCount = 0;
        boolean migrationStatus = false;
        try {
            for (Organisation organisation : organisations) {
                var orgMigrationResponse = organisationService.migrateOrganisation(organisation);
                var users = organisation.getUser();
                if (orgMigrationResponse != null && isNotEmpty(users)) {
                    failedUserCount += userService.migrateUsers(users, orgMigrationResponse);
                    processedUserCount += users.size();
                    migrationStatus = failedUserCount == 0;
                }

            }
            LocalDateTime endTime = now();
            reportService.generateReport(startTime, endTime, organisations, failedUserCount, processedUserCount, migrationStatus ? MIGRATION_STATUS_COMPLETE : MIGRATION_STATUS_PARTIAL);

        } catch (DataMigrationException e) {
            reportService.generateReport(startTime, now(), organisations, failedUserCount, processedUserCount, MIGRATION_STATUS_ABORTED + e.getMessage());
            throw new ResponseStatusException(valueOf(e.getCode()), e.getMessage());
        }
    }

    public void test2() {
        List<Client> ts1 = errorService.testing();
        System.out.println("TESTING: "+ ts1);
    }
}


