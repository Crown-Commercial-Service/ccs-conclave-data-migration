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
import uk.gov.ccs.swagger.sso.model.OrganisationGroupRolePatchInfo;
import uk.gov.ccs.swagger.sso.model.OrganisationGroupUserPatchInfo;
/**
 * OrganisationGroupRequestInfo
 */


public class OrganisationGroupRequestInfo {
  @SerializedName("groupName")
  private String groupName = null;

  @SerializedName("groupType")
  private Integer groupType = null;

  @SerializedName("roleInfo")
  private OrganisationGroupRolePatchInfo roleInfo = null;

  @SerializedName("userInfo")
  private OrganisationGroupUserPatchInfo userInfo = null;

  public OrganisationGroupRequestInfo groupName(String groupName) {
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

  public OrganisationGroupRequestInfo groupType(Integer groupType) {
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

  public OrganisationGroupRequestInfo roleInfo(OrganisationGroupRolePatchInfo roleInfo) {
    this.roleInfo = roleInfo;
    return this;
  }

   /**
   * Get roleInfo
   * @return roleInfo
  **/
  @Schema(description = "")
  public OrganisationGroupRolePatchInfo getRoleInfo() {
    return roleInfo;
  }

  public void setRoleInfo(OrganisationGroupRolePatchInfo roleInfo) {
    this.roleInfo = roleInfo;
  }

  public OrganisationGroupRequestInfo userInfo(OrganisationGroupUserPatchInfo userInfo) {
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
    OrganisationGroupRequestInfo organisationGroupRequestInfo = (OrganisationGroupRequestInfo) o;
    return Objects.equals(this.groupName, organisationGroupRequestInfo.groupName) &&
        Objects.equals(this.groupType, organisationGroupRequestInfo.groupType) &&
        Objects.equals(this.roleInfo, organisationGroupRequestInfo.roleInfo) &&
        Objects.equals(this.userInfo, organisationGroupRequestInfo.userInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(groupName, groupType, roleInfo, userInfo);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrganisationGroupRequestInfo {\n");
    
    sb.append("    groupName: ").append(toIndentedString(groupName)).append("\n");
    sb.append("    groupType: ").append(toIndentedString(groupType)).append("\n");
    sb.append("    roleInfo: ").append(toIndentedString(roleInfo)).append("\n");
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
