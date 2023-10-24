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
import uk.gov.ccs.swagger.sso.model.UserListInfo;
/**
 * UserListResponseInfo
 */


public class UserListResponseInfo {
  @SerializedName("currentPage")
  private Integer currentPage = null;

  @SerializedName("pageCount")
  private Integer pageCount = null;

  @SerializedName("rowCount")
  private Integer rowCount = null;

  @SerializedName("organisationId")
  private String organisationId = null;

  @SerializedName("userList")
  private List<UserListInfo> userList = null;

  public UserListResponseInfo currentPage(Integer currentPage) {
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

  public UserListResponseInfo pageCount(Integer pageCount) {
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

  public UserListResponseInfo rowCount(Integer rowCount) {
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

  public UserListResponseInfo organisationId(String organisationId) {
    this.organisationId = organisationId;
    return this;
  }

   /**
   * Get organisationId
   * @return organisationId
  **/
  @Schema(description = "")
  public String getOrganisationId() {
    return organisationId;
  }

  public void setOrganisationId(String organisationId) {
    this.organisationId = organisationId;
  }

  public UserListResponseInfo userList(List<UserListInfo> userList) {
    this.userList = userList;
    return this;
  }

  public UserListResponseInfo addUserListItem(UserListInfo userListItem) {
    if (this.userList == null) {
      this.userList = new ArrayList<UserListInfo>();
    }
    this.userList.add(userListItem);
    return this;
  }

   /**
   * Get userList
   * @return userList
  **/
  @Schema(description = "")
  public List<UserListInfo> getUserList() {
    return userList;
  }

  public void setUserList(List<UserListInfo> userList) {
    this.userList = userList;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserListResponseInfo userListResponseInfo = (UserListResponseInfo) o;
    return Objects.equals(this.currentPage, userListResponseInfo.currentPage) &&
        Objects.equals(this.pageCount, userListResponseInfo.pageCount) &&
        Objects.equals(this.rowCount, userListResponseInfo.rowCount) &&
        Objects.equals(this.organisationId, userListResponseInfo.organisationId) &&
        Objects.equals(this.userList, userListResponseInfo.userList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currentPage, pageCount, rowCount, organisationId, userList);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserListResponseInfo {\n");
    
    sb.append("    currentPage: ").append(toIndentedString(currentPage)).append("\n");
    sb.append("    pageCount: ").append(toIndentedString(pageCount)).append("\n");
    sb.append("    rowCount: ").append(toIndentedString(rowCount)).append("\n");
    sb.append("    organisationId: ").append(toIndentedString(organisationId)).append("\n");
    sb.append("    userList: ").append(toIndentedString(userList)).append("\n");
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