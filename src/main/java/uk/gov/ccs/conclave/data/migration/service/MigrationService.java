package uk.gov.ccs.conclave.data.migration.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uk.gov.ccs.swagger.dataMigration.model.Organisation;

import java.time.LocalDateTime;
import java.util.List;

import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;

@Service
@RequiredArgsConstructor
public class MigrationService {

    private final OrganisationService organisationService;

    private final UserService userService;

    private final ReportService reportService;


    public void migrate(List<Organisation> organisations) {
        LocalDateTime startTime = LocalDateTime.now();
        long failedUserCount = 0;
        long processedUserCount = 0;
        boolean migrationStatus = false;

        for (Organisation organisation : organisations) {
            var orgMigrationResponse = organisationService.migrateOrganisation(organisation);
            var users = organisation.getUser();
            if (orgMigrationResponse != null && isNotEmpty(users)) {
                failedUserCount += userService.migrateUsers(users, orgMigrationResponse);
                processedUserCount += users.size();
                migrationStatus = failedUserCount == 0;
            }

        }
        LocalDateTime endTime = LocalDateTime.now();
        reportService.generateReport(startTime, endTime, organisations, failedUserCount, processedUserCount, migrationStatus);

    }
}


