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
/**
 * OrgRegistryAddressDetails
 */


public class OrgRegistryAddressDetails {
  @SerializedName("streetAddress")
  private String streetAddress = null;

  @SerializedName("locality")
  private String locality = null;

  @SerializedName("region")
  private String region = null;

  @SerializedName("postalCode")
  private String postalCode = null;

  @SerializedName("countryCode")
  private String countryCode = null;

  @SerializedName("countryName")
  private String countryName = null;

  public OrgRegistryAddressDetails streetAddress(String streetAddress) {
    this.streetAddress = streetAddress;
    return this;
  }

   /**
   * Get streetAddress
   * @return streetAddress
  **/
  @Schema(description = "")
  public String getStreetAddress() {
    return streetAddress;
  }

  public void setStreetAddress(String streetAddress) {
    this.streetAddress = streetAddress;
  }

  public OrgRegistryAddressDetails locality(String locality) {
    this.locality = locality;
    return this;
  }

   /**
   * Get locality
   * @return locality
  **/
  @Schema(description = "")
  public String getLocality() {
    return locality;
  }

  public void setLocality(String locality) {
    this.locality = locality;
  }

  public OrgRegistryAddressDetails region(String region) {
    this.region = region;
    return this;
  }

   /**
   * Get region
   * @return region
  **/
  @Schema(description = "")
  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public OrgRegistryAddressDetails postalCode(String postalCode) {
    this.postalCode = postalCode;
    return this;
  }

   /**
   * Get postalCode
   * @return postalCode
  **/
  @Schema(description = "")
  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public OrgRegistryAddressDetails countryCode(String countryCode) {
    this.countryCode = countryCode;
    return this;
  }

   /**
   * Get countryCode
   * @return countryCode
  **/
  @Schema(description = "")
  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public OrgRegistryAddressDetails countryName(String countryName) {
    this.countryName = countryName;
    return this;
  }

   /**
   * Get countryName
   * @return countryName
  **/
  @Schema(description = "")
  public String getCountryName() {
    return countryName;
  }

  public void setCountryName(String countryName) {
    this.countryName = countryName;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrgRegistryAddressDetails orgRegistryAddressDetails = (OrgRegistryAddressDetails) o;
    return Objects.equals(this.streetAddress, orgRegistryAddressDetails.streetAddress) &&
        Objects.equals(this.locality, orgRegistryAddressDetails.locality) &&
        Objects.equals(this.region, orgRegistryAddressDetails.region) &&
        Objects.equals(this.postalCode, orgRegistryAddressDetails.postalCode) &&
        Objects.equals(this.countryCode, orgRegistryAddressDetails.countryCode) &&
        Objects.equals(this.countryName, orgRegistryAddressDetails.countryName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(streetAddress, locality, region, postalCode, countryCode, countryName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrgRegistryAddressDetails {\n");
    
    sb.append("    streetAddress: ").append(toIndentedString(streetAddress)).append("\n");
    sb.append("    locality: ").append(toIndentedString(locality)).append("\n");
    sb.append("    region: ").append(toIndentedString(region)).append("\n");
    sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
    sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
    sb.append("    countryName: ").append(toIndentedString(countryName)).append("\n");
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
