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
import java.util.ArrayList;
import java.util.List;
/**
 * OrganisationGroupUserPatchInfo
 */


public class OrganisationGroupUserPatchInfo {
  @SerializedName("addedUserIds")
  private List<String> addedUserIds = null;

  @SerializedName("removedUserIds")
  private List<String> removedUserIds = null;

  public OrganisationGroupUserPatchInfo addedUserIds(List<String> addedUserIds) {
    this.addedUserIds = addedUserIds;
    return this;
  }

  public OrganisationGroupUserPatchInfo addAddedUserIdsItem(String addedUserIdsItem) {
    if (this.addedUserIds == null) {
      this.addedUserIds = new ArrayList<String>();
    }
    this.addedUserIds.add(addedUserIdsItem);
    return this;
  }

   /**
   * Get addedUserIds
   * @return addedUserIds
  **/
  @Schema(description = "")
  public List<String> getAddedUserIds() {
    return addedUserIds;
  }

  public void setAddedUserIds(List<String> addedUserIds) {
    this.addedUserIds = addedUserIds;
  }

  public OrganisationGroupUserPatchInfo removedUserIds(List<String> removedUserIds) {
    this.removedUserIds = removedUserIds;
    return this;
  }

  public OrganisationGroupUserPatchInfo addRemovedUserIdsItem(String removedUserIdsItem) {
    if (this.removedUserIds == null) {
      this.removedUserIds = new ArrayList<String>();
    }
    this.removedUserIds.add(removedUserIdsItem);
    return this;
  }

   /**
   * Get removedUserIds
   * @return removedUserIds
  **/
  @Schema(description = "")
  public List<String> getRemovedUserIds() {
    return removedUserIds;
  }

  public void setRemovedUserIds(List<String> removedUserIds) {
    this.removedUserIds = removedUserIds;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrganisationGroupUserPatchInfo organisationGroupUserPatchInfo = (OrganisationGroupUserPatchInfo) o;
    return Objects.equals(this.addedUserIds, organisationGroupUserPatchInfo.addedUserIds) &&
        Objects.equals(this.removedUserIds, organisationGroupUserPatchInfo.removedUserIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(addedUserIds, removedUserIds);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrganisationGroupUserPatchInfo {\n");
    
    sb.append("    addedUserIds: ").append(toIndentedString(addedUserIds)).append("\n");
    sb.append("    removedUserIds: ").append(toIndentedString(removedUserIds)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
