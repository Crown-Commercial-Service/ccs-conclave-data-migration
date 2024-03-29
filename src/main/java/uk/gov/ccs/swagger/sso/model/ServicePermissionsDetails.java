/*
 * CcsSso.ConfigurationApi
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
/**
 * ServicePermissionsDetails
 */


public class ServicePermissionsDetails {
  @SerializedName("ccsAccessRoleId")
  private Integer ccsAccessRoleId = null;

  @SerializedName("servicePermissionsNameList")
  private List<String> servicePermissionsNameList = null;

  public ServicePermissionsDetails ccsAccessRoleId(Integer ccsAccessRoleId) {
    this.ccsAccessRoleId = ccsAccessRoleId;
    return this;
  }

   /**
   * Get ccsAccessRoleId
   * @return ccsAccessRoleId
  **/
  @Schema(description = "")
  public Integer getCcsAccessRoleId() {
    return ccsAccessRoleId;
  }

  public void setCcsAccessRoleId(Integer ccsAccessRoleId) {
    this.ccsAccessRoleId = ccsAccessRoleId;
  }

  public ServicePermissionsDetails servicePermissionsNameList(List<String> servicePermissionsNameList) {
    this.servicePermissionsNameList = servicePermissionsNameList;
    return this;
  }

  public ServicePermissionsDetails addServicePermissionsNameListItem(String servicePermissionsNameListItem) {
    if (this.servicePermissionsNameList == null) {
      this.servicePermissionsNameList = new ArrayList<String>();
    }
    this.servicePermissionsNameList.add(servicePermissionsNameListItem);
    return this;
  }

   /**
   * Get servicePermissionsNameList
   * @return servicePermissionsNameList
  **/
  @Schema(description = "")
  public List<String> getServicePermissionsNameList() {
    return servicePermissionsNameList;
  }

  public void setServicePermissionsNameList(List<String> servicePermissionsNameList) {
    this.servicePermissionsNameList = servicePermissionsNameList;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServicePermissionsDetails servicePermissionsDetails = (ServicePermissionsDetails) o;
    return Objects.equals(this.ccsAccessRoleId, servicePermissionsDetails.ccsAccessRoleId) &&
        Objects.equals(this.servicePermissionsNameList, servicePermissionsDetails.servicePermissionsNameList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ccsAccessRoleId, servicePermissionsNameList);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServicePermissionsDetails {\n");
    
    sb.append("    ccsAccessRoleId: ").append(toIndentedString(ccsAccessRoleId)).append("\n");
    sb.append("    servicePermissionsNameList: ").append(toIndentedString(servicePermissionsNameList)).append("\n");
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
