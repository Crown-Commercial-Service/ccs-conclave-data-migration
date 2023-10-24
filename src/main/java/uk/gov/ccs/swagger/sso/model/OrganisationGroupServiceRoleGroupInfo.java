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
import java.util.ArrayList;
import java.util.List;
import uk.gov.ccs.swagger.sso.model.GroupServiceRoleGroup;
/**
 * OrganisationGroupServiceRoleGroupInfo
 */


public class OrganisationGroupServiceRoleGroupInfo {
  @SerializedName("groupName")
  private String groupName = null;

  @SerializedName("groupType")
  private Integer groupType = null;

  @SerializedName("groupId")
  private Integer groupId = null;

  @SerializedName("createdDate")
  private String createdDate = null;

  @SerializedName("serviceRoleGroups")
  private List<GroupServiceRoleGroup> serviceRoleGroups = null;

  public OrganisationGroupServiceRoleGroupInfo groupName(String groupName) {
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

  public OrganisationGroupServiceRoleGroupInfo groupType(Integer groupType) {
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

  public OrganisationGroupServiceRoleGroupInfo groupId(Integer groupId) {
    this.groupId = groupId;
    return this;
  }

   /**
   * Get groupId
   * @return groupId
  **/
  @Schema(description = "")
  public Integer getGroupId() {
    return groupId;
  }

  public void setGroupId(Integer groupId) {
    this.groupId = groupId;
  }

  public OrganisationGroupServiceRoleGroupInfo createdDate(String createdDate) {
    this.createdDate = createdDate;
    return this;
  }

   /**
   * Get createdDate
   * @return createdDate
  **/
  @Schema(description = "")
  public String getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(String createdDate) {
    this.createdDate = createdDate;
  }

  public OrganisationGroupServiceRoleGroupInfo serviceRoleGroups(List<GroupServiceRoleGroup> serviceRoleGroups) {
    this.serviceRoleGroups = serviceRoleGroups;
    return this;
  }

  public OrganisationGroupServiceRoleGroupInfo addServiceRoleGroupsItem(GroupServiceRoleGroup serviceRoleGroupsItem) {
    if (this.serviceRoleGroups == null) {
      this.serviceRoleGroups = new ArrayList<GroupServiceRoleGroup>();
    }
    this.serviceRoleGroups.add(serviceRoleGroupsItem);
    return this;
  }

   /**
   * Get serviceRoleGroups
   * @return serviceRoleGroups
  **/
  @Schema(description = "")
  public List<GroupServiceRoleGroup> getServiceRoleGroups() {
    return serviceRoleGroups;
  }

  public void setServiceRoleGroups(List<GroupServiceRoleGroup> serviceRoleGroups) {
    this.serviceRoleGroups = serviceRoleGroups;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrganisationGroupServiceRoleGroupInfo organisationGroupServiceRoleGroupInfo = (OrganisationGroupServiceRoleGroupInfo) o;
    return Objects.equals(this.groupName, organisationGroupServiceRoleGroupInfo.groupName) &&
        Objects.equals(this.groupType, organisationGroupServiceRoleGroupInfo.groupType) &&
        Objects.equals(this.groupId, organisationGroupServiceRoleGroupInfo.groupId) &&
        Objects.equals(this.createdDate, organisationGroupServiceRoleGroupInfo.createdDate) &&
        Objects.equals(this.serviceRoleGroups, organisationGroupServiceRoleGroupInfo.serviceRoleGroups);
  }

  @Override
  public int hashCode() {
    return Objects.hash(groupName, groupType, groupId, createdDate, serviceRoleGroups);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrganisationGroupServiceRoleGroupInfo {\n");
    
    sb.append("    groupName: ").append(toIndentedString(groupName)).append("\n");
    sb.append("    groupType: ").append(toIndentedString(groupType)).append("\n");
    sb.append("    groupId: ").append(toIndentedString(groupId)).append("\n");
    sb.append("    createdDate: ").append(toIndentedString(createdDate)).append("\n");
    sb.append("    serviceRoleGroups: ").append(toIndentedString(serviceRoleGroups)).append("\n");
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