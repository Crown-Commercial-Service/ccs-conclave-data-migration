/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.27).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package uk.gov.ccs.swagger.dataMigration.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import uk.gov.ccs.swagger.dataMigration.model.Organisation;
import uk.gov.ccs.swagger.dataMigration.model.Summary;

import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-08-11T09:49:50.709Z[GMT]")
@Validated
public interface DatamigrationApi {

    @Operation(summary = "A generic endpoint for regisering organisations and users", description = "", tags={ "datamigration" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Summary.class)))),
        
        @ApiResponse(responseCode = "201", description = "Created"),
        
        @ApiResponse(responseCode = "400", description = "Bad Request"),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized"),
        
        @ApiResponse(responseCode = "403", description = "Forbidden"),
        
        @ApiResponse(responseCode = "404", description = "Not Found"),
        
        @ApiResponse(responseCode = "409", description = "Duplicate resource"),
        
        @ApiResponse(responseCode = "429", description = "Too Many Requests"),
        
        @ApiResponse(responseCode = "500", description = "Internal Server Error"),
        
        @ApiResponse(responseCode = "501", description = "Not Implemented"),
        
        @ApiResponse(responseCode = "502", description = "Bad Gateway"),
        
        @ApiResponse(responseCode = "503", description = "Service Unavailable/Limit Exceeded"),
        
        @ApiResponse(responseCode = "504", description = "Gateway Timeout"),
        
        @ApiResponse(responseCode = "505", description = "HTTP Version Not Supported") })
    @RequestMapping(value = "/datamigration/migrate/format/{fileFormat}",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<List<Summary>> appMigrateOrg(@Parameter(in = ParameterIn.PATH, description = "File format - CSV/JSON", required=true, schema=@Schema()) @PathVariable("fileFormat") String fileFormat, @Parameter(in = ParameterIn.QUERY, description = "file location e.g. /path" ,schema=@Schema()) @Valid @RequestParam(value = "docId", required = false) String docId, @Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody List<Organisation> body);

}

