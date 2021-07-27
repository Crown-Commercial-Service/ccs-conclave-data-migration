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
import uk.gov.ccs.swagger.cii.model.Identifier1;
import uk.gov.ccs.swagger.cii.model.OrganizationScheme1;
/**
 * A unique identifier for a party (organization).
 */
@Schema(description = "A unique identifier for a party (organization).")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-07-27T12:42:34.957888+01:00[Europe/London]")
public class Identifier extends Identifier1 {
  @SerializedName("scheme")
  private OrganizationScheme1 identifierScheme = null;

  @SerializedName("id")
  private Object identifierId = null;

  public Identifier identifierScheme(OrganizationScheme1 identifierScheme) {
    this.identifierScheme = identifierScheme;
    return this;
  }

   /**
   * Get identifierScheme
   * @return identifierScheme
  **/
  @Schema(description = "")
  public OrganizationScheme1 getIdentifierScheme() {
    return identifierScheme;
  }

  public void getIdentifierScheme(OrganizationScheme1 identifierScheme) {
    this.identifierScheme = identifierScheme;
  }

  public Identifier identifierId(Object identifierId) {
    this.identifierId = identifierId;
    return this;
  }

   /**
   * Get identifierId
   * @return identifierId
  **/
  @Schema(example = "abc1234", description = "")
  public Object getIdentifierId() {
    return identifierId;
  }

  public void getIdentifierId(Object identifierId) {
    this.identifierId = identifierId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Identifier identifier = (Identifier) o;
    return Objects.equals(this.identifierScheme, identifier.identifierScheme) &&
        Objects.equals(this.identifierId, identifier.identifierId) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identifierScheme, identifierId, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Identifier {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    identifierScheme: ").append(toIndentedString(identifierScheme)).append("\n");
    sb.append("    identifierId: ").append(toIndentedString(identifierId)).append("\n");
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
