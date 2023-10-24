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
import org.threeten.bp.OffsetDateTime;
import uk.gov.ccs.swagger.sso.model.BulkUploadFileContentRowDetails;
/**
 * BulkUploadMigrationReportDetails
 */


public class BulkUploadMigrationReportDetails {
  @SerializedName("migrationStartedTime")
  private OffsetDateTime migrationStartedTime = null;

  @SerializedName("migrationEndTime")
  private OffsetDateTime migrationEndTime = null;

  @SerializedName("totalUserCount")
  private Integer totalUserCount = null;

  @SerializedName("totalOrganisationCount")
  private Integer totalOrganisationCount = null;

  @SerializedName("processedUserCount")
  private Integer processedUserCount = null;

  @SerializedName("failedUserCount")
  private Integer failedUserCount = null;

  @SerializedName("bulkUploadFileContentRowList")
  private List<BulkUploadFileContentRowDetails> bulkUploadFileContentRowList = null;

  public BulkUploadMigrationReportDetails migrationStartedTime(OffsetDateTime migrationStartedTime) {
    this.migrationStartedTime = migrationStartedTime;
    return this;
  }

   /**
   * Get migrationStartedTime
   * @return migrationStartedTime
  **/
  @Schema(description = "")
  public OffsetDateTime getMigrationStartedTime() {
    return migrationStartedTime;
  }

  public void setMigrationStartedTime(OffsetDateTime migrationStartedTime) {
    this.migrationStartedTime = migrationStartedTime;
  }

  public BulkUploadMigrationReportDetails migrationEndTime(OffsetDateTime migrationEndTime) {
    this.migrationEndTime = migrationEndTime;
    return this;
  }

   /**
   * Get migrationEndTime
   * @return migrationEndTime
  **/
  @Schema(description = "")
  public OffsetDateTime getMigrationEndTime() {
    return migrationEndTime;
  }

  public void setMigrationEndTime(OffsetDateTime migrationEndTime) {
    this.migrationEndTime = migrationEndTime;
  }

  public BulkUploadMigrationReportDetails totalUserCount(Integer totalUserCount) {
    this.totalUserCount = totalUserCount;
    return this;
  }

   /**
   * Get totalUserCount
   * @return totalUserCount
  **/
  @Schema(description = "")
  public Integer getTotalUserCount() {
    return totalUserCount;
  }

  public void setTotalUserCount(Integer totalUserCount) {
    this.totalUserCount = totalUserCount;
  }

  public BulkUploadMigrationReportDetails totalOrganisationCount(Integer totalOrganisationCount) {
    this.totalOrganisationCount = totalOrganisationCount;
    return this;
  }

   /**
   * Get totalOrganisationCount
   * @return totalOrganisationCount
  **/
  @Schema(description = "")
  public Integer getTotalOrganisationCount() {
    return totalOrganisationCount;
  }

  public void setTotalOrganisationCount(Integer totalOrganisationCount) {
    this.totalOrganisationCount = totalOrganisationCount;
  }

  public BulkUploadMigrationReportDetails processedUserCount(Integer processedUserCount) {
    this.processedUserCount = processedUserCount;
    return this;
  }

   /**
   * Get processedUserCount
   * @return processedUserCount
  **/
  @Schema(description = "")
  public Integer getProcessedUserCount() {
    return processedUserCount;
  }

  public void setProcessedUserCount(Integer processedUserCount) {
    this.processedUserCount = processedUserCount;
  }

  public BulkUploadMigrationReportDetails failedUserCount(Integer failedUserCount) {
    this.failedUserCount = failedUserCount;
    return this;
  }

   /**
   * Get failedUserCount
   * @return failedUserCount
  **/
  @Schema(description = "")
  public Integer getFailedUserCount() {
    return failedUserCount;
  }

  public void setFailedUserCount(Integer failedUserCount) {
    this.failedUserCount = failedUserCount;
  }

  public BulkUploadMigrationReportDetails bulkUploadFileContentRowList(List<BulkUploadFileContentRowDetails> bulkUploadFileContentRowList) {
    this.bulkUploadFileContentRowList = bulkUploadFileContentRowList;
    return this;
  }

  public BulkUploadMigrationReportDetails addBulkUploadFileContentRowListItem(BulkUploadFileContentRowDetails bulkUploadFileContentRowListItem) {
    if (this.bulkUploadFileContentRowList == null) {
      this.bulkUploadFileContentRowList = new ArrayList<BulkUploadFileContentRowDetails>();
    }
    this.bulkUploadFileContentRowList.add(bulkUploadFileContentRowListItem);
    return this;
  }

   /**
   * Get bulkUploadFileContentRowList
   * @return bulkUploadFileContentRowList
  **/
  @Schema(description = "")
  public List<BulkUploadFileContentRowDetails> getBulkUploadFileContentRowList() {
    return bulkUploadFileContentRowList;
  }

  public void setBulkUploadFileContentRowList(List<BulkUploadFileContentRowDetails> bulkUploadFileContentRowList) {
    this.bulkUploadFileContentRowList = bulkUploadFileContentRowList;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BulkUploadMigrationReportDetails bulkUploadMigrationReportDetails = (BulkUploadMigrationReportDetails) o;
    return Objects.equals(this.migrationStartedTime, bulkUploadMigrationReportDetails.migrationStartedTime) &&
        Objects.equals(this.migrationEndTime, bulkUploadMigrationReportDetails.migrationEndTime) &&
        Objects.equals(this.totalUserCount, bulkUploadMigrationReportDetails.totalUserCount) &&
        Objects.equals(this.totalOrganisationCount, bulkUploadMigrationReportDetails.totalOrganisationCount) &&
        Objects.equals(this.processedUserCount, bulkUploadMigrationReportDetails.processedUserCount) &&
        Objects.equals(this.failedUserCount, bulkUploadMigrationReportDetails.failedUserCount) &&
        Objects.equals(this.bulkUploadFileContentRowList, bulkUploadMigrationReportDetails.bulkUploadFileContentRowList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(migrationStartedTime, migrationEndTime, totalUserCount, totalOrganisationCount, processedUserCount, failedUserCount, bulkUploadFileContentRowList);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BulkUploadMigrationReportDetails {\n");
    
    sb.append("    migrationStartedTime: ").append(toIndentedString(migrationStartedTime)).append("\n");
    sb.append("    migrationEndTime: ").append(toIndentedString(migrationEndTime)).append("\n");
    sb.append("    totalUserCount: ").append(toIndentedString(totalUserCount)).append("\n");
    sb.append("    totalOrganisationCount: ").append(toIndentedString(totalOrganisationCount)).append("\n");
    sb.append("    processedUserCount: ").append(toIndentedString(processedUserCount)).append("\n");
    sb.append("    failedUserCount: ").append(toIndentedString(failedUserCount)).append("\n");
    sb.append("    bulkUploadFileContentRowList: ").append(toIndentedString(bulkUploadFileContentRowList)).append("\n");
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