package uk.gov.ccs.swagger.dataMigration.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * OrgUser
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-08-06T08:59:45.567Z[GMT]")
public class OrgUser   {
  @JsonProperty("identifier-id")
  private String identifierId = null;

  @JsonProperty("scheme-id")
  private String schemeId = null;

  @JsonProperty("rightToBuy")
  private Boolean rightToBuy;

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

  @JsonProperty("orgRoles")
  private List<OrgRoles> orgRoles = null;

  @JsonProperty("userRoles")
  private List<UserRoles> userRoles = null;

  public OrgUser identifierId(String identifierId) {
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

  public OrgUser schemeId(String schemeId) {
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

  public OrgUser rightToBuy(Boolean rightToBuy) {
    this.rightToBuy = rightToBuy;
    return this;
  }

  /**
   * Buyer status
   * @return rightToBuy
   **/
  @Schema(example = "true", description = "Buyer status")

    public Boolean isRightToBuy() {
    return rightToBuy;
  }

  public void setRightToBuy(Boolean rightToBuy) {
    this.rightToBuy = rightToBuy;
  }

  public OrgUser email(String email) {
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

  public OrgUser title(String title) {
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

  public OrgUser firstName(String firstName) {
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

  public OrgUser lastName(String lastName) {
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

  public OrgUser contactEmail(String contactEmail) {
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

  public OrgUser contactMobile(String contactMobile) {
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

  public OrgUser contactPhone(String contactPhone) {
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

  public OrgUser contactFax(String contactFax) {
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

  public OrgUser contactSocial(String contactSocial) {
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

  public OrgUser orgRoles(List<OrgRoles> orgRoles) {
    this.orgRoles = orgRoles;
    return this;
  }

  public OrgUser addOrgRolesItem(OrgRoles orgRolesItem) {
    if (this.orgRoles == null) {
      this.orgRoles = new ArrayList<OrgRoles>();
    }
    this.orgRoles.add(orgRolesItem);
    return this;
  }

  /**
   * Get orgRoles
   * @return orgRoles
   **/
  @Schema(description = "")
    public List<OrgRoles> getOrgRoles() {
    return orgRoles;
  }

  public void setOrgRoles(List<OrgRoles> orgRoles) {
    this.orgRoles = orgRoles;
  }

  public OrgUser userRoles(List<UserRoles> userRoles) {
    this.userRoles = userRoles;
    return this;
  }

  public OrgUser addUserRolesItem(UserRoles userRolesItem) {
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
    OrgUser orgUser = (OrgUser) o;
    return Objects.equals(this.identifierId, orgUser.identifierId) &&
        Objects.equals(this.schemeId, orgUser.schemeId) &&
        Objects.equals(this.rightToBuy, orgUser.rightToBuy) &&
        Objects.equals(this.email, orgUser.email) &&
        Objects.equals(this.title, orgUser.title) &&
        Objects.equals(this.firstName, orgUser.firstName) &&
        Objects.equals(this.lastName, orgUser.lastName) &&
        Objects.equals(this.contactEmail, orgUser.contactEmail) &&
        Objects.equals(this.contactMobile, orgUser.contactMobile) &&
        Objects.equals(this.contactPhone, orgUser.contactPhone) &&
        Objects.equals(this.contactFax, orgUser.contactFax) &&
        Objects.equals(this.contactSocial, orgUser.contactSocial) &&
        Objects.equals(this.orgRoles, orgUser.orgRoles) &&
        Objects.equals(this.userRoles, orgUser.userRoles);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identifierId, schemeId, rightToBuy, email, title, firstName, lastName, contactEmail, contactMobile, contactPhone, contactFax, contactSocial, orgRoles, userRoles);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrgUser {\n");
    
    sb.append("    identifierId: ").append(toIndentedString(identifierId)).append("\n");
    sb.append("    schemeId: ").append(toIndentedString(schemeId)).append("\n");
    sb.append("    rightToBuy: ").append(toIndentedString(rightToBuy)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    contactEmail: ").append(toIndentedString(contactEmail)).append("\n");
    sb.append("    contactMobile: ").append(toIndentedString(contactMobile)).append("\n");
    sb.append("    contactPhone: ").append(toIndentedString(contactPhone)).append("\n");
    sb.append("    contactFax: ").append(toIndentedString(contactFax)).append("\n");
    sb.append("    contactSocial: ").append(toIndentedString(contactSocial)).append("\n");
    sb.append("    orgRoles: ").append(toIndentedString(orgRoles)).append("\n");
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
