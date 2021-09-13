package uk.gov.ccs.conclave.data.migration.service;

import org.springframework.stereotype.Service;
import uk.gov.ccs.swagger.cii.ApiException;
import uk.gov.ccs.swagger.dataMigration.model.Organisation;
import uk.gov.ccs.swagger.dataMigration.model.Summary;

import java.util.ArrayList;
import java.util.List;

import static uk.gov.ccs.conclave.data.migration.service.SummaryService.ciiOrgMessage;
import static uk.gov.ccs.conclave.data.migration.service.SummaryService.ssoOrgMessage;

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
            String organisationId;
            try {

                organisationId = organisationService.migrateOrganisation(org);
                if (organisationId != null) {
                    summaries.add(summaryService.buildSummaryWithStatus(org, 200));
                }

            } catch (ApiException e) {
                summaryService.logError(org, ciiOrgMessage, e);
                summaries.add(summaryService.buildSummaryWithStatus(org, e.getCode()));

            } catch (uk.gov.ccs.swagger.sso.ApiException e) {
                summaryService.logError(org, ssoOrgMessage, e);
                summaries.add(summaryService.buildSummaryWithStatus(org, e.getCode()));
            }

        }
        return summaries;
    }


}


