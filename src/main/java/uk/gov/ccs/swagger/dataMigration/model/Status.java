package uk.gov.ccs.swagger.dataMigration.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets Status
 */
public enum Status {
  _200_OK("200 OK"),
    _201_CREATED("201 Created"),
    _400_BAD_REQUEST("400 Bad request"),
    _401_UNATHORIZED("401 Unathorized"),
    _403_FORBIDDEN("403 Forbidden"),
    _404_NOT_FOUND("404 Not found"),
    _409_DUPLICATE_RESOURCE("409 Duplicate resource"),
    _429_TOO_MANY_REQUESTS("429 Too Many Requests"),
    _500_INTERNAL_SERVER_ERROR("500 Internal Server Error"),
    _502_BAD_GATEWAY("502 Bad Gateway"),
    _503_SERVICE_UNAVAILABLE_LIMIT_EXCEEDED("503 Service Unavailable/Limit Exceeded"),
    _504_GATEWAY_TIMEOUT("504 Gateway Timeout"),
    _505_HTTP_VERSION_NOT_SUPPORTED("505 HTTP Version Not Supported");

  private String value;

  Status(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static Status fromValue(String text) {
    for (Status b : Status.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
