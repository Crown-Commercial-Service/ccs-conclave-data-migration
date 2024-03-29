/*
 * CcsSso.ContactApi
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: v1
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
import uk.gov.ccs.swagger.sso.model.ContactRequestInfo;
/**
 * CreateContactRequestInfo
 */


public class CreateContactRequestInfo {
  @SerializedName("contactRequestInfo")
  private ContactRequestInfo contactRequestInfo = null;

  @SerializedName("organisationId")
  private Integer organisationId = null;

  @SerializedName("partyId")
  private Integer partyId = null;

  @SerializedName("partyTypeId")
  private Integer partyTypeId = null;

  @SerializedName("isSite")
  private Boolean isSite = null;

  @SerializedName("siteId")
  private Integer siteId = null;

  public CreateContactRequestInfo contactRequestInfo(ContactRequestInfo contactRequestInfo) {
    this.contactRequestInfo = contactRequestInfo;
    return this;
  }

   /**
   * Get contactRequestInfo
   * @return contactRequestInfo
  **/
  @Schema(description = "")
  public ContactRequestInfo getContactRequestInfo() {
    return contactRequestInfo;
  }

  public void setContactRequestInfo(ContactRequestInfo contactRequestInfo) {
    this.contactRequestInfo = contactRequestInfo;
  }

  public CreateContactRequestInfo organisationId(Integer organisationId) {
    this.organisationId = organisationId;
    return this;
  }

   /**
   * Get organisationId
   * @return organisationId
  **/
  @Schema(description = "")
  public Integer getOrganisationId() {
    return organisationId;
  }

  public void setOrganisationId(Integer organisationId) {
    this.organisationId = organisationId;
  }

  public CreateContactRequestInfo partyId(Integer partyId) {
    this.partyId = partyId;
    return this;
  }

   /**
   * Get partyId
   * @return partyId
  **/
  @Schema(description = "")
  public Integer getPartyId() {
    return partyId;
  }

  public void setPartyId(Integer partyId) {
    this.partyId = partyId;
  }

  public CreateContactRequestInfo partyTypeId(Integer partyTypeId) {
    this.partyTypeId = partyTypeId;
    return this;
  }

   /**
   * Get partyTypeId
   * @return partyTypeId
  **/
  @Schema(description = "")
  public Integer getPartyTypeId() {
    return partyTypeId;
  }

  public void setPartyTypeId(Integer partyTypeId) {
    this.partyTypeId = partyTypeId;
  }

  public CreateContactRequestInfo isSite(Boolean isSite) {
    this.isSite = isSite;
    return this;
  }

   /**
   * Get isSite
   * @return isSite
  **/
  @Schema(description = "")
  public Boolean isIsSite() {
    return isSite;
  }

  public void setIsSite(Boolean isSite) {
    this.isSite = isSite;
  }

  public CreateContactRequestInfo siteId(Integer siteId) {
    this.siteId = siteId;
    return this;
  }

   /**
   * Get siteId
   * @return siteId
  **/
  @Schema(description = "")
  public Integer getSiteId() {
    return siteId;
  }

  public void setSiteId(Integer siteId) {
    this.siteId = siteId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateContactRequestInfo createContactRequestInfo = (CreateContactRequestInfo) o;
    return Objects.equals(this.contactRequestInfo, createContactRequestInfo.contactRequestInfo) &&
        Objects.equals(this.organisationId, createContactRequestInfo.organisationId) &&
        Objects.equals(this.partyId, createContactRequestInfo.partyId) &&
        Objects.equals(this.partyTypeId, createContactRequestInfo.partyTypeId) &&
        Objects.equals(this.isSite, createContactRequestInfo.isSite) &&
        Objects.equals(this.siteId, createContactRequestInfo.siteId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contactRequestInfo, organisationId, partyId, partyTypeId, isSite, siteId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateContactRequestInfo {\n");
    
    sb.append("    contactRequestInfo: ").append(toIndentedString(contactRequestInfo)).append("\n");
    sb.append("    organisationId: ").append(toIndentedString(organisationId)).append("\n");
    sb.append("    partyId: ").append(toIndentedString(partyId)).append("\n");
    sb.append("    partyTypeId: ").append(toIndentedString(partyTypeId)).append("\n");
    sb.append("    isSite: ").append(toIndentedString(isSite)).append("\n");
    sb.append("    siteId: ").append(toIndentedString(siteId)).append("\n");
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
