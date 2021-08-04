package uk.gov.ccs.conclave.data.migration.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import uk.gov.ccs.swagger.cii.ApiException;
import uk.gov.ccs.swagger.cii.api.IdentitiesApi;
import uk.gov.ccs.swagger.cii.model.OrgMigration;

import java.util.List;

@Component
public class CiiOrgClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(CiiOrgClient.class);

    final IdentitiesApi identitiesApi;

    public CiiOrgClient(IdentitiesApi identitiesApi) {
        this.identitiesApi = identitiesApi;
    }

    public List<OrgMigration> createOrganisation(final String scheme, final String scheme_id) throws ApiException {
        LOGGER.info("Creating a CII organisation.");
        return identitiesApi.appMigrateOrg(scheme, scheme_id);
    }
}
