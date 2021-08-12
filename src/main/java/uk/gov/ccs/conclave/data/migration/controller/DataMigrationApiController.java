package uk.gov.ccs.conclave.data.migration.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import uk.gov.ccs.conclave.data.migration.service.MigrationService;
import uk.gov.ccs.swagger.dataMigration.api.DatamigrationApi;
import uk.gov.ccs.swagger.dataMigration.model.Organisation;
import uk.gov.ccs.swagger.dataMigration.model.Summary;

import java.util.List;

@RestController
public class DataMigrationApiController implements DatamigrationApi {

    private static final Logger log = LoggerFactory.getLogger(DataMigrationApiController.class);

    private final MigrationService migrationService;

    public DataMigrationApiController(MigrationService migrationService) {
        this.migrationService = migrationService;
    }

    @Override
    public ResponseEntity<List<Summary>> appMigrateOrg(String fileFormat, String docId, List<Organisation> body) {
        log.info(" API for data migration invoked for file format " + fileFormat);
        migrationService.migrate(body);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
