/*
 * CcsSso.WrapperApi
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: v2
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
 * RolePermissionInfo
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-08-27T09:35:55.156031+01:00[Europe/London]")
public class RolePermissionInfo {
  @SerializedName("roleId")
  private Integer roleId = null;

  @SerializedName("roleName")
  private String roleName = null;

  @SerializedName("roleKey")
  private String roleKey = null;

  @SerializedName("serviceClientId")
  private String serviceClientId = null;

  public RolePermissionInfo roleId(Integer roleId) {
    this.roleId = roleId;
    return this;
  }

   /**
   * Get roleId
   * @return roleId
  **/
  @Schema(description = "")
  public Integer getRoleId() {
    return roleId;
  }

  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }

  public RolePermissionInfo roleName(String roleName) {
    this.roleName = roleName;
    return this;
  }

   /**
   * Get roleName
   * @return roleName
  **/
  @Schema(description = "")
  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public RolePermissionInfo roleKey(String roleKey) {
    this.roleKey = roleKey;
    return this;
  }

   /**
   * Get roleKey
   * @return roleKey
  **/
  @Schema(description = "")
  public String getRoleKey() {
    return roleKey;
  }

  public void setRoleKey(String roleKey) {
    this.roleKey = roleKey;
  }

  public RolePermissionInfo serviceClientId(String serviceClientId) {
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RolePermissionInfo rolePermissionInfo = (RolePermissionInfo) o;
    return Objects.equals(this.roleId, rolePermissionInfo.roleId) &&
        Objects.equals(this.roleName, rolePermissionInfo.roleName) &&
        Objects.equals(this.roleKey, rolePermissionInfo.roleKey) &&
        Objects.equals(this.serviceClientId, rolePermissionInfo.serviceClientId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(roleId, roleName, roleKey, serviceClientId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RolePermissionInfo {\n");
    
    sb.append("    roleId: ").append(toIndentedString(roleId)).append("\n");
    sb.append("    roleName: ").append(toIndentedString(roleName)).append("\n");
    sb.append("    roleKey: ").append(toIndentedString(roleKey)).append("\n");
    sb.append("    serviceClientId: ").append(toIndentedString(serviceClientId)).append("\n");
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
