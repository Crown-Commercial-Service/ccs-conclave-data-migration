package uk.gov.ccs.conclave.data.migration.service;

import org.springframework.stereotype.Service;
import uk.gov.ccs.swagger.cii.ApiException;
import uk.gov.ccs.swagger.dataMigration.model.Organisation;
import uk.gov.ccs.swagger.dataMigration.model.Summary;

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


    public List<Summary> migrate(List<Organisation> organisations) {
        List<Summary> summaries = new ArrayList<>();
        for (Organisation org : organisations) {
            try {
                organisationService.migrateOrganisation(org);
                summaries.add(summaryService.buildSummaryWithStatus(org, 200));

            } catch (ApiException e) {
                summaryService.logError(org, CII_ORG_ERROR_MESSAGE, e);
                summaries.add(summaryService.buildSummaryWithStatus(org, e.getCode()));

            } catch (uk.gov.ccs.swagger.sso.ApiException e) {
                summaryService.logError(org, SSO_ORG_ERROR_MESSAGE, e);
                summaries.add(summaryService.buildSummaryWithStatus(org, e.getCode()));
            }

        }
        return summaries;
    }


}


