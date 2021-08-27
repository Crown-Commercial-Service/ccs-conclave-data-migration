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
import java.util.ArrayList;
import java.util.List;
import uk.gov.ccs.swagger.sso.model.UserListInfo;
/**
 * UserListResponse
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-08-27T09:35:55.156031+01:00[Europe/London]")
public class UserListResponse {
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

  public UserListResponse currentPage(Integer currentPage) {
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

  public UserListResponse pageCount(Integer pageCount) {
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

  public UserListResponse rowCount(Integer rowCount) {
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

  public UserListResponse organisationId(String organisationId) {
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

  public UserListResponse userList(List<UserListInfo> userList) {
    this.userList = userList;
    return this;
  }

  public UserListResponse addUserListItem(UserListInfo userListItem) {
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
    UserListResponse userListResponse = (UserListResponse) o;
    return Objects.equals(this.currentPage, userListResponse.currentPage) &&
        Objects.equals(this.pageCount, userListResponse.pageCount) &&
        Objects.equals(this.rowCount, userListResponse.rowCount) &&
        Objects.equals(this.organisationId, userListResponse.organisationId) &&
        Objects.equals(this.userList, userListResponse.userList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currentPage, pageCount, rowCount, organisationId, userList);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserListResponse {\n");
    
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
