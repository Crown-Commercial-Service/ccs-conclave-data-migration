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
import uk.gov.ccs.swagger.sso.model.OrganisationGroupInfo;
/**
 * OrganisationGroupList
 */


public class OrganisationGroupList {
  @SerializedName("organisationId")
  private String organisationId = null;

  @SerializedName("groupList")
  private List<OrganisationGroupInfo> groupList = null;

  public OrganisationGroupList organisationId(String organisationId) {
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

  public OrganisationGroupList groupList(List<OrganisationGroupInfo> groupList) {
    this.groupList = groupList;
    return this;
  }

  public OrganisationGroupList addGroupListItem(OrganisationGroupInfo groupListItem) {
    if (this.groupList == null) {
      this.groupList = new ArrayList<OrganisationGroupInfo>();
    }
    this.groupList.add(groupListItem);
    return this;
  }

   /**
   * Get groupList
   * @return groupList
  **/
  @Schema(description = "")
  public List<OrganisationGroupInfo> getGroupList() {
    return groupList;
  }

  public void setGroupList(List<OrganisationGroupInfo> groupList) {
    this.groupList = groupList;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrganisationGroupList organisationGroupList = (OrganisationGroupList) o;
    return Objects.equals(this.organisationId, organisationGroupList.organisationId) &&
        Objects.equals(this.groupList, organisationGroupList.groupList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(organisationId, groupList);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrganisationGroupList {\n");
    
    sb.append("    organisationId: ").append(toIndentedString(organisationId)).append("\n");
    sb.append("    groupList: ").append(toIndentedString(groupList)).append("\n");
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
