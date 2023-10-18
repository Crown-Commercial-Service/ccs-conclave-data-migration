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
import uk.gov.ccs.swagger.sso.model.DelegationAuditEventServiceRoleGroupResponseInfo;
/**
 * DelegationAuditEventoServiceRoleGroupInfListResponse
 */


public class DelegationAuditEventoServiceRoleGroupInfListResponse {
  @SerializedName("currentPage")
  private Integer currentPage = null;

  @SerializedName("pageCount")
  private Integer pageCount = null;

  @SerializedName("rowCount")
  private Integer rowCount = null;

  @SerializedName("delegationAuditEventServiceRoleGroupList")
  private List<DelegationAuditEventServiceRoleGroupResponseInfo> delegationAuditEventServiceRoleGroupList = null;

  public DelegationAuditEventoServiceRoleGroupInfListResponse currentPage(Integer currentPage) {
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

  public DelegationAuditEventoServiceRoleGroupInfListResponse pageCount(Integer pageCount) {
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

  public DelegationAuditEventoServiceRoleGroupInfListResponse rowCount(Integer rowCount) {
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

  public DelegationAuditEventoServiceRoleGroupInfListResponse delegationAuditEventServiceRoleGroupList(List<DelegationAuditEventServiceRoleGroupResponseInfo> delegationAuditEventServiceRoleGroupList) {
    this.delegationAuditEventServiceRoleGroupList = delegationAuditEventServiceRoleGroupList;
    return this;
  }

  public DelegationAuditEventoServiceRoleGroupInfListResponse addDelegationAuditEventServiceRoleGroupListItem(DelegationAuditEventServiceRoleGroupResponseInfo delegationAuditEventServiceRoleGroupListItem) {
    if (this.delegationAuditEventServiceRoleGroupList == null) {
      this.delegationAuditEventServiceRoleGroupList = new ArrayList<DelegationAuditEventServiceRoleGroupResponseInfo>();
    }
    this.delegationAuditEventServiceRoleGroupList.add(delegationAuditEventServiceRoleGroupListItem);
    return this;
  }

   /**
   * Get delegationAuditEventServiceRoleGroupList
   * @return delegationAuditEventServiceRoleGroupList
  **/
  @Schema(description = "")
  public List<DelegationAuditEventServiceRoleGroupResponseInfo> getDelegationAuditEventServiceRoleGroupList() {
    return delegationAuditEventServiceRoleGroupList;
  }

  public void setDelegationAuditEventServiceRoleGroupList(List<DelegationAuditEventServiceRoleGroupResponseInfo> delegationAuditEventServiceRoleGroupList) {
    this.delegationAuditEventServiceRoleGroupList = delegationAuditEventServiceRoleGroupList;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DelegationAuditEventoServiceRoleGroupInfListResponse delegationAuditEventoServiceRoleGroupInfListResponse = (DelegationAuditEventoServiceRoleGroupInfListResponse) o;
    return Objects.equals(this.currentPage, delegationAuditEventoServiceRoleGroupInfListResponse.currentPage) &&
        Objects.equals(this.pageCount, delegationAuditEventoServiceRoleGroupInfListResponse.pageCount) &&
        Objects.equals(this.rowCount, delegationAuditEventoServiceRoleGroupInfListResponse.rowCount) &&
        Objects.equals(this.delegationAuditEventServiceRoleGroupList, delegationAuditEventoServiceRoleGroupInfListResponse.delegationAuditEventServiceRoleGroupList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currentPage, pageCount, rowCount, delegationAuditEventServiceRoleGroupList);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DelegationAuditEventoServiceRoleGroupInfListResponse {\n");
    
    sb.append("    currentPage: ").append(toIndentedString(currentPage)).append("\n");
    sb.append("    pageCount: ").append(toIndentedString(pageCount)).append("\n");
    sb.append("    rowCount: ").append(toIndentedString(rowCount)).append("\n");
    sb.append("    delegationAuditEventServiceRoleGroupList: ").append(toIndentedString(delegationAuditEventServiceRoleGroupList)).append("\n");
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
