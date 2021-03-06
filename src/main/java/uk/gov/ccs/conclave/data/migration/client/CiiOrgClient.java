package uk.gov.ccs.conclave.data.migration.client;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import uk.gov.ccs.swagger.cii.ApiException;
import uk.gov.ccs.swagger.cii.api.IdentitiesApi;
import uk.gov.ccs.swagger.cii.model.OrgMigration;

@Component
@RequiredArgsConstructor
public class CiiOrgClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(CiiOrgClient.class);

    final IdentitiesApi identitiesApi;

    public OrgMigration createCiiOrganisation(final String scheme, final String id) throws ApiException {
        LOGGER.info("Creating a CII organisation.");
        return identitiesApi.appMigrateOrg(scheme, id);
    }

    public OrgMigration deleteCiiOrganisation(final String organisationId) throws ApiException {
        LOGGER.info("Deleting a CII organisation.");
        return identitiesApi.appDeleteOrg(organisationId);
    }
}
