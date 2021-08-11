package uk.gov.ccs.swagger.dataMigration.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets StatusDescription
 */
public enum StatusDescription {
  ORGANISATION_REQUIRES_A_MINIMUM_OF_1_ADMIN_USER("Organisation requires a minimum of 1 Admin user"),
    UNABLE_TO_PROCESS_RECORD_SEE_HTTP_RESPONSE_CODE("Unable to process record - see http response code"),
    RECORD_PROCESSED("Record processed");

  private String value;

  StatusDescription(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static StatusDescription fromValue(String text) {
    for (StatusDescription b : StatusDescription.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
