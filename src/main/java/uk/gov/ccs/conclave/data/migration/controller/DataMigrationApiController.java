package uk.gov.ccs.conclave.data.migration.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import uk.gov.ccs.conclave.data.migration.service.MigrationService;
import uk.gov.ccs.swagger.dataMigration.api.DataMigrationApi;
import uk.gov.ccs.swagger.dataMigration.model.Organisation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.simple.JSONObject;
import static uk.gov.ccs.conclave.data.migration.service.ErrorService.*;


@RestController
@RequiredArgsConstructor
public class DataMigrationApiController implements DataMigrationApi {

    private static final Logger log = LoggerFactory.getLogger(DataMigrationApiController.class);

    public static JSONObject responseBody = new JSONObject(); // Overall response body, that is built up then delivered in a json response to the user.
    public static HttpStatus responseStatus; // The status code to be sent in the response.
    public static List<String> responseMsgArray = new ArrayList<String>(); // Stores & collects any error messages or info text, to be added to repsonseBody.

    private final MigrationService migrationService;


    @Override
    public ResponseEntity<JSONObject> appMigrateOrg(String xApiKey, String fileFormat, String docId, MultipartFile csvFile, List<Organisation> body) {

        //Reset the response body, and constituent parts, ready for a new request.
        responseMsgArray.clear();
        responseBody = new JSONObject();
        responseStatus = HttpStatus.OK;

        log.info("Data Migration API invoked for file format: " + fileFormat);

        if (fileFormat.equalsIgnoreCase("json")) {
            migrationService.migrate(body);

        } else if (fileFormat.equalsIgnoreCase("csv")) {
            migrationService.formatCsv(csvFile);

        } else {
            responseBody.put( "Error", API_ENDPOINT_ERROR);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(responseBody);
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseBody);
    }

    @ExceptionHandler({ConstraintViolationException.class, IllegalArgumentException.class})
    public ResponseEntity<String> constraintViolation(Exception exception) throws JsonProcessingException {
        String formattedErrors = formatExceptionMessage(exception.getMessage());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(formattedErrors);
    }

    private static String formatExceptionMessage (String messages) throws JsonProcessingException {

        HashMap<String, List<String>> ExceptionMap = mapExceptionMsg(messages);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(ExceptionMap);

        // beautify exception message
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement je = JsonParser.parseString(json);

        return  gson.toJson(je);
    }

    private static HashMap<String, List<String>> mapExceptionMsg(String messages) {
        HashMap<String, List<String>> result = new HashMap<>();

        String[] messagesArr = messages.split(",");
        Arrays.sort(messagesArr, (a, b)->Integer.compare(extractUserMsgNum(a), extractUserMsgNum(b)));

        for(String message : messagesArr) {
            Pattern pattern = Pattern.compile("body\\[(\\d)\\]");
            Matcher matcher = pattern.matcher(message);
            if (matcher.find()) {
                result.computeIfAbsent(matcher.group(1), k -> new ArrayList<>()).add(message);
            }
        }
        return result;
    }

    private static int extractUserMsgNum (String message) {
        int userNum = 0;
        Pattern pattern = Pattern.compile("user\\[(\\d)\\]");
        Matcher matcher = pattern.matcher(message);
        if (matcher.find()) {
            userNum = Integer.parseInt(matcher.group(1));
        }

        return userNum;
    }
}
