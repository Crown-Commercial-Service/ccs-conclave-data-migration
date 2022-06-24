/*
 * CcsSso.WrapperApi
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
import java.util.ArrayList;
import java.util.List;
import uk.gov.ccs.swagger.sso.model.AssignedContactType;
import uk.gov.ccs.swagger.sso.model.ContactResponseDetail;
/**
 * ContactResponseInfo
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-12-07T09:38:21.309374Z[Europe/London]")
public class ContactResponseInfo {
  @SerializedName("contactPointReason")
  private String contactPointReason = null;

  @SerializedName("contactPointName")
  private String contactPointName = null;

  @SerializedName("contactPointId")
  private Integer contactPointId = null;

  @SerializedName("originalContactPointId")
  private Integer originalContactPointId = null;

  @SerializedName("assignedContactType")
  private AssignedContactType assignedContactType = null;

  @SerializedName("contacts")
  private List<ContactResponseDetail> contacts = null;

  public ContactResponseInfo contactPointReason(String contactPointReason) {
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

  public ContactResponseInfo contactPointName(String contactPointName) {
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

  public ContactResponseInfo contactPointId(Integer contactPointId) {
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

  public ContactResponseInfo originalContactPointId(Integer originalContactPointId) {
    this.originalContactPointId = originalContactPointId;
    return this;
  }

   /**
   * Get originalContactPointId
   * @return originalContactPointId
  **/
  @Schema(description = "")
  public Integer getOriginalContactPointId() {
    return originalContactPointId;
  }

  public void setOriginalContactPointId(Integer originalContactPointId) {
    this.originalContactPointId = originalContactPointId;
  }

  public ContactResponseInfo assignedContactType(AssignedContactType assignedContactType) {
    this.assignedContactType = assignedContactType;
    return this;
  }

   /**
   * Get assignedContactType
   * @return assignedContactType
  **/
  @Schema(description = "")
  public AssignedContactType getAssignedContactType() {
    return assignedContactType;
  }

  public void setAssignedContactType(AssignedContactType assignedContactType) {
    this.assignedContactType = assignedContactType;
  }

  public ContactResponseInfo contacts(List<ContactResponseDetail> contacts) {
    this.contacts = contacts;
    return this;
  }

  public ContactResponseInfo addContactsItem(ContactResponseDetail contactsItem) {
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContactResponseInfo contactResponseInfo = (ContactResponseInfo) o;
    return Objects.equals(this.contactPointReason, contactResponseInfo.contactPointReason) &&
        Objects.equals(this.contactPointName, contactResponseInfo.contactPointName) &&
        Objects.equals(this.contactPointId, contactResponseInfo.contactPointId) &&
        Objects.equals(this.originalContactPointId, contactResponseInfo.originalContactPointId) &&
        Objects.equals(this.assignedContactType, contactResponseInfo.assignedContactType) &&
        Objects.equals(this.contacts, contactResponseInfo.contacts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contactPointReason, contactPointName, contactPointId, originalContactPointId, assignedContactType, contacts);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContactResponseInfo {\n");
    
    sb.append("    contactPointReason: ").append(toIndentedString(contactPointReason)).append("\n");
    sb.append("    contactPointName: ").append(toIndentedString(contactPointName)).append("\n");
    sb.append("    contactPointId: ").append(toIndentedString(contactPointId)).append("\n");
    sb.append("    originalContactPointId: ").append(toIndentedString(originalContactPointId)).append("\n");
    sb.append("    assignedContactType: ").append(toIndentedString(assignedContactType)).append("\n");
    sb.append("    contacts: ").append(toIndentedString(contacts)).append("\n");
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
