package uk.gov.ccs.conclave.data.migration.service;

import org.springframework.stereotype.Service;
import uk.gov.ccs.swagger.dataMigration.model.Organisation;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MigrationService {

    private final OrganisationService organisationService;

    private final UserService userService;

    private final ReportService reportService;

    public MigrationService(OrganisationService organisationService, UserService userService, ReportService reportService) {
        this.organisationService = organisationService;
        this.userService = userService;
        this.reportService = reportService;
    }


    public void migrate(List<Organisation> organisations) {
        LocalDateTime startTime = LocalDateTime.now();
        long failedUserCount = 0;
        long processedUserCount = 0;
        boolean migrationStatus = false;

        for (Organisation organisation : organisations) {
            var orgMigrationResponse = organisationService.migrateOrganisation(organisation);
            var users = organisation.getUser();
            if (orgMigrationResponse != null && users != null && !users.isEmpty()) {
                failedUserCount += userService.migrateUsers(users, orgMigrationResponse);
                processedUserCount += users.size();
                migrationStatus = failedUserCount == 0;
            }

        }
        LocalDateTime endTime = LocalDateTime.now();
        reportService.generateReport(startTime, endTime, organisations, failedUserCount, processedUserCount, migrationStatus);

    }
}


