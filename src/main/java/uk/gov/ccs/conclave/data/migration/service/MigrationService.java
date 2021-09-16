package uk.gov.ccs.conclave.data.migration.service;

import org.springframework.stereotype.Service;
import uk.gov.ccs.swagger.cii.ApiException;
import uk.gov.ccs.swagger.dataMigration.model.Organisation;
import uk.gov.ccs.swagger.dataMigration.model.Summary;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static uk.gov.ccs.conclave.data.migration.service.SummaryService.CII_ORG_ERROR_MESSAGE;
import static uk.gov.ccs.conclave.data.migration.service.SummaryService.SSO_ORG_ERROR_MESSAGE;

@Service
public class MigrationService {

    final OrganisationService organisationService;

    final UserService userService;

    final SummaryService summaryService;

    public MigrationService(OrganisationService organisationService, UserService userService, SummaryService summaryService) {
        this.organisationService = organisationService;
        this.userService = userService;
        this.summaryService = summaryService;
    }


    public void migrate(List<Organisation> organisations) {
        LocalDateTime startTime = LocalDateTime.now();
        for (Organisation org : organisations) {
            organisationService.migrateOrganisation(org);
        }
        LocalDateTime endTime = LocalDateTime.now();
        summaryService.generateReport(startTime, endTime, organisations);
    }


}


