package uk.gov.ccs.conclave.data.migration.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.ccs.conclave.data.migration.client.CiiOrgClient;
import uk.gov.ccs.conclave.data.migration.client.ConclaveClient;
import uk.gov.ccs.swagger.dataMigration.model.Organisation;

@ExtendWith(MockitoExtension.class)
public class OrganisationServiceTest {
    @Mock
    private CiiOrgClient ciiOrgClient;

    @Mock
    private ConclaveClient conclaveClient;

    @Mock
    private ErrorService errorService;

    @Mock
    private ContactService contactService;

    @Mock
    private RoleService roleService;

    @InjectMocks
    private OrganisationService organisationService;

    @Test
    public void shouldSucceed() throws Exception {
        organisationService.migrateOrganisation(new Organisation());
    }
}
