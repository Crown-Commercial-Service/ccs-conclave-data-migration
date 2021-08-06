package uk.gov.ccs.conclave.data.migration.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uk.gov.ccs.conclave.data.migration.model.OrgUser;
import uk.gov.ccs.conclave.data.migration.model.Summary;
import uk.gov.ccs.swagger.dataMigration.api.DatamigrationApi;

import java.util.List;

@RestController
public class DataMigrationApiController implements DatamigrationApi {

    private static final Logger log = LoggerFactory.getLogger(DataMigrationApiController.class);

    public ResponseEntity<List<Summary>> appMigrateOrg(@Parameter(in = ParameterIn.PATH, description = "File format - CSV/JSON", required = true, schema = @Schema()) @PathVariable("fileFormat") String fileFormat, @Parameter(in = ParameterIn.QUERY, description = "file location e.g. /path", schema = @Schema()) @Validated @RequestParam(value = "filePath", required = false) String filePath, @Parameter(in = ParameterIn.DEFAULT, description = "", schema = @Schema()) @Validated @RequestBody List<OrgUser> body) {
        log.info(" API for data migration invoked for file format " + fileFormat);
        Summary summary = new Summary();
        summary.firstName("Dummy");
        return new ResponseEntity<>(List.of(summary), HttpStatus.NOT_IMPLEMENTED);
    }

}
