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
import uk.gov.ccs.swagger.cii.model.Identifier;
/**
 * IdentifierPlusId
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-08-26T12:47:55.811291+01:00[Europe/London]")
public class IdentifierPlusId {
  @SerializedName("organisation-id")
  private String organisationId = null;

  @SerializedName("Identifier")
  private Identifier identifier = null;

  public IdentifierPlusId organisationId(String organisationId) {
    this.organisationId = organisationId;
    return this;
  }

   /**
   * ccs org id
   * @return organisationId
  **/
  @Schema(example = "19700101T000000Z", required = true, description = "ccs org id")
  public String getOrganisationId() {
    return organisationId;
  }

  public void setOrganisationId(String organisationId) {
    this.organisationId = organisationId;
  }

  public IdentifierPlusId identifier(Identifier identifier) {
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IdentifierPlusId identifierPlusId = (IdentifierPlusId) o;
    return Objects.equals(this.organisationId, identifierPlusId.organisationId) &&
        Objects.equals(this.identifier, identifierPlusId.identifier);
  }

  @Override
  public int hashCode() {
    return Objects.hash(organisationId, identifier);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IdentifierPlusId {\n");
    
    sb.append("    organisationId: ").append(toIndentedString(organisationId)).append("\n");
    sb.append("    identifier: ").append(toIndentedString(identifier)).append("\n");
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
