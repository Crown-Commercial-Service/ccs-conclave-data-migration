/*
 * CCS Central Identity Index Service (CII)
 * This is an example CCS Central Identity Index (CII) Service API.
 *
 * OpenAPI spec version: 1.0.4
 * Contact: apiteam@crowncommercial.gov.uk
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package uk.gov.ccs.swagger.cii.model;

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
import uk.gov.ccs.swagger.cii.model.Address;
import uk.gov.ccs.swagger.cii.model.ContactPoint;
import uk.gov.ccs.swagger.cii.model.Identifier;
/**
 * OrgMigration
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-07-27T12:42:34.957888+01:00[Europe/London]")
public class OrgMigration {
  @SerializedName("organisationId")
  private String organisationId = null;

  @SerializedName("identifier")
  private Identifier identifier = null;

  @SerializedName("additionalIdentifiers")
  private List<Identifier> additionalIdentifiers = null;

  @SerializedName("address")
  private Address address = null;

  @SerializedName("contactPoint")
  private ContactPoint contactPoint = null;

  public OrgMigration organisationId(String organisationId) {
    this.organisationId = organisationId;
    return this;
  }

   /**
   * id 19700101T000000Z
   * @return organisationId
  **/
  @Schema(example = "19700101T000000Z", description = "id 19700101T000000Z")
  public String getOrganisationId() {
    return organisationId;
  }

  public void setOrganisationId(String organisationId) {
    this.organisationId = organisationId;
  }

  public OrgMigration identifier(Identifier identifier) {
    this.identifier = identifier;
    return this;
  }

   /**
   * Get identifier
   * @return identifier
  **/
  @Schema(description = "")
  public Identifier getIdentifier() {
    return identifier;
  }

  public void setIdentifier(Identifier identifier) {
    this.identifier = identifier;
  }

  public OrgMigration additionalIdentifiers(List<Identifier> additionalIdentifiers) {
    this.additionalIdentifiers = additionalIdentifiers;
    return this;
  }

  public OrgMigration addAdditionalIdentifiersItem(Identifier additionalIdentifiersItem) {
    if (this.additionalIdentifiers == null) {
      this.additionalIdentifiers = new ArrayList<Identifier>();
    }
    this.additionalIdentifiers.add(additionalIdentifiersItem);
    return this;
  }

   /**
   * Get additionalIdentifiers
   * @return additionalIdentifiers
  **/
  @Schema(description = "")
  public List<Identifier> getAdditionalIdentifiers() {
    return additionalIdentifiers;
  }

  public void setAdditionalIdentifiers(List<Identifier> additionalIdentifiers) {
    this.additionalIdentifiers = additionalIdentifiers;
  }

  public OrgMigration address(Address address) {
    this.address = address;
    return this;
  }

   /**
   * Get address
   * @return address
  **/
  @Schema(description = "")
  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public OrgMigration contactPoint(ContactPoint contactPoint) {
    this.contactPoint = contactPoint;
    return this;
  }

   /**
   * Get contactPoint
   * @return contactPoint
  **/
  @Schema(description = "")
  public ContactPoint getContactPoint() {
    return contactPoint;
  }

  public void setContactPoint(ContactPoint contactPoint) {
    this.contactPoint = contactPoint;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrgMigration orgMigration = (OrgMigration) o;
    return Objects.equals(this.organisationId, orgMigration.organisationId) &&
        Objects.equals(this.identifier, orgMigration.identifier) &&
        Objects.equals(this.additionalIdentifiers, orgMigration.additionalIdentifiers) &&
        Objects.equals(this.address, orgMigration.address) &&
        Objects.equals(this.contactPoint, orgMigration.contactPoint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(organisationId, identifier, additionalIdentifiers, address, contactPoint);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrgMigration {\n");
    
    sb.append("    organisationId: ").append(toIndentedString(organisationId)).append("\n");
    sb.append("    identifier: ").append(toIndentedString(identifier)).append("\n");
    sb.append("    additionalIdentifiers: ").append(toIndentedString(additionalIdentifiers)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    contactPoint: ").append(toIndentedString(contactPoint)).append("\n");
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
