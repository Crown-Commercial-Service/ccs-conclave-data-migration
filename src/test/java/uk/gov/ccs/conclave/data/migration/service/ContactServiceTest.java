package uk.gov.ccs.conclave.data.migration.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.ccs.conclave.data.migration.client.ConclaveClient;
import uk.gov.ccs.conclave.data.migration.domain.Org;
import uk.gov.ccs.swagger.dataMigration.model.User;

@ExtendWith(MockitoExtension.class)
public class ContactServiceTest {

    @Mock
    private ConclaveClient conclaveClient;

    @Mock
    private ErrorService errorService;

    @InjectMocks
    private ContactService contactService;

    @Test
    public void testMigrateUserWithNullFields() throws Exception {
        contactService.migrateUserContact(new User(), "userId", new Org());
    }
}
