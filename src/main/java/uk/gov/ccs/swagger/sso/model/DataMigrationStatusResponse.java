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
import uk.gov.ccs.swagger.sso.model.DataMigrationMigrationReportDetails;
import uk.gov.ccs.swagger.sso.model.DataMigrationStatus;
import uk.gov.ccs.swagger.sso.model.StringStringKeyValuePair;
/**
 * DataMigrationStatusResponse
 */


public class DataMigrationStatusResponse {
  @SerializedName("id")
  private String id = null;

  @SerializedName("dataMigrationStatus")
  private DataMigrationStatus dataMigrationStatus = null;

  @SerializedName("errorDetails")
  private List<StringStringKeyValuePair> errorDetails = null;

  @SerializedName("dataMigrationMigrationReportDetails")
  private DataMigrationMigrationReportDetails dataMigrationMigrationReportDetails = null;

  public DataMigrationStatusResponse id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @Schema(description = "")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public DataMigrationStatusResponse dataMigrationStatus(DataMigrationStatus dataMigrationStatus) {
    this.dataMigrationStatus = dataMigrationStatus;
    return this;
  }

   /**
   * Get dataMigrationStatus
   * @return dataMigrationStatus
  **/
  @Schema(description = "")
  public DataMigrationStatus getDataMigrationStatus() {
    return dataMigrationStatus;
  }

  public void setDataMigrationStatus(DataMigrationStatus dataMigrationStatus) {
    this.dataMigrationStatus = dataMigrationStatus;
  }

  public DataMigrationStatusResponse errorDetails(List<StringStringKeyValuePair> errorDetails) {
    this.errorDetails = errorDetails;
    return this;
  }

  public DataMigrationStatusResponse addErrorDetailsItem(StringStringKeyValuePair errorDetailsItem) {
    if (this.errorDetails == null) {
      this.errorDetails = new ArrayList<StringStringKeyValuePair>();
    }
    this.errorDetails.add(errorDetailsItem);
    return this;
  }

   /**
   * Get errorDetails
   * @return errorDetails
  **/
  @Schema(description = "")
  public List<StringStringKeyValuePair> getErrorDetails() {
    return errorDetails;
  }

  public void setErrorDetails(List<StringStringKeyValuePair> errorDetails) {
    this.errorDetails = errorDetails;
  }

  public DataMigrationStatusResponse dataMigrationMigrationReportDetails(DataMigrationMigrationReportDetails dataMigrationMigrationReportDetails) {
    this.dataMigrationMigrationReportDetails = dataMigrationMigrationReportDetails;
    return this;
  }

   /**
   * Get dataMigrationMigrationReportDetails
   * @return dataMigrationMigrationReportDetails
  **/
  @Schema(description = "")
  public DataMigrationMigrationReportDetails getDataMigrationMigrationReportDetails() {
    return dataMigrationMigrationReportDetails;
  }

  public void setDataMigrationMigrationReportDetails(DataMigrationMigrationReportDetails dataMigrationMigrationReportDetails) {
    this.dataMigrationMigrationReportDetails = dataMigrationMigrationReportDetails;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataMigrationStatusResponse dataMigrationStatusResponse = (DataMigrationStatusResponse) o;
    return Objects.equals(this.id, dataMigrationStatusResponse.id) &&
        Objects.equals(this.dataMigrationStatus, dataMigrationStatusResponse.dataMigrationStatus) &&
        Objects.equals(this.errorDetails, dataMigrationStatusResponse.errorDetails) &&
        Objects.equals(this.dataMigrationMigrationReportDetails, dataMigrationStatusResponse.dataMigrationMigrationReportDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, dataMigrationStatus, errorDetails, dataMigrationMigrationReportDetails);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataMigrationStatusResponse {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    dataMigrationStatus: ").append(toIndentedString(dataMigrationStatus)).append("\n");
    sb.append("    errorDetails: ").append(toIndentedString(errorDetails)).append("\n");
    sb.append("    dataMigrationMigrationReportDetails: ").append(toIndentedString(dataMigrationMigrationReportDetails)).append("\n");
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
