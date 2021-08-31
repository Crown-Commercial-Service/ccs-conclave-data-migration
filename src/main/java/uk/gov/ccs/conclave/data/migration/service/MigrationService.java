package uk.gov.ccs.conclave.data.migration.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import uk.gov.ccs.swagger.cii.ApiException;
import uk.gov.ccs.swagger.dataMigration.model.Organisation;

import java.util.List;

@Service
public class MigrationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MigrationService.class);

    final OrganisationService organisationService;
    final UserService userService;

    public MigrationService(OrganisationService organisationService, UserService userService) {
        this.organisationService = organisationService;
        this.userService = userService;
    }


    public void migrate(List<Organisation> organisations) {
        for (Organisation org : organisations) {
            String organisationId;
            try {

                organisationId = organisationService.migrateOrganisation(org);

                userService.migrateUsers(org.getUser(), organisationId);

            } catch (ApiException e) {
                LOGGER.error("Error while creating CII organisation for organisation with identifier "
                        + ". Skipping to next organisation. "
                        + e.getMessage());

            } catch (uk.gov.ccs.swagger.sso.ApiException e) {
                LOGGER.error("Error while creating Organisation in conclave with identifier "
                        + ". Skipping to next organisation. "
                        + e.getMessage());
            }

        }
    }
}


