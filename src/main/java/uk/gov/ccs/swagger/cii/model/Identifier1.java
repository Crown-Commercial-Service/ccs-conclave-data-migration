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
import uk.gov.ccs.swagger.cii.model.OrganizationScheme;
/**
 * A unique identifier for a party (organization).
 */
@Schema(description = "A unique identifier for a party (organization).")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-07-27T12:42:34.957888+01:00[Europe/London]")
public class Identifier1 {
  @SerializedName("scheme")
  private OrganizationScheme scheme = null;

  @SerializedName("id")
  private OneOfIdentifier1Id id = null;

  @SerializedName("legalName")
  private String legalName = null;

  @SerializedName("uri")
  private String uri = null;

  public Identifier1 scheme(OrganizationScheme scheme) {
    this.scheme = scheme;
    return this;
  }

   /**
   * Get scheme
   * @return scheme
  **/
  @Schema(description = "")
  public OrganizationScheme getScheme() {
    return scheme;
  }

  public void setScheme(OrganizationScheme scheme) {
    this.scheme = scheme;
  }

  public Identifier1 id(OneOfIdentifier1Id id) {
    this.id = id;
    return this;
  }

   /**
   * The identifier of the organization in the selected scheme.
   * @return id
  **/
  @Schema(example = "abc12345", description = "The identifier of the organization in the selected scheme.")
  public OneOfIdentifier1Id getId() {
    return id;
  }

  public void setId(OneOfIdentifier1Id id) {
    this.id = id;
  }

  public Identifier1 legalName(String legalName) {
    this.legalName = legalName;
    return this;
  }

   /**
   * The legally registered name of the organization.
   * @return legalName
  **/
  @Schema(description = "The legally registered name of the organization.")
  public String getLegalName() {
    return legalName;
  }

  public void setLegalName(String legalName) {
    this.legalName = legalName;
  }

  public Identifier1 uri(String uri) {
    this.uri = uri;
    return this;
  }

   /**
   * A URI to identify the organization, such as those provided by [Open Corporates](http://www.opencorporates.com) or some other relevant URI provider. This is not for listing the website of the organization: that can be done through the URL field of the Organization contact point.
   * @return uri
  **/
  @Schema(description = "A URI to identify the organization, such as those provided by [Open Corporates](http://www.opencorporates.com) or some other relevant URI provider. This is not for listing the website of the organization: that can be done through the URL field of the Organization contact point.")
  public String getUri() {
    return uri;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Identifier1 identifier1 = (Identifier1) o;
    return Objects.equals(this.scheme, identifier1.scheme) &&
        Objects.equals(this.id, identifier1.id) &&
        Objects.equals(this.legalName, identifier1.legalName) &&
        Objects.equals(this.uri, identifier1.uri);
  }

  @Override
  public int hashCode() {
    return Objects.hash(scheme, id, legalName, uri);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Identifier1 {\n");
    
    sb.append("    scheme: ").append(toIndentedString(scheme)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    legalName: ").append(toIndentedString(legalName)).append("\n");
    sb.append("    uri: ").append(toIndentedString(uri)).append("\n");
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