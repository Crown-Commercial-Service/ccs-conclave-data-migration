package uk.gov.ccs.conclave.data.migration.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import uk.gov.ccs.conclave.data.migration.service.MigrationService;
import uk.gov.ccs.swagger.dataMigration.api.DataMigrationApi;
import uk.gov.ccs.swagger.dataMigration.model.Organisation;

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
        responseStatus = HttpStatus.OK;

        if (xApiKey == null || xApiKey.trim().isEmpty() || !migrationService.checkClientApiKey(xApiKey)) {
            //responseReport.put( "Error", API_KEY_ERROR);

            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(responseReport);

        } else if (fileFormat.equals("newApiKey")) {
            migrationService.createClientApiKey();
            //responseReport.put( "Info", API_KEY_INFO);

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(responseReport);
        }

        log.info("Data Migration API invoked for file format: " + fileFormat);
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
