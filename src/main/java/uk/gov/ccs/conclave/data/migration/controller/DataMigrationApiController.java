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

import static uk.gov.ccs.conclave.data.migration.service.ErrorService.*;

@RestController
@RequiredArgsConstructor
public class DataMigrationApiController implements DataMigrationApi {

    private static final Logger log = LoggerFactory.getLogger(DataMigrationApiController.class);

    public static List<String> responseArr = new ArrayList<String>(); // Stores & collects any error messages or info text, to be added to repsonse body.
    public static JSONObject responseReport; // Overall response body, that is built up then delivered in a json response to the user.
    public static HttpStatus responseStatus; // The status code to be sent in the response.

    private final MigrationService migrationService;

    @Override
    public ResponseEntity<JSONObject> appMigrateOrg(String xApiKey, String fileFormat, String docId, List<Organisation> body) {

        // Reset the response body, and constituent parts, ready for a new request.
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
