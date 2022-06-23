package uk.gov.ccs.swagger.dataMigration.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.List;
import uk.gov.ccs.swagger.dataMigration.model.UserRoles;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * User
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class User {

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

  @JsonProperty("contactMobile")
  private String contactMobile;

  @JsonProperty("contactPhone")
  private String contactPhone;

  @JsonProperty("contactFax")
  private String contactFax;

  @JsonProperty("contactSocial")
  private String contactSocial;

  @JsonProperty("userRoles")
  @Valid
  private List<UserRoles> userRoles = null;

  public User email(String email) {
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

  public User title(String title) {
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

  public User firstName(String firstName) {
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

  public User lastName(String lastName) {
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

  public User contactEmail(String contactEmail) {
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

  public User contactMobile(String contactMobile) {
    this.contactMobile = contactMobile;
    return this;
  }

  /**
   * User Contact Mobile
   * @return contactMobile
  */
  
  @Schema(name = "contactMobile", example = "7956111111", description = "User Contact Mobile", required = false)
  public String getContactMobile() {
    return contactMobile;
  }

  public void setContactMobile(String contactMobile) {
    this.contactMobile = contactMobile;
  }

  public User contactPhone(String contactPhone) {
    this.contactPhone = contactPhone;
    return this;
  }

  /**
   * User Contact Telephone
   * @return contactPhone
  */
  
  @Schema(name = "contactPhone", example = "020 8555 0000", description = "User Contact Telephone", required = false)
  public String getContactPhone() {
    return contactPhone;
  }

  public void setContactPhone(String contactPhone) {
    this.contactPhone = contactPhone;
  }

  public User contactFax(String contactFax) {
    this.contactFax = contactFax;
    return this;
  }

  /**
   * User Contact Fax
   * @return contactFax
  */
  
  @Schema(name = "contactFax", example = "020 8555 0001", description = "User Contact Fax", required = false)
  public String getContactFax() {
    return contactFax;
  }

  public void setContactFax(String contactFax) {
    this.contactFax = contactFax;
  }

  public User contactSocial(String contactSocial) {
    this.contactSocial = contactSocial;
    return this;
  }

  /**
   * User Contact Socila
   * @return contactSocial
  */
  
  @Schema(name = "contactSocial", example = "http://www.linkedin.com/", description = "User Contact Socila", required = false)
  public String getContactSocial() {
    return contactSocial;
  }

  public void setContactSocial(String contactSocial) {
    this.contactSocial = contactSocial;
  }

  public User userRoles(List<UserRoles> userRoles) {
    this.userRoles = userRoles;
    return this;
  }

  public User addUserRolesItem(UserRoles userRolesItem) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(this.email, user.email) &&
        Objects.equals(this.title, user.title) &&
        Objects.equals(this.firstName, user.firstName) &&
        Objects.equals(this.lastName, user.lastName) &&
        Objects.equals(this.contactEmail, user.contactEmail) &&
        Objects.equals(this.contactMobile, user.contactMobile) &&
        Objects.equals(this.contactPhone, user.contactPhone) &&
        Objects.equals(this.contactFax, user.contactFax) &&
        Objects.equals(this.contactSocial, user.contactSocial) &&
        Objects.equals(this.userRoles, user.userRoles);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, title, firstName, lastName, contactEmail, contactMobile, contactPhone, contactFax, contactSocial, userRoles);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    contactEmail: ").append(toIndentedString(contactEmail)).append("\n");
    sb.append("    contactMobile: ").append(toIndentedString(contactMobile)).append("\n");
    sb.append("    contactPhone: ").append(toIndentedString(contactPhone)).append("\n");
    sb.append("    contactFax: ").append(toIndentedString(contactFax)).append("\n");
    sb.append("    contactSocial: ").append(toIndentedString(contactSocial)).append("\n");
    sb.append("    userRoles: ").append(toIndentedString(userRoles)).append("\n");
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

