/*
 * CcsSso.OrganisationApi
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
import uk.gov.ccs.swagger.sso.model.OrganisationGroupUserPatchInfo;
import uk.gov.ccs.swagger.sso.model.OrganisationServiceRoleGroupPatchInfo;
/**
 * OrganisationServiceRoleGroupRequestInfo
 */


public class OrganisationServiceRoleGroupRequestInfo {
  @SerializedName("groupName")
  private String groupName = null;

  @SerializedName("groupType")
  private Integer groupType = null;

  @SerializedName("serviceRoleGroupInfo")
  private OrganisationServiceRoleGroupPatchInfo serviceRoleGroupInfo = null;

  @SerializedName("userInfo")
  private OrganisationGroupUserPatchInfo userInfo = null;

  public OrganisationServiceRoleGroupRequestInfo groupName(String groupName) {
    this.groupName = groupName;
    return this;
  }

   /**
   * Get groupName
   * @return groupName
  **/
  @Schema(description = "")
  public String getGroupName() {
    return groupName;
  }

  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

  public OrganisationServiceRoleGroupRequestInfo groupType(Integer groupType) {
    this.groupType = groupType;
    return this;
  }

   /**
   * Get groupType
   * @return groupType
  **/
  @Schema(description = "")
  public Integer getGroupType() {
    return groupType;
  }

  public void setGroupType(Integer groupType) {
    this.groupType = groupType;
  }

  public OrganisationServiceRoleGroupRequestInfo serviceRoleGroupInfo(OrganisationServiceRoleGroupPatchInfo serviceRoleGroupInfo) {
    this.serviceRoleGroupInfo = serviceRoleGroupInfo;
    return this;
  }

   /**
   * Get serviceRoleGroupInfo
   * @return serviceRoleGroupInfo
  **/
  @Schema(description = "")
  public OrganisationServiceRoleGroupPatchInfo getServiceRoleGroupInfo() {
    return serviceRoleGroupInfo;
  }

  public void setServiceRoleGroupInfo(OrganisationServiceRoleGroupPatchInfo serviceRoleGroupInfo) {
    this.serviceRoleGroupInfo = serviceRoleGroupInfo;
  }

  public OrganisationServiceRoleGroupRequestInfo userInfo(OrganisationGroupUserPatchInfo userInfo) {
    this.userInfo = userInfo;
    return this;
  }

   /**
   * Get userInfo
   * @return userInfo
  **/
  @Schema(description = "")
  public OrganisationGroupUserPatchInfo getUserInfo() {
    return userInfo;
  }

  public void setUserInfo(OrganisationGroupUserPatchInfo userInfo) {
    this.userInfo = userInfo;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrganisationServiceRoleGroupRequestInfo organisationServiceRoleGroupRequestInfo = (OrganisationServiceRoleGroupRequestInfo) o;
    return Objects.equals(this.groupName, organisationServiceRoleGroupRequestInfo.groupName) &&
        Objects.equals(this.groupType, organisationServiceRoleGroupRequestInfo.groupType) &&
        Objects.equals(this.serviceRoleGroupInfo, organisationServiceRoleGroupRequestInfo.serviceRoleGroupInfo) &&
        Objects.equals(this.userInfo, organisationServiceRoleGroupRequestInfo.userInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(groupName, groupType, serviceRoleGroupInfo, userInfo);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrganisationServiceRoleGroupRequestInfo {\n");
    
    sb.append("    groupName: ").append(toIndentedString(groupName)).append("\n");
    sb.append("    groupType: ").append(toIndentedString(groupType)).append("\n");
    sb.append("    serviceRoleGroupInfo: ").append(toIndentedString(serviceRoleGroupInfo)).append("\n");
    sb.append("    userInfo: ").append(toIndentedString(userInfo)).append("\n");
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