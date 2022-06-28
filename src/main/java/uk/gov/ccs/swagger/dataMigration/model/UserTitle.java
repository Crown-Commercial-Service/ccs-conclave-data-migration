package uk.gov.ccs.swagger.dataMigration.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets UserTitle
 */
public enum UserTitle {
  MR("Mr"),
    MRS("Mrs"),
    MISS("Miss"),
    MS("Ms"),
    DOCTOR("Doctor"),
    UNSPECIFIED("Unspecified");

  private String value;

  UserTitle(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static UserTitle fromValue(String text) {
    for (UserTitle b : UserTitle.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
