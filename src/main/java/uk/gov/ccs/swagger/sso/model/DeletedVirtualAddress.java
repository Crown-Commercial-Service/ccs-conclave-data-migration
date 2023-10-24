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
 * DeletedVirtualAddress
 */


public class DeletedVirtualAddress {
  @SerializedName("virtualAddressId")
  private Integer virtualAddressId = null;

  @SerializedName("virtualAddressTypeName")
  private String virtualAddressTypeName = null;

  public DeletedVirtualAddress virtualAddressId(Integer virtualAddressId) {
    this.virtualAddressId = virtualAddressId;
    return this;
  }

   /**
   * Get virtualAddressId
   * @return virtualAddressId
  **/
  @Schema(description = "")
  public Integer getVirtualAddressId() {
    return virtualAddressId;
  }

  public void setVirtualAddressId(Integer virtualAddressId) {
    this.virtualAddressId = virtualAddressId;
  }

  public DeletedVirtualAddress virtualAddressTypeName(String virtualAddressTypeName) {
    this.virtualAddressTypeName = virtualAddressTypeName;
    return this;
  }

   /**
   * Get virtualAddressTypeName
   * @return virtualAddressTypeName
  **/
  @Schema(description = "")
  public String getVirtualAddressTypeName() {
    return virtualAddressTypeName;
  }

  public void setVirtualAddressTypeName(String virtualAddressTypeName) {
    this.virtualAddressTypeName = virtualAddressTypeName;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeletedVirtualAddress deletedVirtualAddress = (DeletedVirtualAddress) o;
    return Objects.equals(this.virtualAddressId, deletedVirtualAddress.virtualAddressId) &&
        Objects.equals(this.virtualAddressTypeName, deletedVirtualAddress.virtualAddressTypeName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(virtualAddressId, virtualAddressTypeName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeletedVirtualAddress {\n");
    
    sb.append("    virtualAddressId: ").append(toIndentedString(virtualAddressId)).append("\n");
    sb.append("    virtualAddressTypeName: ").append(toIndentedString(virtualAddressTypeName)).append("\n");
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