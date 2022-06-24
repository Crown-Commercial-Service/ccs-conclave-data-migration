/*
 * CcsSso.WrapperApi
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
 * GroupAccessRole
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-12-07T09:38:21.309374Z[Europe/London]")
public class GroupAccessRole {
  @SerializedName("groupId")
  private Integer groupId = null;

  @SerializedName("accessRole")
  private String accessRole = null;

  @SerializedName("accessRoleName")
  private String accessRoleName = null;

  @SerializedName("group")
  private String group = null;

  @SerializedName("serviceClientId")
  private String serviceClientId = null;

  @SerializedName("serviceClientName")
  private String serviceClientName = null;

  public GroupAccessRole groupId(Integer groupId) {
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

  public GroupAccessRole accessRole(String accessRole) {
    this.accessRole = accessRole;
    return this;
  }

   /**
   * Get accessRole
   * @return accessRole
  **/
  @Schema(description = "")
  public String getAccessRole() {
    return accessRole;
  }

  public void setAccessRole(String accessRole) {
    this.accessRole = accessRole;
  }

  public GroupAccessRole accessRoleName(String accessRoleName) {
    this.accessRoleName = accessRoleName;
    return this;
  }

   /**
   * Get accessRoleName
   * @return accessRoleName
  **/
  @Schema(description = "")
  public String getAccessRoleName() {
    return accessRoleName;
  }

  public void setAccessRoleName(String accessRoleName) {
    this.accessRoleName = accessRoleName;
  }

  public GroupAccessRole group(String group) {
    this.group = group;
    return this;
  }

   /**
   * Get group
   * @return group
  **/
  @Schema(description = "")
  public String getGroup() {
    return group;
  }

  public void setGroup(String group) {
    this.group = group;
  }

  public GroupAccessRole serviceClientId(String serviceClientId) {
    this.serviceClientId = serviceClientId;
    return this;
  }

   /**
   * Get serviceClientId
   * @return serviceClientId
  **/
  @Schema(description = "")
  public String getServiceClientId() {
    return serviceClientId;
  }

  public void setServiceClientId(String serviceClientId) {
    this.serviceClientId = serviceClientId;
  }

  public GroupAccessRole serviceClientName(String serviceClientName) {
    this.serviceClientName = serviceClientName;
    return this;
  }

   /**
   * Get serviceClientName
   * @return serviceClientName
  **/
  @Schema(description = "")
  public String getServiceClientName() {
    return serviceClientName;
  }

  public void setServiceClientName(String serviceClientName) {
    this.serviceClientName = serviceClientName;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GroupAccessRole groupAccessRole = (GroupAccessRole) o;
    return Objects.equals(this.groupId, groupAccessRole.groupId) &&
        Objects.equals(this.accessRole, groupAccessRole.accessRole) &&
        Objects.equals(this.accessRoleName, groupAccessRole.accessRoleName) &&
        Objects.equals(this.group, groupAccessRole.group) &&
        Objects.equals(this.serviceClientId, groupAccessRole.serviceClientId) &&
        Objects.equals(this.serviceClientName, groupAccessRole.serviceClientName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(groupId, accessRole, accessRoleName, group, serviceClientId, serviceClientName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GroupAccessRole {\n");
    
    sb.append("    groupId: ").append(toIndentedString(groupId)).append("\n");
    sb.append("    accessRole: ").append(toIndentedString(accessRole)).append("\n");
    sb.append("    accessRoleName: ").append(toIndentedString(accessRoleName)).append("\n");
    sb.append("    group: ").append(toIndentedString(group)).append("\n");
    sb.append("    serviceClientId: ").append(toIndentedString(serviceClientId)).append("\n");
    sb.append("    serviceClientName: ").append(toIndentedString(serviceClientName)).append("\n");
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
