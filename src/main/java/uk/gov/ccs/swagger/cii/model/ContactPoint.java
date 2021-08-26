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
/**
 * ContactPoint
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-08-26T12:47:55.811291+01:00[Europe/London]")
public class ContactPoint {
  @SerializedName("name")
  private String name = null;

  @SerializedName("email")
  private String email = null;

  @SerializedName("telephone")
  private String telephone = null;

  @SerializedName("faxNumber")
  private String faxNumber = null;

  @SerializedName("uri")
  private String uri = null;

  public ContactPoint name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of the contact person, department, or contact point, for correspondence relating to this contracting process
   * @return name
  **/
  @Schema(example = "Bob Smith", required = true, description = "The name of the contact person, department, or contact point, for correspondence relating to this contracting process")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ContactPoint email(String email) {
    this.email = email;
    return this;
  }

   /**
   * The e-mail address of the contact point/person.
   * @return email
  **/
  @Schema(example = "bob.smith@company.com", required = true, description = "The e-mail address of the contact point/person.")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public ContactPoint telephone(String telephone) {
    this.telephone = telephone;
    return this;
  }

   /**
   * The telephone number of the contact point/person. This should include the international dialling code.
   * @return telephone
  **/
  @Schema(example = "020 7777 7777", required = true, description = "The telephone number of the contact point/person. This should include the international dialling code.")
  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public ContactPoint faxNumber(String faxNumber) {
    this.faxNumber = faxNumber;
    return this;
  }

   /**
   * The fax number of the contact point/person. This should include the international dialling code.
   * @return faxNumber
  **/
  @Schema(example = "020 7777 7777", required = true, description = "The fax number of the contact point/person. This should include the international dialling code.")
  public String getFaxNumber() {
    return faxNumber;
  }

  public void setFaxNumber(String faxNumber) {
    this.faxNumber = faxNumber;
  }

  public ContactPoint uri(String uri) {
    this.uri = uri;
    return this;
  }

   /**
   * A web address for the contact point/person.
   * @return uri
  **/
  @Schema(example = "www.linkedin.com/in/.......", required = true, description = "A web address for the contact point/person.")
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
    ContactPoint contactPoint = (ContactPoint) o;
    return Objects.equals(this.name, contactPoint.name) &&
        Objects.equals(this.email, contactPoint.email) &&
        Objects.equals(this.telephone, contactPoint.telephone) &&
        Objects.equals(this.faxNumber, contactPoint.faxNumber) &&
        Objects.equals(this.uri, contactPoint.uri);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, email, telephone, faxNumber, uri);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContactPoint {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    telephone: ").append(toIndentedString(telephone)).append("\n");
    sb.append("    faxNumber: ").append(toIndentedString(faxNumber)).append("\n");
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
