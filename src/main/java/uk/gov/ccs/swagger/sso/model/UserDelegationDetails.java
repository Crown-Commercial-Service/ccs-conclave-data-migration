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
import org.threeten.bp.OffsetDateTime;
/**
 * UserDelegationDetails
 */


public class UserDelegationDetails {
  @SerializedName("delegatedOrgId")
  private String delegatedOrgId = null;

  @SerializedName("delegatedOrgName")
  private String delegatedOrgName = null;

  @SerializedName("startDate")
  private OffsetDateTime startDate = null;

  @SerializedName("endDate")
  private OffsetDateTime endDate = null;

  @SerializedName("delegationAccepted")
  private Boolean delegationAccepted = null;

  public UserDelegationDetails delegatedOrgId(String delegatedOrgId) {
    this.delegatedOrgId = delegatedOrgId;
    return this;
  }

   /**
   * Get delegatedOrgId
   * @return delegatedOrgId
  **/
  @Schema(description = "")
  public String getDelegatedOrgId() {
    return delegatedOrgId;
  }

  public void setDelegatedOrgId(String delegatedOrgId) {
    this.delegatedOrgId = delegatedOrgId;
  }

  public UserDelegationDetails delegatedOrgName(String delegatedOrgName) {
    this.delegatedOrgName = delegatedOrgName;
    return this;
  }

   /**
   * Get delegatedOrgName
   * @return delegatedOrgName
  **/
  @Schema(description = "")
  public String getDelegatedOrgName() {
    return delegatedOrgName;
  }

  public void setDelegatedOrgName(String delegatedOrgName) {
    this.delegatedOrgName = delegatedOrgName;
  }

  public UserDelegationDetails startDate(OffsetDateTime startDate) {
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

  public UserDelegationDetails endDate(OffsetDateTime endDate) {
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

  public UserDelegationDetails delegationAccepted(Boolean delegationAccepted) {
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserDelegationDetails userDelegationDetails = (UserDelegationDetails) o;
    return Objects.equals(this.delegatedOrgId, userDelegationDetails.delegatedOrgId) &&
        Objects.equals(this.delegatedOrgName, userDelegationDetails.delegatedOrgName) &&
        Objects.equals(this.startDate, userDelegationDetails.startDate) &&
        Objects.equals(this.endDate, userDelegationDetails.endDate) &&
        Objects.equals(this.delegationAccepted, userDelegationDetails.delegationAccepted);
  }

  @Override
  public int hashCode() {
    return Objects.hash(delegatedOrgId, delegatedOrgName, startDate, endDate, delegationAccepted);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserDelegationDetails {\n");
    
    sb.append("    delegatedOrgId: ").append(toIndentedString(delegatedOrgId)).append("\n");
    sb.append("    delegatedOrgName: ").append(toIndentedString(delegatedOrgName)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    delegationAccepted: ").append(toIndentedString(delegationAccepted)).append("\n");
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
