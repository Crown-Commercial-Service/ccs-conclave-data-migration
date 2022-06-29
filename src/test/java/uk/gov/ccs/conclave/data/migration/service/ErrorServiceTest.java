package uk.gov.ccs.conclave.data.migration.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.ccs.conclave.data.migration.domain.Org;
import uk.gov.ccs.conclave.data.migration.repository.OrganisationRepository;
import uk.gov.ccs.conclave.data.migration.repository.UserRepository;
import uk.gov.ccs.swagger.dataMigration.model.User;
import uk.gov.ccs.swagger.dataMigration.model.UserTitle;

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
                new User().email("email").firstName("first").lastName("last").title(UserTitle.DOCTOR).contactFax("fax"),
                "message",
                200,
                new Org()
        );
    }
}
