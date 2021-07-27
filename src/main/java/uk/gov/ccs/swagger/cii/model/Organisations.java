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
import uk.gov.ccs.swagger.cii.model.Roles;
/**
 * Organisations
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-07-27T12:42:34.957888+01:00[Europe/London]")
public class Organisations {
  @SerializedName("identifier")
  private List<Identifier> identifier = new ArrayList<Identifier>();

  @SerializedName("additionalIdentifiers")
  private List<Identifier> additionalIdentifiers = new ArrayList<Identifier>();

  @SerializedName("address")
  private Address address = null;

  @SerializedName("contactPoint")
  private ContactPoint contactPoint = null;

  @SerializedName("roles")
  private List<Roles> roles = null;

  public Organisations identifier(List<Identifier> identifier) {
    this.identifier = identifier;
    return this;
  }

  public Organisations addIdentifierItem(Identifier identifierItem) {
    this.identifier.add(identifierItem);
    return this;
  }

   /**
   * Get identifier
   * @return identifier
  **/
  @Schema(required = true, description = "")
  public List<Identifier> getIdentifier() {
    return identifier;
  }

  public void setIdentifier(List<Identifier> identifier) {
    this.identifier = identifier;
  }

  public Organisations additionalIdentifiers(List<Identifier> additionalIdentifiers) {
    this.additionalIdentifiers = additionalIdentifiers;
    return this;
  }

  public Organisations addAdditionalIdentifiersItem(Identifier additionalIdentifiersItem) {
    this.additionalIdentifiers.add(additionalIdentifiersItem);
    return this;
  }

   /**
   * Get additionalIdentifiers
   * @return additionalIdentifiers
  **/
  @Schema(required = true, description = "")
  public List<Identifier> getAdditionalIdentifiers() {
    return additionalIdentifiers;
  }

  public void setAdditionalIdentifiers(List<Identifier> additionalIdentifiers) {
    this.additionalIdentifiers = additionalIdentifiers;
  }

  public Organisations address(Address address) {
    this.address = address;
    return this;
  }

   /**
   * Get address
   * @return address
  **/
  @Schema(required = true, description = "")
  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public Organisations contactPoint(ContactPoint contactPoint) {
    this.contactPoint = contactPoint;
    return this;
  }

   /**
   * Get contactPoint
   * @return contactPoint
  **/
  @Schema(required = true, description = "")
  public ContactPoint getContactPoint() {
    return contactPoint;
  }

  public void setContactPoint(ContactPoint contactPoint) {
    this.contactPoint = contactPoint;
  }

  public Organisations roles(List<Roles> roles) {
    this.roles = roles;
    return this;
  }

  public Organisations addRolesItem(Roles rolesItem) {
    if (this.roles == null) {
      this.roles = new ArrayList<Roles>();
    }
    this.roles.add(rolesItem);
    return this;
  }

   /**
   * Get roles
   * @return roles
  **/
  @Schema(description = "")
  public List<Roles> getRoles() {
    return roles;
  }

  public void setRoles(List<Roles> roles) {
    this.roles = roles;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Organisations organisations = (Organisations) o;
    return Objects.equals(this.identifier, organisations.identifier) &&
        Objects.equals(this.additionalIdentifiers, organisations.additionalIdentifiers) &&
        Objects.equals(this.address, organisations.address) &&
        Objects.equals(this.contactPoint, organisations.contactPoint) &&
        Objects.equals(this.roles, organisations.roles);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identifier, additionalIdentifiers, address, contactPoint, roles);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Organisations {\n");
    
    sb.append("    identifier: ").append(toIndentedString(identifier)).append("\n");
    sb.append("    additionalIdentifiers: ").append(toIndentedString(additionalIdentifiers)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    contactPoint: ").append(toIndentedString(contactPoint)).append("\n");
    sb.append("    roles: ").append(toIndentedString(roles)).append("\n");
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
