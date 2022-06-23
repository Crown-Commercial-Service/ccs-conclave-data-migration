package uk.gov.ccs.swagger.dataMigration.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets StatusDescription
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public enum StatusDescription {
  
  ORGANISATION_REQUIRES_A_MINIMUM_OF_1_ADMIN_USER("Organisation requires a minimum of 1 Admin user"),
  
  UNABLE_TO_PROCESS_RECORD_SEE_HTTP_RESPONSE_CODE("Unable to process record - see http response code"),
  
  RECORD_PROCESSED("Record processed");

  private String value;

  StatusDescription(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static StatusDescription fromValue(String value) {
    for (StatusDescription b : StatusDescription.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    return null;
  }
}

