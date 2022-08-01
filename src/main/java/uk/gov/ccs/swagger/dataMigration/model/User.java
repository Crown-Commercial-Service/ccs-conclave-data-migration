package uk.gov.ccs.swagger.dataMigration.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import uk.gov.ccs.swagger.dataMigration.model.UserRole;
import uk.gov.ccs.swagger.dataMigration.model.UserTitle;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * User
 */
@Validated


public class User   {
  @JsonProperty("email")
  private String email = null;

  @JsonProperty("title")
  private UserTitle title = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("lastName")
  private String lastName = null;

  @JsonProperty("contactPointName")
  private String contactPointName = null;

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
  private List<UserRole> userRoles = new ArrayList<UserRole>();

  public User email(String email) {
    this.email = email;
    return this;
  }

  /**
   * User Email
   * @return email
   **/
  @Schema(example = "joe.bloggs@kier.com", required = true, description = "User Email")
      @NotNull

  @Pattern(regexp="^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$") @Size(min=1)   public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public User title(UserTitle title) {
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

  public User firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * First Name
   * @return firstName
   **/
  @Schema(example = "Joe", required = true, description = "First Name")
      @NotNull

  @Size(min=1)   public String getFirstName() {
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
  @Schema(example = "Bloggs", required = true, description = "Last Name")
      @NotNull

  @Size(min=1)   public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public User contactPointName(String contactPointName) {
    this.contactPointName = contactPointName;
    return this;
  }

  /**
   * Name for the user's contact record. Only applied for new users. Blank treated as null. Must be present and non-empty if any other contact fields are.
   * @return contactPointName
   **/
  @Schema(example = "Joe Bloggs", description = "Name for the user's contact record. Only applied for new users. Blank treated as null. Must be present and non-empty if any other contact fields are.")
  
    public String getContactPointName() {
    return contactPointName;
  }

  public void setContactPointName(String contactPointName) {
    this.contactPointName = contactPointName;
  }

  public User contactEmail(String contactEmail) {
    this.contactEmail = contactEmail;
    return this;
  }

  /**
   * User Contact Email. Only applied for new users. Blank treated as null.
   * @return contactEmail
   **/
  @Schema(example = "abc@somewhere.org", description = "User Contact Email. Only applied for new users. Blank treated as null.")
  
  @Pattern(regexp="^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$")   public String getContactEmail() {
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
   * User Contact Mobile. Only applied for new users. Blank treated as null.
   * @return contactMobile
   **/
  @Schema(example = "7956111111", description = "User Contact Mobile. Only applied for new users. Blank treated as null.")
  
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
   * User Contact Telephone. Only applied for new users. Blank treated as null.
   * @return contactPhone
   **/
  @Schema(example = "020 8555 0000", description = "User Contact Telephone. Only applied for new users. Blank treated as null.")
  
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
   * User Contact Fax. Only applied for new users. Blank treated as null.
   * @return contactFax
   **/
  @Schema(example = "020 8555 0001", description = "User Contact Fax. Only applied for new users. Blank treated as null.")
  
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
   * User Contact Social. Only applied for new users. Blank treated as null.
   * @return contactSocial
   **/
  @Schema(example = "http://www.linkedin.com/", description = "User Contact Social. Only applied for new users. Blank treated as null.")
  
    public String getContactSocial() {
    return contactSocial;
  }

  public void setContactSocial(String contactSocial) {
    this.contactSocial = contactSocial;
  }

  public User userRoles(List<UserRole> userRoles) {
    this.userRoles = userRoles;
    return this;
  }

  public User addUserRolesItem(UserRole userRolesItem) {
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


  @Override
  public boolean equals(java.lang.Object o) {
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
        Objects.equals(this.contactPointName, user.contactPointName) &&
        Objects.equals(this.contactEmail, user.contactEmail) &&
        Objects.equals(this.contactMobile, user.contactMobile) &&
        Objects.equals(this.contactPhone, user.contactPhone) &&
        Objects.equals(this.contactFax, user.contactFax) &&
        Objects.equals(this.contactSocial, user.contactSocial) &&
        Objects.equals(this.userRoles, user.userRoles);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, title, firstName, lastName, contactPointName, contactEmail, contactMobile, contactPhone, contactFax, contactSocial, userRoles);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    contactPointName: ").append(toIndentedString(contactPointName)).append("\n");
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
