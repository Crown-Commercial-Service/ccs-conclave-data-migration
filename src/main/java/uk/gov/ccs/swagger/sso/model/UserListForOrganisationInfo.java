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
import org.threeten.bp.OffsetDateTime;
import uk.gov.ccs.swagger.sso.model.RolePermissionInfo;
import uk.gov.ccs.swagger.sso.model.UserGroupMembershipInfo;
import uk.gov.ccs.swagger.sso.model.UserIdentityProviderDetails;
import uk.gov.ccs.swagger.sso.model.UserType;
/**
 * UserListForOrganisationInfo
 */


public class UserListForOrganisationInfo {
  @SerializedName("id")
  private Integer id = null;

  @SerializedName("startDate")
  private OffsetDateTime startDate = null;

  @SerializedName("endDate")
  private OffsetDateTime endDate = null;

  @SerializedName("originOrganisation")
  private String originOrganisation = null;

  @SerializedName("delegationAccepted")
  private Boolean delegationAccepted = null;

  @SerializedName("isAdmin")
  private Boolean isAdmin = null;

  @SerializedName("rolePermissionInfo")
  private List<RolePermissionInfo> rolePermissionInfo = null;

  @SerializedName("userGroupMembershipInfo")
  private List<UserGroupMembershipInfo> userGroupMembershipInfo = null;

  @SerializedName("isDeleted")
  private Boolean isDeleted = null;

  @SerializedName("accountVerified")
  private Boolean accountVerified = null;

  @SerializedName("firstName")
  private String firstName = null;

  @SerializedName("lastName")
  private String lastName = null;

  @SerializedName("userIdentityProviderInfo")
  private List<UserIdentityProviderDetails> userIdentityProviderInfo = null;

  @SerializedName("userType")
  private UserType userType = null;

  @SerializedName("userName")
  private String userName = null;

  public UserListForOrganisationInfo id(Integer id) {
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

  public UserListForOrganisationInfo startDate(OffsetDateTime startDate) {
    this.startDate = startDate;
    return this;
  }

   /**
   * Get startDate
   * @return startDate
  **/
  @Schema(description = "")
  public OffsetDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(OffsetDateTime startDate) {
    this.startDate = startDate;
  }

  public UserListForOrganisationInfo endDate(OffsetDateTime endDate) {
    this.endDate = endDate;
    return this;
  }

   /**
   * Get endDate
   * @return endDate
  **/
  @Schema(description = "")
  public OffsetDateTime getEndDate() {
    return endDate;
  }

  public void setEndDate(OffsetDateTime endDate) {
    this.endDate = endDate;
  }

  public UserListForOrganisationInfo originOrganisation(String originOrganisation) {
    this.originOrganisation = originOrganisation;
    return this;
  }

   /**
   * Get originOrganisation
   * @return originOrganisation
  **/
  @Schema(description = "")
  public String getOriginOrganisation() {
    return originOrganisation;
  }

  public void setOriginOrganisation(String originOrganisation) {
    this.originOrganisation = originOrganisation;
  }

  public UserListForOrganisationInfo delegationAccepted(Boolean delegationAccepted) {
    this.delegationAccepted = delegationAccepted;
    return this;
  }

   /**
   * Get delegationAccepted
   * @return delegationAccepted
  **/
  @Schema(description = "")
  public Boolean isDelegationAccepted() {
    return delegationAccepted;
  }

  public void setDelegationAccepted(Boolean delegationAccepted) {
    this.delegationAccepted = delegationAccepted;
  }

  public UserListForOrganisationInfo isAdmin(Boolean isAdmin) {
    this.isAdmin = isAdmin;
    return this;
  }

   /**
   * Get isAdmin
   * @return isAdmin
  **/
  @Schema(description = "")
  public Boolean isIsAdmin() {
    return isAdmin;
  }

  public void setIsAdmin(Boolean isAdmin) {
    this.isAdmin = isAdmin;
  }

  public UserListForOrganisationInfo rolePermissionInfo(List<RolePermissionInfo> rolePermissionInfo) {
    this.rolePermissionInfo = rolePermissionInfo;
    return this;
  }

  public UserListForOrganisationInfo addRolePermissionInfoItem(RolePermissionInfo rolePermissionInfoItem) {
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

  public UserListForOrganisationInfo userGroupMembershipInfo(List<UserGroupMembershipInfo> userGroupMembershipInfo) {
    this.userGroupMembershipInfo = userGroupMembershipInfo;
    return this;
  }

  public UserListForOrganisationInfo addUserGroupMembershipInfoItem(UserGroupMembershipInfo userGroupMembershipInfoItem) {
    if (this.userGroupMembershipInfo == null) {
      this.userGroupMembershipInfo = new ArrayList<UserGroupMembershipInfo>();
    }
    this.userGroupMembershipInfo.add(userGroupMembershipInfoItem);
    return this;
  }

   /**
   * Get userGroupMembershipInfo
   * @return userGroupMembershipInfo
  **/
  @Schema(description = "")
  public List<UserGroupMembershipInfo> getUserGroupMembershipInfo() {
    return userGroupMembershipInfo;
  }

  public void setUserGroupMembershipInfo(List<UserGroupMembershipInfo> userGroupMembershipInfo) {
    this.userGroupMembershipInfo = userGroupMembershipInfo;
  }

  public UserListForOrganisationInfo isDeleted(Boolean isDeleted) {
    this.isDeleted = isDeleted;
    return this;
  }

   /**
   * Get isDeleted
   * @return isDeleted
  **/
  @Schema(description = "")
  public Boolean isIsDeleted() {
    return isDeleted;
  }

  public void setIsDeleted(Boolean isDeleted) {
    this.isDeleted = isDeleted;
  }

  public UserListForOrganisationInfo accountVerified(Boolean accountVerified) {
    this.accountVerified = accountVerified;
    return this;
  }

   /**
   * Get accountVerified
   * @return accountVerified
  **/
  @Schema(description = "")
  public Boolean isAccountVerified() {
    return accountVerified;
  }

  public void setAccountVerified(Boolean accountVerified) {
    this.accountVerified = accountVerified;
  }

  public UserListForOrganisationInfo firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

   /**
   * Get firstName
   * @return firstName
  **/
  @Schema(description = "")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public UserListForOrganisationInfo lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

   /**
   * Get lastName
   * @return lastName
  **/
  @Schema(description = "")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public UserListForOrganisationInfo userIdentityProviderInfo(List<UserIdentityProviderDetails> userIdentityProviderInfo) {
    this.userIdentityProviderInfo = userIdentityProviderInfo;
    return this;
  }

  public UserListForOrganisationInfo addUserIdentityProviderInfoItem(UserIdentityProviderDetails userIdentityProviderInfoItem) {
    if (this.userIdentityProviderInfo == null) {
      this.userIdentityProviderInfo = new ArrayList<UserIdentityProviderDetails>();
    }
    this.userIdentityProviderInfo.add(userIdentityProviderInfoItem);
    return this;
  }

   /**
   * Get userIdentityProviderInfo
   * @return userIdentityProviderInfo
  **/
  @Schema(description = "")
  public List<UserIdentityProviderDetails> getUserIdentityProviderInfo() {
    return userIdentityProviderInfo;
  }

  public void setUserIdentityProviderInfo(List<UserIdentityProviderDetails> userIdentityProviderInfo) {
    this.userIdentityProviderInfo = userIdentityProviderInfo;
  }

  public UserListForOrganisationInfo userType(UserType userType) {
    this.userType = userType;
    return this;
  }

   /**
   * Get userType
   * @return userType
  **/
  @Schema(description = "")
  public UserType getUserType() {
    return userType;
  }

  public void setUserType(UserType userType) {
    this.userType = userType;
  }

  public UserListForOrganisationInfo userName(String userName) {
    this.userName = userName;
    return this;
  }

   /**
   * Get userName
   * @return userName
  **/
  @Schema(description = "")
  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserListForOrganisationInfo userListForOrganisationInfo = (UserListForOrganisationInfo) o;
    return Objects.equals(this.id, userListForOrganisationInfo.id) &&
        Objects.equals(this.startDate, userListForOrganisationInfo.startDate) &&
        Objects.equals(this.endDate, userListForOrganisationInfo.endDate) &&
        Objects.equals(this.originOrganisation, userListForOrganisationInfo.originOrganisation) &&
        Objects.equals(this.delegationAccepted, userListForOrganisationInfo.delegationAccepted) &&
        Objects.equals(this.isAdmin, userListForOrganisationInfo.isAdmin) &&
        Objects.equals(this.rolePermissionInfo, userListForOrganisationInfo.rolePermissionInfo) &&
        Objects.equals(this.userGroupMembershipInfo, userListForOrganisationInfo.userGroupMembershipInfo) &&
        Objects.equals(this.isDeleted, userListForOrganisationInfo.isDeleted) &&
        Objects.equals(this.accountVerified, userListForOrganisationInfo.accountVerified) &&
        Objects.equals(this.firstName, userListForOrganisationInfo.firstName) &&
        Objects.equals(this.lastName, userListForOrganisationInfo.lastName) &&
        Objects.equals(this.userIdentityProviderInfo, userListForOrganisationInfo.userIdentityProviderInfo) &&
        Objects.equals(this.userType, userListForOrganisationInfo.userType) &&
        Objects.equals(this.userName, userListForOrganisationInfo.userName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, startDate, endDate, originOrganisation, delegationAccepted, isAdmin, rolePermissionInfo, userGroupMembershipInfo, isDeleted, accountVerified, firstName, lastName, userIdentityProviderInfo, userType, userName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserListForOrganisationInfo {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    originOrganisation: ").append(toIndentedString(originOrganisation)).append("\n");
    sb.append("    delegationAccepted: ").append(toIndentedString(delegationAccepted)).append("\n");
    sb.append("    isAdmin: ").append(toIndentedString(isAdmin)).append("\n");
    sb.append("    rolePermissionInfo: ").append(toIndentedString(rolePermissionInfo)).append("\n");
    sb.append("    userGroupMembershipInfo: ").append(toIndentedString(userGroupMembershipInfo)).append("\n");
    sb.append("    isDeleted: ").append(toIndentedString(isDeleted)).append("\n");
    sb.append("    accountVerified: ").append(toIndentedString(accountVerified)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    userIdentityProviderInfo: ").append(toIndentedString(userIdentityProviderInfo)).append("\n");
    sb.append("    userType: ").append(toIndentedString(userType)).append("\n");
    sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
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
