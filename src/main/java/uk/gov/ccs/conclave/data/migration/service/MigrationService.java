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
        for (Organisation organisation : organisations) {
            String organisationId = organisationService.migrateOrganisation(organisation);

            userService.migrateUsers(organisation, organisationId);
        }
        LocalDateTime endTime = LocalDateTime.now();
        reportService.generateReport(startTime, endTime, organisations);

    }
}


