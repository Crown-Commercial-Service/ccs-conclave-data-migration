package uk.gov.ccs.conclave.data.migration.service;

import org.springframework.stereotype.Service;
import uk.gov.ccs.swagger.dataMigration.model.Organisation;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MigrationService {

    final OrganisationService organisationService;

    final UserService userService;

    final ErrorService errorService;

    final ReportService reportService;

    public MigrationService(OrganisationService organisationService, UserService userService, ErrorService errorService, ReportService reportService) {
        this.organisationService = organisationService;
        this.userService = userService;
        this.errorService = errorService;
        this.reportService = reportService;
    }


    public void migrate(List<Organisation> organisations) {
        LocalDateTime startTime = LocalDateTime.now();
        try {
            for (Organisation org : organisations) {
                organisationService.migrateOrganisation(org);
            }
            LocalDateTime endTime = LocalDateTime.now();
            //reportService.generateReport(startTime, endTime, organisations);

        } catch (Exception e) {

        }

    }
}


