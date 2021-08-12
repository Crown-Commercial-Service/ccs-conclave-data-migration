package uk.gov.ccs.conclave.data.migration.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import uk.gov.ccs.conclave.data.migration.client.CiiOrgClient;
import uk.gov.ccs.conclave.data.migration.client.ConclaveUserClient;
import uk.gov.ccs.swagger.cii.ApiException;
import uk.gov.ccs.swagger.dataMigration.model.Organisation;

import java.util.List;

@Service
public class MigrationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MigrationService.class);

    private final CiiOrgClient ciiOrgClient;

    private final ConclaveUserClient conclaveUserClient;

    public MigrationService(CiiOrgClient ciiOrgClient, ConclaveUserClient conclaveUserClient) {
        this.ciiOrgClient = ciiOrgClient;
        this.conclaveUserClient = conclaveUserClient;
    }

    public void migrate(List<Organisation> organisations) {
        organisations.forEach(org -> {
            try {
                ciiOrgClient.createCiiOrganisation(org.getSchemeId(), org.getIdentifierId());
            } catch (ApiException e) {
                LOGGER.error("Error while creating CII organisation " + e.getMessage());
            }
        });
    }
}
