package uk.gov.ccs.swagger.dataMigration.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * Summary
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-08-06T08:59:45.567Z[GMT]")


public class Summary   {
  @JsonProperty("identifier-id")
  private String identifierId = null;

  @JsonProperty("scheme-id")
  private String schemeId = null;

  @JsonProperty("title")
  private String title = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("lastName")
  private String lastName = null;

  @JsonProperty("email")
  private String email = null;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    _200_OK_201_CREATED_400_BAD_REQUEST_401_UNATHORIZED_403_FORBIDDEN_404_NOT_FOUND_409_DUPLICATE_RESOURCE_429_TOO_MANY_REQUESTS_500_INTERNAL_SERVER_ERROR_502_BAD_GATEWAY_503_SERVICE_UNAVAILABLE_LIMIT_EXCEEDED_504_GATEWAY_TIMEOUT_505_HTTP_VERSION_NOT_SUPPORTED("200 OK - 201 Created - 400 Bad request - 401 Unathorized - 403 Forbidden - 404 Not found - 409 Duplicate resource - 429 Too Many Requests - 500 Internal Server Error - 502 Bad Gateway - 503 Service Unavailable/Limit Exceeded - 504 Gateway Timeout - 505 HTTP Version Not Supported");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("status")
  private StatusEnum status = null;

  /**
   * Gets or Sets statusDescription
   */
  public enum StatusDescriptionEnum {
    ORGANISATION_REQUIRES_A_MINIMUM_OF_1_ADMIN_USER_UNABLE_TO_PROCESS_RECORD_SEE_HTTP_RESPONSE_CODE_RECORD_PROCESSED("Organisation requires a minimum of 1 Admin user - Unable to process record - see http response code - Record processed");

    private String value;

    StatusDescriptionEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusDescriptionEnum fromValue(String text) {
      for (StatusDescriptionEnum b : StatusDescriptionEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("statusDescription")
  private StatusDescriptionEnum statusDescription = null;

  public Summary identifierId(String identifierId) {
    this.identifierId = identifierId;
    return this;
  }

  /**
   * Identifier ID
   * @return identifierId
   **/
  @Schema(example = "100009655", description = "Identifier ID")
  
    public String getIdentifierId() {
    return identifierId;
  }

  public void setIdentifierId(String identifierId) {
    this.identifierId = identifierId;
  }

  public Summary schemeId(String schemeId) {
    this.schemeId = schemeId;
    return this;
  }

  /**
   * Scheme ID (GB-COH, US-DUNS, SF-URN, SF-ID)
   * @return schemeId
   **/
  @Schema(example = "GB-COH", description = "Scheme ID (GB-COH, US-DUNS, SF-URN, SF-ID)")
  
    public String getSchemeId() {
    return schemeId;
  }

  public void setSchemeId(String schemeId) {
    this.schemeId = schemeId;
  }

  public Summary title(String title) {
    this.title = title;
    return this;
  }

  /**
   * User Title
   * @return title
   **/
  @Schema(example = "Mr", description = "User Title")
  
    public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Summary firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * First Name
   * @return firstName
   **/
  @Schema(example = "Joe", description = "First Name")
  
    public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Summary lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Last Name
   * @return lastName
   **/
  @Schema(example = "Bloggs", description = "Last Name")
  
    public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Summary email(String email) {
    this.email = email;
    return this;
  }

  /**
   * User Email
   * @return email
   **/
  @Schema(example = "joe.bloggs@kier.com", description = "User Email")
  
    public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Summary status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   **/
  @Schema(description = "")
  
    public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public Summary statusDescription(StatusDescriptionEnum statusDescription) {
    this.statusDescription = statusDescription;
    return this;
  }

  /**
   * Get statusDescription
   * @return statusDescription
   **/
  @Schema(description = "")
  
    public StatusDescriptionEnum getStatusDescription() {
    return statusDescription;
  }

  public void setStatusDescription(StatusDescriptionEnum statusDescription) {
    this.statusDescription = statusDescription;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Summary summary = (Summary) o;
    return Objects.equals(this.identifierId, summary.identifierId) &&
        Objects.equals(this.schemeId, summary.schemeId) &&
        Objects.equals(this.title, summary.title) &&
        Objects.equals(this.firstName, summary.firstName) &&
        Objects.equals(this.lastName, summary.lastName) &&
        Objects.equals(this.email, summary.email) &&
        Objects.equals(this.status, summary.status) &&
        Objects.equals(this.statusDescription, summary.statusDescription);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identifierId, schemeId, title, firstName, lastName, email, status, statusDescription);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Summary {\n");
    
    sb.append("    identifierId: ").append(toIndentedString(identifierId)).append("\n");
    sb.append("    schemeId: ").append(toIndentedString(schemeId)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    statusDescription: ").append(toIndentedString(statusDescription)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
