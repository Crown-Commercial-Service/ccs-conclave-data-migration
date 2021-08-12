package uk.gov.ccs.conclave.data.migration.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import uk.gov.ccs.conclave.data.migration.client.CiiOrgClient;
import uk.gov.ccs.conclave.data.migration.client.ConclaveClient;
import uk.gov.ccs.swagger.cii.ApiException;
import uk.gov.ccs.swagger.cii.model.OrgMigration;
import uk.gov.ccs.swagger.dataMigration.model.Organisation;

@Service
public class OrganisationService {
    
    private final CiiOrgClient ciiOrgClient;

    private final ConclaveClient conclaveClient;

    private static final Logger LOGGER = LoggerFactory.getLogger(OrganisationService.class);

    public OrganisationService(CiiOrgClient ciiOrgClient, ConclaveClient conclaveClient) {
        this.ciiOrgClient = ciiOrgClient;
        this.conclaveClient = conclaveClient;
    }

   
    public String migrateOrganisation(Organisation org) throws ApiException {
        OrgMigration ciiResponse =  migrateOrgToCii(org);
        String organisationId = migrateOrgToConclave(ciiResponse);

        return organisationId;
    }

    private OrgMigration migrateOrgToCii(Organisation org) throws ApiException {
        return ciiOrgClient.createCiiOrganisation(org.getSchemeId(), org.getIdentifierId());
    }

    private String migrateOrgToConclave(OrgMigration ciiResponse) {
        return "";
    }


}
