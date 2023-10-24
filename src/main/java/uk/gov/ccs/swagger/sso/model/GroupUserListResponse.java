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
import uk.gov.ccs.swagger.sso.model.GroupUser;
/**
 * GroupUserListResponse
 */


public class GroupUserListResponse {
  @SerializedName("currentPage")
  private Integer currentPage = null;

  @SerializedName("pageCount")
  private Integer pageCount = null;

  @SerializedName("rowCount")
  private Integer rowCount = null;

  @SerializedName("groupId")
  private Integer groupId = null;

  @SerializedName("groupType")
  private Integer groupType = null;

  @SerializedName("groupUser")
  private List<GroupUser> groupUser = null;

  public GroupUserListResponse currentPage(Integer currentPage) {
    this.currentPage = currentPage;
    return this;
  }

   /**
   * Get currentPage
   * @return currentPage
  **/
  @Schema(description = "")
  public Integer getCurrentPage() {
    return currentPage;
  }

  public void setCurrentPage(Integer currentPage) {
    this.currentPage = currentPage;
  }

  public GroupUserListResponse pageCount(Integer pageCount) {
    this.pageCount = pageCount;
    return this;
  }

   /**
   * Get pageCount
   * @return pageCount
  **/
  @Schema(description = "")
  public Integer getPageCount() {
    return pageCount;
  }

  public void setPageCount(Integer pageCount) {
    this.pageCount = pageCount;
  }

  public GroupUserListResponse rowCount(Integer rowCount) {
    this.rowCount = rowCount;
    return this;
  }

   /**
   * Get rowCount
   * @return rowCount
  **/
  @Schema(description = "")
  public Integer getRowCount() {
    return rowCount;
  }

  public void setRowCount(Integer rowCount) {
    this.rowCount = rowCount;
  }

  public GroupUserListResponse groupId(Integer groupId) {
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

  public GroupUserListResponse groupType(Integer groupType) {
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

  public GroupUserListResponse groupUser(List<GroupUser> groupUser) {
    this.groupUser = groupUser;
    return this;
  }

  public GroupUserListResponse addGroupUserItem(GroupUser groupUserItem) {
    if (this.groupUser == null) {
      this.groupUser = new ArrayList<GroupUser>();
    }
    this.groupUser.add(groupUserItem);
    return this;
  }

   /**
   * Get groupUser
   * @return groupUser
  **/
  @Schema(description = "")
  public List<GroupUser> getGroupUser() {
    return groupUser;
  }

  public void setGroupUser(List<GroupUser> groupUser) {
    this.groupUser = groupUser;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GroupUserListResponse groupUserListResponse = (GroupUserListResponse) o;
    return Objects.equals(this.currentPage, groupUserListResponse.currentPage) &&
        Objects.equals(this.pageCount, groupUserListResponse.pageCount) &&
        Objects.equals(this.rowCount, groupUserListResponse.rowCount) &&
        Objects.equals(this.groupId, groupUserListResponse.groupId) &&
        Objects.equals(this.groupType, groupUserListResponse.groupType) &&
        Objects.equals(this.groupUser, groupUserListResponse.groupUser);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currentPage, pageCount, rowCount, groupId, groupType, groupUser);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GroupUserListResponse {\n");
    
    sb.append("    currentPage: ").append(toIndentedString(currentPage)).append("\n");
    sb.append("    pageCount: ").append(toIndentedString(pageCount)).append("\n");
    sb.append("    rowCount: ").append(toIndentedString(rowCount)).append("\n");
    sb.append("    groupId: ").append(toIndentedString(groupId)).append("\n");
    sb.append("    groupType: ").append(toIndentedString(groupType)).append("\n");
    sb.append("    groupUser: ").append(toIndentedString(groupUser)).append("\n");
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
