package uk.gov.ccs.conclave.data.migration.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.ccs.conclave.data.migration.client.ConclaveClient;
import uk.gov.ccs.conclave.data.migration.config.MigrationProperties;
import uk.gov.ccs.conclave.data.migration.domain.Org;
import uk.gov.ccs.swagger.dataMigration.model.User;
import uk.gov.ccs.swagger.sso.ApiException;
import uk.gov.ccs.swagger.sso.model.UserEditResponseInfo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verifyNoInteractions;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private ConclaveClient conclaveClient;

    @Mock
    private ErrorService errorService;

    @Mock
    private MigrationProperties properties;

    @Mock
    private ContactService contactService;

    @Mock
    private RoleService roleService;

    @InjectMocks
    private UserService userService;

    @Test
    public void testMigrateNoUsers() throws Exception {
        var failures = userService.migrateUsers(List.of(), new OrgMigrationResponse("organisationId", 1234, new Org()));

        assertThat(failures).isEqualTo(0);
    }

    @Test
    public void testMigrateWithNoContact() throws Exception {
        given(conclaveClient.createUser(any())).willReturn(new UserEditResponseInfo());

        var failures = userService.migrateUsers(List.of(new User()), new OrgMigrationResponse("organisationId", 1234, new Org()));

        assertThat(failures).isEqualTo(0);
    }

    @Test
    public void testExistingUser() throws Exception {
        given(conclaveClient.createUser(any())).willThrow(new ApiException(409, "Conflict"));

        var failures = userService.migrateUsers(List.of(new User()), new OrgMigrationResponse("organisationId", 1234, new Org()));

        assertThat(failures).isEqualTo(1);
        verifyNoInteractions(contactService);
    }

    @Test
    public void testTitleEnumsMatch() {
        var dmTitles = Arrays.stream(uk.gov.ccs.swagger.dataMigration.model.UserTitle.values())
                .map(uk.gov.ccs.swagger.dataMigration.model.UserTitle::toString).collect(Collectors.toSet());
        var ssoTitles = Arrays.stream(uk.gov.ccs.swagger.sso.model.UserTitle.values())
                .map(uk.gov.ccs.swagger.sso.model.UserTitle::toString).collect(Collectors.toSet());

        assertThat(ssoTitles).isEqualTo(dmTitles);
    }
}
