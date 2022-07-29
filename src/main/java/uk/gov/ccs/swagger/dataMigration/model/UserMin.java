package uk.gov.ccs.swagger.dataMigration.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import uk.gov.ccs.swagger.dataMigration.model.Status;
import uk.gov.ccs.swagger.dataMigration.model.UserRole;
import uk.gov.ccs.swagger.dataMigration.model.UserTitle;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UserMin
 */
@Validated


public class UserMin   {
  @JsonProperty("email")
  private String email = null;

  @JsonProperty("title")
  private UserTitle title = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("lastName")
  private String lastName = null;

  @JsonProperty("contactEmail")
  private String contactEmail = null;

  @JsonProperty("userRoles")
  @Valid
  private List<UserRole> userRoles = new ArrayList<UserRole>();

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
   **/
  @Schema(example = "joe.bloggs@kier.com", description = "User Email")
  
    public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UserMin title(UserTitle title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
   **/
  @Schema(description = "")
  
    @Valid
    public UserTitle getTitle() {
    return title;
  }

  public void setTitle(UserTitle title) {
    this.title = title;
  }

  public UserMin firstName(String firstName) {
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

  public UserMin lastName(String lastName) {
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

  public UserMin contactEmail(String contactEmail) {
    this.contactEmail = contactEmail;
    return this;
  }

  /**
   * User Contact Email
   * @return contactEmail
   **/
  @Schema(example = "abc@somewhere.org", description = "User Contact Email")
  
    public String getContactEmail() {
    return contactEmail;
  }

  public void setContactEmail(String contactEmail) {
    this.contactEmail = contactEmail;
  }

  public UserMin userRoles(List<UserRole> userRoles) {
    this.userRoles = userRoles;
    return this;
  }

  public UserMin addUserRolesItem(UserRole userRolesItem) {
    this.userRoles.add(userRolesItem);
    return this;
  }

  /**
   * Get userRoles
   * @return userRoles
   **/
  @Schema(required = true, description = "")
      @NotNull
    @Valid
  @Size(min=1)   public List<UserRole> getUserRoles() {
    return userRoles;
  }

  public void setUserRoles(List<UserRole> userRoles) {
    this.userRoles = userRoles;
  }

  public UserMin status(List<Status> status) {
    this.status = status;
    return this;
  }

  public UserMin addStatusItem(Status statusItem) {
    if (this.status == null) {
      this.status = new ArrayList<Status>();
    }
    this.status.add(statusItem);
    return this;
  }

  /**
   * Get status
   * @return status
   **/
  @Schema(description = "")
      @Valid
    public List<Status> getStatus() {
    return status;
  }

  public void setStatus(List<Status> status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
