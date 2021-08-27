/*
 * CcsSso.WrapperApi
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: v2
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package uk.gov.ccs.swagger.sso.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import uk.gov.ccs.swagger.sso.model.ContactResponseDetail;
import uk.gov.ccs.swagger.sso.model.SiteDetailInfo;
/**
 * OrganisationSiteContactInfo
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-08-27T09:35:55.156031+01:00[Europe/London]")
public class OrganisationSiteContactInfo {
  @SerializedName("contactPointReason")
  private String contactPointReason = null;

  @SerializedName("contactPointName")
  private String contactPointName = null;

  @SerializedName("contactPointId")
  private Integer contactPointId = null;

  @SerializedName("contacts")
  private List<ContactResponseDetail> contacts = null;

  @SerializedName("detail")
  private SiteDetailInfo detail = null;

  public OrganisationSiteContactInfo contactPointReason(String contactPointReason) {
    this.contactPointReason = contactPointReason;
    return this;
  }

   /**
   * Get contactPointReason
   * @return contactPointReason
  **/
  @Schema(description = "")
  public String getContactPointReason() {
    return contactPointReason;
  }

  public void setContactPointReason(String contactPointReason) {
    this.contactPointReason = contactPointReason;
  }

  public OrganisationSiteContactInfo contactPointName(String contactPointName) {
    this.contactPointName = contactPointName;
    return this;
  }

   /**
   * Get contactPointName
   * @return contactPointName
  **/
  @Schema(description = "")
  public String getContactPointName() {
    return contactPointName;
  }

  public void setContactPointName(String contactPointName) {
    this.contactPointName = contactPointName;
  }

  public OrganisationSiteContactInfo contactPointId(Integer contactPointId) {
    this.contactPointId = contactPointId;
    return this;
  }

   /**
   * Get contactPointId
   * @return contactPointId
  **/
  @Schema(description = "")
  public Integer getContactPointId() {
    return contactPointId;
  }

  public void setContactPointId(Integer contactPointId) {
    this.contactPointId = contactPointId;
  }

  public OrganisationSiteContactInfo contacts(List<ContactResponseDetail> contacts) {
    this.contacts = contacts;
    return this;
  }

  public OrganisationSiteContactInfo addContactsItem(ContactResponseDetail contactsItem) {
    if (this.contacts == null) {
      this.contacts = new ArrayList<ContactResponseDetail>();
    }
    this.contacts.add(contactsItem);
    return this;
  }

   /**
   * Get contacts
   * @return contacts
  **/
  @Schema(description = "")
  public List<ContactResponseDetail> getContacts() {
    return contacts;
  }

  public void setContacts(List<ContactResponseDetail> contacts) {
    this.contacts = contacts;
  }

  public OrganisationSiteContactInfo detail(SiteDetailInfo detail) {
    this.detail = detail;
    return this;
  }

   /**
   * Get detail
   * @return detail
  **/
  @Schema(description = "")
  public SiteDetailInfo getDetail() {
    return detail;
  }

  public void setDetail(SiteDetailInfo detail) {
    this.detail = detail;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrganisationSiteContactInfo organisationSiteContactInfo = (OrganisationSiteContactInfo) o;
    return Objects.equals(this.contactPointReason, organisationSiteContactInfo.contactPointReason) &&
        Objects.equals(this.contactPointName, organisationSiteContactInfo.contactPointName) &&
        Objects.equals(this.contactPointId, organisationSiteContactInfo.contactPointId) &&
        Objects.equals(this.contacts, organisationSiteContactInfo.contacts) &&
        Objects.equals(this.detail, organisationSiteContactInfo.detail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contactPointReason, contactPointName, contactPointId, contacts, detail);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrganisationSiteContactInfo {\n");
    
    sb.append("    contactPointReason: ").append(toIndentedString(contactPointReason)).append("\n");
    sb.append("    contactPointName: ").append(toIndentedString(contactPointName)).append("\n");
    sb.append("    contactPointId: ").append(toIndentedString(contactPointId)).append("\n");
    sb.append("    contacts: ").append(toIndentedString(contacts)).append("\n");
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
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
