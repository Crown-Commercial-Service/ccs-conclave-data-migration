package uk.gov.ccs.swagger.dataMigration.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.List;
import uk.gov.ccs.swagger.dataMigration.model.Status;
import uk.gov.ccs.swagger.dataMigration.model.UserRoles;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * UserMin
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class UserMin {

  @JsonProperty("email")
  private String email;

  @JsonProperty("title")
  private String title;

  @JsonProperty("firstName")
  private String firstName;

  @JsonProperty("lastName")
  private String lastName;

  @JsonProperty("contactEmail")
  private String contactEmail;

  @JsonProperty("userRoles")
  @Valid
  private List<UserRoles> userRoles = null;

  @JsonProperty("status")
  @Valid
  private List<Status> status = null;

  public UserMin email(String email) {
    this.email = email;
    return this;
  }

  /**
   * User Email
   * @return email
  */
  
  @Schema(name = "email", example = "joe.bloggs@kier.com", description = "User Email", required = false)
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UserMin title(String title) {
    this.title = title;
    return this;
  }

  /**
   * User Title
   * @return title
  */
  
  @Schema(name = "title", example = "Mr", description = "User Title", required = false)
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public UserMin firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * First Name
   * @return firstName
  */
  
  @Schema(name = "firstName", example = "Joe", description = "First Name", required = false)
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public UserMin lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Last Name
   * @return lastName
  */
  
  @Schema(name = "lastName", example = "Bloggs", description = "Last Name", required = false)
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public UserMin contactEmail(String contactEmail) {
    this.contactEmail = contactEmail;
    return this;
  }

  /**
   * User Contact Email
   * @return contactEmail
  */
  
  @Schema(name = "contactEmail", example = "abc@somewhere.org", description = "User Contact Email", required = false)
  public String getContactEmail() {
    return contactEmail;
  }

  public void setContactEmail(String contactEmail) {
    this.contactEmail = contactEmail;
  }

  public UserMin userRoles(List<UserRoles> userRoles) {
    this.userRoles = userRoles;
    return this;
  }

  public UserMin addUserRolesItem(UserRoles userRolesItem) {
    if (this.userRoles == null) {
      this.userRoles = new ArrayList<>();
    }
    this.userRoles.add(userRolesItem);
    return this;
  }

  /**
   * Get userRoles
   * @return userRoles
  */
  @Valid 
  @Schema(name = "userRoles", required = false)
  public List<UserRoles> getUserRoles() {
    return userRoles;
  }

  public void setUserRoles(List<UserRoles> userRoles) {
    this.userRoles = userRoles;
  }

  public UserMin status(List<Status> status) {
    this.status = status;
    return this;
  }

  public UserMin addStatusItem(Status statusItem) {
    if (this.status == null) {
      this.status = new ArrayList<>();
    }
    this.status.add(statusItem);
    return this;
  }

  /**
   * Get status
   * @return status
  */
  @Valid 
  @Schema(name = "status", required = false)
  public List<Status> getStatus() {
    return status;
  }

  public void setStatus(List<Status> status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserMin userMin = (UserMin) o;
    return Objects.equals(this.email, userMin.email) &&
        Objects.equals(this.title, userMin.title) &&
        Objects.equals(this.firstName, userMin.firstName) &&
        Objects.equals(this.lastName, userMin.lastName) &&
        Objects.equals(this.contactEmail, userMin.contactEmail) &&
        Objects.equals(this.userRoles, userMin.userRoles) &&
        Objects.equals(this.status, userMin.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, title, firstName, lastName, contactEmail, userRoles, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserMin {\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    contactEmail: ").append(toIndentedString(contactEmail)).append("\n");
    sb.append("    userRoles: ").append(toIndentedString(userRoles)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

