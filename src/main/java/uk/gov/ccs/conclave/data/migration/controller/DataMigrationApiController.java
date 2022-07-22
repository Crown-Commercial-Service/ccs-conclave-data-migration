package uk.gov.ccs.conclave.data.migration.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import uk.gov.ccs.conclave.data.migration.service.MigrationService;
import uk.gov.ccs.swagger.dataMigration.api.DataMigrationApi;
import uk.gov.ccs.swagger.dataMigration.model.Organisation;
import uk.gov.ccs.swagger.dataMigration.model.Summary;

import javax.validation.ConstraintViolationException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class DataMigrationApiController implements DataMigrationApi {

    private static final Logger log = LoggerFactory.getLogger(DataMigrationApiController.class);

    public static String responseReport;

    private final MigrationService migrationService;

    @Override
    public ResponseEntity<String> appMigrateOrg(String fileFormat, String docId, List<Organisation> body) {
        log.info(" API for data migration invoked for file format " + fileFormat);
        System.out.println(String.format("\n\n HERE -> A (requestbody):  %s \n\n", body));
        migrationService.migrate(body);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("TESTING CON-2464: " + responseReport);
    }

    @ExceptionHandler({ConstraintViolationException.class, IllegalArgumentException.class})
    public ResponseEntity<String> constraintViolation(Exception exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(exception.getMessage());
    }
}
