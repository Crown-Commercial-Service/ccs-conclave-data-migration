package uk.gov.ccs.conclave.data.migration.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.ccs.conclave.data.migration.domain.Org;
import uk.gov.ccs.conclave.data.migration.repository.OrganisationRepository;
import uk.gov.ccs.conclave.data.migration.repository.UserRepository;
import uk.gov.ccs.swagger.dataMigration.model.User;
import uk.gov.ccs.swagger.dataMigration.model.UserTitle;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ErrorServiceTest {

    @Mock
    private OrganisationRepository organisationRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private ErrorService errorService;

    @Test
    public void testSuccessfullySaveEmptyUser() throws Exception {
        errorService.saveUserDetailWithStatusCode(new User(), "message", 400, new Org());
    }

    @Test
    public void testSuccessfullySaveUser() throws Exception {
        errorService.saveUserDetailWithStatusCode(
                new User().email("email").firstName("first").lastName("last").title(UserTitle.DOCTOR).contactName("name").contactEmail("email").contactFax("fax").contactPhone("phone").contactMobile("mobile").contactSocial("social"),
                "message",
                200,
                new Org()
        );

        ArgumentCaptor<uk.gov.ccs.conclave.data.migration.domain.User> argumentCaptor = ArgumentCaptor.forClass(uk.gov.ccs.conclave.data.migration.domain.User.class);
        verify(userRepository).save(argumentCaptor.capture());
        assertThat(argumentCaptor.getValue().getEmail()).isEqualTo("email");
        assertThat(argumentCaptor.getValue().getFirstName()).isEqualTo("first");
        assertThat(argumentCaptor.getValue().getLastName()).isEqualTo("last");
        assertThat(argumentCaptor.getValue().getTitle()).isEqualTo("Doctor");
        assertThat(argumentCaptor.getValue().getContactName()).isEqualTo("name");
        assertThat(argumentCaptor.getValue().getContactEmail()).isEqualTo("email");
        assertThat(argumentCaptor.getValue().getContactFax()).isEqualTo("fax");
        assertThat(argumentCaptor.getValue().getContactPhone()).isEqualTo("phone");
        assertThat(argumentCaptor.getValue().getContactMobile()).isEqualTo("mobile");
        assertThat(argumentCaptor.getValue().getContactSocial()).isEqualTo("social");
    }
}
