package uk.gov.ccs.swagger.dataMigration.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * User
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-08-11T09:49:50.709Z[GMT]")


public class User   {
  @JsonProperty("email")
  private String email = null;

  @JsonProperty("title")
  private String title = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("lastName")
  private String lastName = null;

  @JsonProperty("contactEmail")
  private String contactEmail = null;

  @JsonProperty("contactMobile")
  private String contactMobile = null;

  @JsonProperty("contactPhone")
  private String contactPhone = null;

  @JsonProperty("contactFax")
  private String contactFax = null;

  @JsonProperty("contactSocial")
  private String contactSocial = null;

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
   **/
  @Schema(example = "joe.bloggs@kier.com", description = "User Email")
  
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
   **/
  @Schema(example = "Mr", description = "User Title")
  
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
   **/
  @Schema(example = "Joe", description = "First Name")
  
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
   **/
  @Schema(example = "Bloggs", description = "Last Name")
  
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
   **/
  @Schema(example = "abc@somewhere.org", description = "User Contact Email")
  
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
   **/
  @Schema(example = "07956111111", description = "User Contact Mobile")
  
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
   **/
  @Schema(example = "020 8555 0000", description = "User Contact Telephone")
  
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
   **/
  @Schema(example = "020 8555 0001", description = "User Contact Fax")
  
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
   **/
  @Schema(example = "http://www.linkedin.com/", description = "User Contact Socila")
  
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
      this.userRoles = new ArrayList<UserRoles>();
    }
    this.userRoles.add(userRolesItem);
    return this;
  }

  /**
   * Get userRoles
   * @return userRoles
   **/
  @Schema(description = "")
      @Valid
    public List<UserRoles> getUserRoles() {
    return userRoles;
  }

  public void setUserRoles(List<UserRoles> userRoles) {
    this.userRoles = userRoles;
  }

  public boolean isRoleAdmin(List<UserRoles> roles) {
    if (roles == null) {
      return false;
    } else {
      return roles.stream().anyMatch(role -> role.getName().equals("Organisation Administrator"));
    }
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
