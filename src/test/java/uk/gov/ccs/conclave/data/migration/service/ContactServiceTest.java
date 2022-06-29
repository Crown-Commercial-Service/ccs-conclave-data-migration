package uk.gov.ccs.conclave.data.migration.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.ccs.conclave.data.migration.client.ConclaveClient;
import uk.gov.ccs.conclave.data.migration.domain.Org;
import uk.gov.ccs.swagger.dataMigration.model.User;
import uk.gov.ccs.swagger.sso.model.ContactRequestInfo;
import uk.gov.ccs.swagger.sso.model.OrganisationRoleUpdate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;

@ExtendWith(MockitoExtension.class)
public class ContactServiceTest {

    @Mock
    private ConclaveClient conclaveClient;

    @Mock
    private ErrorService errorService;

    @InjectMocks
    private ContactService contactService;

    @Test
    public void testMigrateUserWithNoContact() throws Exception {
        contactService.migrateUserContact(new User(), "userId", new Org());

        verifyNoInteractions(conclaveClient);
    }

    @Test
    public void testMigrateUserWithFullContact() throws Exception {
        contactService.migrateUserContact(
                new User().contactName("name").contactEmail("email").contactFax("fax").contactPhone("phone").contactMobile("mobile").contactSocial("social"), "userId",
                new Org()
        );

        ArgumentCaptor<ContactRequestInfo> argumentCaptor = ArgumentCaptor.forClass(ContactRequestInfo.class);
        verify(conclaveClient).createUserContact(eq("userId"), argumentCaptor.capture());
        assertThat(argumentCaptor.getValue().getContactPointName()).isEqualTo("name");
        assertThat(argumentCaptor.getValue().getContacts().size()).isEqualTo(5);
    }
}
