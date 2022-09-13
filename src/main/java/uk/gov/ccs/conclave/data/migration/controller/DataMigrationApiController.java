package uk.gov.ccs.conclave.data.migration.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import uk.gov.ccs.conclave.data.migration.service.MigrationService;
import uk.gov.ccs.swagger.dataMigration.api.DataMigrationApi;
import uk.gov.ccs.swagger.dataMigration.model.Organisation;

import javax.validation.ConstraintViolationException;

import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;

@RestController
@RequiredArgsConstructor
public class DataMigrationApiController implements DataMigrationApi {

    private static final Logger log = LoggerFactory.getLogger(DataMigrationApiController.class);

    public static List<String> responseArr = new ArrayList<String>();
    public static JSONObject responseReport = new JSONObject();
    public static HttpStatus responseStatus = HttpStatus.OK;

    private final MigrationService migrationService;

    @Override
    public ResponseEntity<JSONObject> appMigrateOrg(String xApiKey, String fileFormat, String docId, List<Organisation> body) {

        responseArr.clear();
        responseReport = new JSONObject();

        if (xApiKey == null || xApiKey.trim().isEmpty() || !migrationService.checkClientApiKey(xApiKey)) {
            log.error("{}:{}","Unauthorised Access ", "Invalid x-api-key. ");
            responseReport.put( "Error", "Unauthorised Access: Invalid x-api-key.");
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(responseReport);
        }

        if (fileFormat.equals("newApiKey")) {
            log.error("{}:{}","Successfully created a new x-api-key. ", "Find the key and details in the database. ");
            migrationService.createClientApiKey();
            responseReport.put( "Info", "Successfully created a new x-api-key. Find the key and details in the database.");
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(responseReport);
        }

        log.info(" API for data migration invoked for file format: " + fileFormat);
        migrationService.migrate(body);

        return ResponseEntity
                .status(responseStatus)
                .body(responseReport);
    }

    @ExceptionHandler({ConstraintViolationException.class, IllegalArgumentException.class})
    public ResponseEntity<String> constraintViolation(Exception exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(exception.getMessage());
    }
}
