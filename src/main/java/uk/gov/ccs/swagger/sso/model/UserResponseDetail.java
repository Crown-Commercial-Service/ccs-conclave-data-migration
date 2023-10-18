/*
 * CcsSso.UserApi
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
import uk.gov.ccs.swagger.sso.model.GroupAccessRole;
import uk.gov.ccs.swagger.sso.model.RolePermissionInfo;
import uk.gov.ccs.swagger.sso.model.UserDelegationDetails;
import uk.gov.ccs.swagger.sso.model.UserIdentityProviderInfo;
/**
 * UserResponseDetail
 */


public class UserResponseDetail {
  @SerializedName("id")
  private Integer id = null;

  @SerializedName("canChangePassword")
  private Boolean canChangePassword = null;

  @SerializedName("identityProviders")
  private List<UserIdentityProviderInfo> identityProviders = null;

  @SerializedName("delegatedOrgs")
  private List<UserDelegationDetails> delegatedOrgs = null;

  @SerializedName("userGroups")
  private List<GroupAccessRole> userGroups = null;

  @SerializedName("rolePermissionInfo")
  private List<RolePermissionInfo> rolePermissionInfo = null;

  public UserResponseDetail id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @Schema(description = "")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public UserResponseDetail canChangePassword(Boolean canChangePassword) {
    this.canChangePassword = canChangePassword;
    return this;
  }

   /**
   * Get canChangePassword
   * @return canChangePassword
  **/
  @Schema(description = "")
  public Boolean isCanChangePassword() {
    return canChangePassword;
  }

  public void setCanChangePassword(Boolean canChangePassword) {
    this.canChangePassword = canChangePassword;
  }

  public UserResponseDetail identityProviders(List<UserIdentityProviderInfo> identityProviders) {
    this.identityProviders = identityProviders;
    return this;
  }

  public UserResponseDetail addIdentityProvidersItem(UserIdentityProviderInfo identityProvidersItem) {
    if (this.identityProviders == null) {
      this.identityProviders = new ArrayList<UserIdentityProviderInfo>();
    }
    this.identityProviders.add(identityProvidersItem);
    return this;
  }

   /**
   * Get identityProviders
   * @return identityProviders
  **/
  @Schema(description = "")
  public List<UserIdentityProviderInfo> getIdentityProviders() {
    return identityProviders;
  }

  public void setIdentityProviders(List<UserIdentityProviderInfo> identityProviders) {
    this.identityProviders = identityProviders;
  }

  public UserResponseDetail delegatedOrgs(List<UserDelegationDetails> delegatedOrgs) {
    this.delegatedOrgs = delegatedOrgs;
    return this;
  }

  public UserResponseDetail addDelegatedOrgsItem(UserDelegationDetails delegatedOrgsItem) {
    if (this.delegatedOrgs == null) {
      this.delegatedOrgs = new ArrayList<UserDelegationDetails>();
    }
    this.delegatedOrgs.add(delegatedOrgsItem);
    return this;
  }

   /**
   * Get delegatedOrgs
   * @return delegatedOrgs
  **/
  @Schema(description = "")
  public List<UserDelegationDetails> getDelegatedOrgs() {
    return delegatedOrgs;
  }

  public void setDelegatedOrgs(List<UserDelegationDetails> delegatedOrgs) {
    this.delegatedOrgs = delegatedOrgs;
  }

  public UserResponseDetail userGroups(List<GroupAccessRole> userGroups) {
    this.userGroups = userGroups;
    return this;
  }

  public UserResponseDetail addUserGroupsItem(GroupAccessRole userGroupsItem) {
    if (this.userGroups == null) {
      this.userGroups = new ArrayList<GroupAccessRole>();
    }
    this.userGroups.add(userGroupsItem);
    return this;
  }

   /**
   * Get userGroups
   * @return userGroups
  **/
  @Schema(description = "")
  public List<GroupAccessRole> getUserGroups() {
    return userGroups;
  }

  public void setUserGroups(List<GroupAccessRole> userGroups) {
    this.userGroups = userGroups;
  }

  public UserResponseDetail rolePermissionInfo(List<RolePermissionInfo> rolePermissionInfo) {
    this.rolePermissionInfo = rolePermissionInfo;
    return this;
  }

  public UserResponseDetail addRolePermissionInfoItem(RolePermissionInfo rolePermissionInfoItem) {
    if (this.rolePermissionInfo == null) {
      this.rolePermissionInfo = new ArrayList<RolePermissionInfo>();
    }
    this.rolePermissionInfo.add(rolePermissionInfoItem);
    return this;
  }

   /**
   * Get rolePermissionInfo
   * @return rolePermissionInfo
  **/
  @Schema(description = "")
  public List<RolePermissionInfo> getRolePermissionInfo() {
    return rolePermissionInfo;
  }

  public void setRolePermissionInfo(List<RolePermissionInfo> rolePermissionInfo) {
    this.rolePermissionInfo = rolePermissionInfo;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserResponseDetail userResponseDetail = (UserResponseDetail) o;
    return Objects.equals(this.id, userResponseDetail.id) &&
        Objects.equals(this.canChangePassword, userResponseDetail.canChangePassword) &&
        Objects.equals(this.identityProviders, userResponseDetail.identityProviders) &&
        Objects.equals(this.delegatedOrgs, userResponseDetail.delegatedOrgs) &&
        Objects.equals(this.userGroups, userResponseDetail.userGroups) &&
        Objects.equals(this.rolePermissionInfo, userResponseDetail.rolePermissionInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, canChangePassword, identityProviders, delegatedOrgs, userGroups, rolePermissionInfo);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserResponseDetail {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    canChangePassword: ").append(toIndentedString(canChangePassword)).append("\n");
    sb.append("    identityProviders: ").append(toIndentedString(identityProviders)).append("\n");
    sb.append("    delegatedOrgs: ").append(toIndentedString(delegatedOrgs)).append("\n");
    sb.append("    userGroups: ").append(toIndentedString(userGroups)).append("\n");
    sb.append("    rolePermissionInfo: ").append(toIndentedString(rolePermissionInfo)).append("\n");
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
