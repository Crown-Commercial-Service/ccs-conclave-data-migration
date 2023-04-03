package uk.gov.ccs.conclave.data.migration.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import static java.time.LocalDateTime.now;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;
import static org.springframework.http.HttpStatus.valueOf;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import lombok.RequiredArgsConstructor;
import uk.gov.ccs.conclave.data.migration.exception.DataMigrationException;
import uk.gov.ccs.swagger.dataMigration.model.OrgRole;
import uk.gov.ccs.swagger.dataMigration.model.Organisation;
import uk.gov.ccs.swagger.dataMigration.model.User;
import uk.gov.ccs.swagger.dataMigration.model.UserRole;
import uk.gov.ccs.swagger.dataMigration.model.UserTitle;

import static uk.gov.ccs.conclave.data.migration.service.ErrorService.MIGRATION_STATUS_ABORTED;
import static uk.gov.ccs.conclave.data.migration.service.ErrorService.MIGRATION_STATUS_COMPLETE;
import static uk.gov.ccs.conclave.data.migration.service.ErrorService.MIGRATION_STATUS_PARTIAL;


@Service
@RequiredArgsConstructor
public class MigrationService {

    private final OrganisationService organisationService;
    private final UserService userService;
    private final ReportService reportService;
    private final ErrorService errorService;


    public void migrate(List<Organisation> organisations) {

        LocalDateTime startTime = now();
        long failedUserCount = 0;
        long processedUserCount = 0;
        boolean migrationStatus = false;

        try {

            for (Organisation organisation : organisations) {
                var orgMigrationResponse = organisationService.migrateOrganisation(organisation);
                var users = organisation.getUser();

                if (orgMigrationResponse != null && isNotEmpty(users)) {
                    failedUserCount += userService.migrateUsers(users, orgMigrationResponse);
                    processedUserCount += users.size();
                    migrationStatus = failedUserCount == 0;
                }

            }

            LocalDateTime endTime = now();
            reportService.generateReport(startTime, endTime, organisations, failedUserCount, processedUserCount, migrationStatus ? MIGRATION_STATUS_COMPLETE : MIGRATION_STATUS_PARTIAL);

        } catch (DataMigrationException e) {
            reportService.generateReport(startTime, now(), organisations, failedUserCount, processedUserCount, MIGRATION_STATUS_ABORTED + e.getMessage());
            throw new ResponseStatusException(valueOf(e.getCode()), e.getMessage());
        }
    }

    public void formatCsv(MultipartFile csvFile) {
        if (isValidCSV(csvFile)) {
            List<Organisation> organisations = new ArrayList<Organisation>();

            try (CSVReader reader = new CSVReader(new InputStreamReader(csvFile.getInputStream()))) {
                String[] header = reader.readNext(); // Read the header line
                String[] record;

                while ((record = reader.readNext()) != null) {
                    Organisation org = new Organisation();

                    String identifierId = (record[0] != null) ? record[0] : null;
                      org.setIdentifierId(identifierId);

                    String schemeId = (record[1] != null) ? record[1] : null;
                      org.setSchemeId(schemeId);

                    String organisationType = (record[2] != null) ? record[2] : null;
                      org.setRightToBuy(organisationType); // Needs 'rightToBuy' updating to 'OrganisationType' (0, 1 or 2). Replace rightToBuy, or, add as an extra alongside making rightToBuy optional?

                    List<User> users = new ArrayList<User>();
                    User user = new User();

                    String emailAddress = (record[3] != null) ? record[3] : null;
                      user.setEmail(emailAddress);

                    String title = (record[4] != null) ? record[4] : null;
                      user.setTitle(UserTitle.valueOf((title.substring(0, 1).toUpperCase() + title.substring(1).toLowerCase())));

                    String firstName = (record[5] != null) ? record[5] : null;
                      user.setFirstName(firstName);

                    String lastName = (record[6] != null) ? record[6] : null;
                      user.setLastName(lastName);

                    List<OrgRole> orgRoles = new ArrayList<OrgRole>();
                      OrgRole orgRole = new OrgRole();
                      orgRole.setName((record[7] != null) ? record[7] : null);
                      orgRoles.add(orgRole); // But this will be a list of multiple roles, so need to loop/filter through adding to the List of OrgRoles. Then add to the organisation.
                      org.setOrgRoles(orgRoles);

                    List<UserRole> userRoles = new ArrayList<UserRole>();
                      UserRole userRole = new UserRole();
                      userRole.setName((record[8] != null) ? record[8] : null);
                      userRoles.add(userRole); // But this will be a list of multiple roles, so need to loop/filter through adding to the List of OrgRoles. Then add to user, which is added to the organisation.
                      user.setUserRoles(userRoles);

                    String contactEmail = (record[9] != null) ? record[9] : null;
                      user.setContactEmail(contactEmail);

                    String contactMobile = (record[10] != null) ? record[10] : null;
                      user.setContactMobile(contactMobile);

                    String contactPhone = (record[11] != null) ? record[11] : null;
                      user.setContactPhone(contactPhone);

                    String contactFax = (record[12] != null) ? record[12] : null;
                      user.setContactFax(contactFax);

                    String contactSocial = (record[13] != null) ? record[13] : null;
                      user.setContactSocial(contactSocial);

                    users.add(user);
                    org.setUser(users);
                    organisations.add(org);

                    // System.out.println("Data: " + identifierId + " " + schemeId + " " + rightToBuy + " ...");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (CsvValidationException e) {
                throw new RuntimeException(e);
            }

            migrate(organisations);
        } else {
            System.out.println("Invalid CSV file");
        }
    }

    public static boolean isValidCSV(MultipartFile file) {
        if (file.isEmpty()) { return false; }

        final List<String> requiredHeaders = Arrays.asList(
                "IdentifierId","SchemeId","OrganisationType","EmailAddress","Title","FirstName","LastName","OrganisationRoles","UserRoles","ContactEmail","ContactMobile","ContactPhone","ContactFax","ContactSocial"
        );

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));
            String[] headers = br.readLine().split(",");
            br.close();
            return new HashSet<>(Arrays.asList(headers)).containsAll(requiredHeaders);
        } catch (Exception e) { return false; }
    }

    public boolean isValidClientApiKey(String key) {
        if (key == null || key.trim().isEmpty()) { return Boolean.FALSE; } 

        return errorService.findApiKey(key).isPresent() ? Boolean.TRUE : Boolean.FALSE;
    }

    public void createClientApiKey() {
        String key = AuthorizationService.createNewApiKey();
        String description = "CCS Testing Team " + new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        errorService.saveNewApiKey(key, description);
    }
}


