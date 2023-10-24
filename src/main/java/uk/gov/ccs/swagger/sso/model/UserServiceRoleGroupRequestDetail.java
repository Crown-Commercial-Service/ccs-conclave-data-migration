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
/**
 * UserServiceRoleGroupRequestDetail
 */


public class UserServiceRoleGroupRequestDetail {
  @SerializedName("id")
  private Integer id = null;

  @SerializedName("groupIds")
  private List<Integer> groupIds = null;

  @SerializedName("groupType")
  private Integer groupType = null;

  @SerializedName("identityProviderIds")
  private List<Integer> identityProviderIds = null;

  @SerializedName("serviceRoleGroupIds")
  private List<Integer> serviceRoleGroupIds = null;

  public UserServiceRoleGroupRequestDetail id(Integer id) {
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

  public UserServiceRoleGroupRequestDetail groupIds(List<Integer> groupIds) {
    this.groupIds = groupIds;
    return this;
  }

  public UserServiceRoleGroupRequestDetail addGroupIdsItem(Integer groupIdsItem) {
    if (this.groupIds == null) {
      this.groupIds = new ArrayList<Integer>();
    }
    this.groupIds.add(groupIdsItem);
    return this;
  }

   /**
   * Get groupIds
   * @return groupIds
  **/
  @Schema(description = "")
  public List<Integer> getGroupIds() {
    return groupIds;
  }

  public void setGroupIds(List<Integer> groupIds) {
    this.groupIds = groupIds;
  }

  public UserServiceRoleGroupRequestDetail groupType(Integer groupType) {
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

  public UserServiceRoleGroupRequestDetail identityProviderIds(List<Integer> identityProviderIds) {
    this.identityProviderIds = identityProviderIds;
    return this;
  }

  public UserServiceRoleGroupRequestDetail addIdentityProviderIdsItem(Integer identityProviderIdsItem) {
    if (this.identityProviderIds == null) {
      this.identityProviderIds = new ArrayList<Integer>();
    }
    this.identityProviderIds.add(identityProviderIdsItem);
    return this;
  }

   /**
   * Get identityProviderIds
   * @return identityProviderIds
  **/
  @Schema(description = "")
  public List<Integer> getIdentityProviderIds() {
    return identityProviderIds;
  }

  public void setIdentityProviderIds(List<Integer> identityProviderIds) {
    this.identityProviderIds = identityProviderIds;
  }

  public UserServiceRoleGroupRequestDetail serviceRoleGroupIds(List<Integer> serviceRoleGroupIds) {
    this.serviceRoleGroupIds = serviceRoleGroupIds;
    return this;
  }

  public UserServiceRoleGroupRequestDetail addServiceRoleGroupIdsItem(Integer serviceRoleGroupIdsItem) {
    if (this.serviceRoleGroupIds == null) {
      this.serviceRoleGroupIds = new ArrayList<Integer>();
    }
    this.serviceRoleGroupIds.add(serviceRoleGroupIdsItem);
    return this;
  }

   /**
   * Get serviceRoleGroupIds
   * @return serviceRoleGroupIds
  **/
  @Schema(description = "")
  public List<Integer> getServiceRoleGroupIds() {
    return serviceRoleGroupIds;
  }

  public void setServiceRoleGroupIds(List<Integer> serviceRoleGroupIds) {
    this.serviceRoleGroupIds = serviceRoleGroupIds;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserServiceRoleGroupRequestDetail userServiceRoleGroupRequestDetail = (UserServiceRoleGroupRequestDetail) o;
    return Objects.equals(this.id, userServiceRoleGroupRequestDetail.id) &&
        Objects.equals(this.groupIds, userServiceRoleGroupRequestDetail.groupIds) &&
        Objects.equals(this.groupType, userServiceRoleGroupRequestDetail.groupType) &&
        Objects.equals(this.identityProviderIds, userServiceRoleGroupRequestDetail.identityProviderIds) &&
        Objects.equals(this.serviceRoleGroupIds, userServiceRoleGroupRequestDetail.serviceRoleGroupIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, groupIds, groupType, identityProviderIds, serviceRoleGroupIds);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserServiceRoleGroupRequestDetail {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    groupIds: ").append(toIndentedString(groupIds)).append("\n");
    sb.append("    groupType: ").append(toIndentedString(groupType)).append("\n");
    sb.append("    identityProviderIds: ").append(toIndentedString(identityProviderIds)).append("\n");
    sb.append("    serviceRoleGroupIds: ").append(toIndentedString(serviceRoleGroupIds)).append("\n");
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