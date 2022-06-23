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

public class Identifier {
  @SerializedName("scheme")
  private OrganizationScheme scheme = null;

  @SerializedName("id")
  private String id = null;

  @SerializedName("legalName")
  private String legalName = null;

  @SerializedName("uri")
  private String uri = null;

  public Identifier scheme(OrganizationScheme scheme) {
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

  public Identifier id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The identifier of the organization in the selected scheme.
   * @return id
  **/
  @Schema(example = "abc12345", description = "The identifier of the organization in the selected scheme.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Identifier legalName(String legalName) {
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

  public Identifier uri(String uri) {
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
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Identifier identifier = (Identifier) o;
    return Objects.equals(this.scheme, identifier.scheme) &&
        Objects.equals(this.id, identifier.id) &&
        Objects.equals(this.legalName, identifier.legalName) &&
        Objects.equals(this.uri, identifier.uri);
  }

  @Override
  public int hashCode() {
    return Objects.hash(scheme, id, legalName, uri);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Identifier {\n");
    
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
