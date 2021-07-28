package uk.gov.ccs.conclave.data.migration.util;

import org.junit.jupiter.api.Test;
import uk.gov.ccs.conclave.data.migration.domain.User;

import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CsvHelperTest {


    @Test
    void readCsvFile() {
        String fileName = Paths.get("src", "test", "resources")
                .toFile()
                .getAbsolutePath()
                .concat("/csv/Users.csv");

        List<User> users = CsvHelper.readCsvFile(fileName);
        assertNotNull(users);
        assertEquals(users.size(), 3);
        users.forEach(this::validateFields);
    }

    private void validateFields(User u) {
        assertNotNull(u.getIdentifierId());
        assertNotNull(u.getSchemeId());
        assertNotNull(u.getRightToBuy());
        assertNotNull(u.getTitle());
        assertNotNull(u.getFirstName());
        assertNotNull(u.getLastName());
        assertNotNull(u.getEmail());
        assertNotNull(u.getContactEmail());
        assertNotNull(u.getContactMobile());
        assertNotNull(u.getContactFax());
        assertNotNull(u.getContactPhone());
        assertNotNull(u.getContactSocial());
    }
}