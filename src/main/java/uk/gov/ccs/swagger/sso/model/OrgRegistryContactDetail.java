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
import java.util.ArrayList;
import java.util.List;
import uk.gov.ccs.swagger.sso.model.ContactRequestDetail;
import uk.gov.ccs.swagger.sso.model.OrgRegistryAddressDetails;
/**
 * OrgRegistryContactDetail
 */


public class OrgRegistryContactDetail {
  @SerializedName("contactPointName")
  private String contactPointName = null;

  @SerializedName("address")
  private OrgRegistryAddressDetails address = null;

  @SerializedName("contacts")
  private List<ContactRequestDetail> contacts = null;

  public OrgRegistryContactDetail contactPointName(String contactPointName) {
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

  public OrgRegistryContactDetail address(OrgRegistryAddressDetails address) {
    this.address = address;
    return this;
  }

   /**
   * Get address
   * @return address
  **/
  @Schema(description = "")
  public OrgRegistryAddressDetails getAddress() {
    return address;
  }

  public void setAddress(OrgRegistryAddressDetails address) {
    this.address = address;
  }

  public OrgRegistryContactDetail contacts(List<ContactRequestDetail> contacts) {
    this.contacts = contacts;
    return this;
  }

  public OrgRegistryContactDetail addContactsItem(ContactRequestDetail contactsItem) {
    if (this.contacts == null) {
      this.contacts = new ArrayList<ContactRequestDetail>();
    }
    this.contacts.add(contactsItem);
    return this;
  }

   /**
   * Get contacts
   * @return contacts
  **/
  @Schema(description = "")
  public List<ContactRequestDetail> getContacts() {
    return contacts;
  }

  public void setContacts(List<ContactRequestDetail> contacts) {
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
    OrgRegistryContactDetail orgRegistryContactDetail = (OrgRegistryContactDetail) o;
    return Objects.equals(this.contactPointName, orgRegistryContactDetail.contactPointName) &&
        Objects.equals(this.address, orgRegistryContactDetail.address) &&
        Objects.equals(this.contacts, orgRegistryContactDetail.contacts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contactPointName, address, contacts);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrgRegistryContactDetail {\n");
    
    sb.append("    contactPointName: ").append(toIndentedString(contactPointName)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
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
