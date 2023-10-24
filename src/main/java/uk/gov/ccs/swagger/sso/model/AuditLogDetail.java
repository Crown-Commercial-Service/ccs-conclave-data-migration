/*
 * CcsSso.ContactApi
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
 * AuditLogDetail
 */


public class AuditLogDetail {
  @SerializedName("id")
  private Integer id = null;

  @SerializedName("event")
  private String event = null;

  @SerializedName("userId")
  private Integer userId = null;

  @SerializedName("userName")
  private String userName = null;

  @SerializedName("application")
  private String application = null;

  @SerializedName("referenceData")
  private String referenceData = null;

  @SerializedName("ipAddress")
  private String ipAddress = null;

  @SerializedName("device")
  private String device = null;

  @SerializedName("eventTimeUtc")
  private OffsetDateTime eventTimeUtc = null;

  public AuditLogDetail id(Integer id) {
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

  public AuditLogDetail event(String event) {
    this.event = event;
    return this;
  }

   /**
   * Get event
   * @return event
  **/
  @Schema(description = "")
  public String getEvent() {
    return event;
  }

  public void setEvent(String event) {
    this.event = event;
  }

  public AuditLogDetail userId(Integer userId) {
    this.userId = userId;
    return this;
  }

   /**
   * Get userId
   * @return userId
  **/
  @Schema(description = "")
  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public AuditLogDetail userName(String userName) {
    this.userName = userName;
    return this;
  }

   /**
   * Get userName
   * @return userName
  **/
  @Schema(description = "")
  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public AuditLogDetail application(String application) {
    this.application = application;
    return this;
  }

   /**
   * Get application
   * @return application
  **/
  @Schema(description = "")
  public String getApplication() {
    return application;
  }

  public void setApplication(String application) {
    this.application = application;
  }

  public AuditLogDetail referenceData(String referenceData) {
    this.referenceData = referenceData;
    return this;
  }

   /**
   * Get referenceData
   * @return referenceData
  **/
  @Schema(description = "")
  public String getReferenceData() {
    return referenceData;
  }

  public void setReferenceData(String referenceData) {
    this.referenceData = referenceData;
  }

  public AuditLogDetail ipAddress(String ipAddress) {
    this.ipAddress = ipAddress;
    return this;
  }

   /**
   * Get ipAddress
   * @return ipAddress
  **/
  @Schema(description = "")
  public String getIpAddress() {
    return ipAddress;
  }

  public void setIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
  }

  public AuditLogDetail device(String device) {
    this.device = device;
    return this;
  }

   /**
   * Get device
   * @return device
  **/
  @Schema(description = "")
  public String getDevice() {
    return device;
  }

  public void setDevice(String device) {
    this.device = device;
  }

  public AuditLogDetail eventTimeUtc(OffsetDateTime eventTimeUtc) {
    this.eventTimeUtc = eventTimeUtc;
    return this;
  }

   /**
   * Get eventTimeUtc
   * @return eventTimeUtc
  **/
  @Schema(description = "")
  public OffsetDateTime getEventTimeUtc() {
    return eventTimeUtc;
  }

  public void setEventTimeUtc(OffsetDateTime eventTimeUtc) {
    this.eventTimeUtc = eventTimeUtc;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuditLogDetail auditLogDetail = (AuditLogDetail) o;
    return Objects.equals(this.id, auditLogDetail.id) &&
        Objects.equals(this.event, auditLogDetail.event) &&
        Objects.equals(this.userId, auditLogDetail.userId) &&
        Objects.equals(this.userName, auditLogDetail.userName) &&
        Objects.equals(this.application, auditLogDetail.application) &&
        Objects.equals(this.referenceData, auditLogDetail.referenceData) &&
        Objects.equals(this.ipAddress, auditLogDetail.ipAddress) &&
        Objects.equals(this.device, auditLogDetail.device) &&
        Objects.equals(this.eventTimeUtc, auditLogDetail.eventTimeUtc);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, event, userId, userName, application, referenceData, ipAddress, device, eventTimeUtc);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuditLogDetail {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    event: ").append(toIndentedString(event)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
    sb.append("    application: ").append(toIndentedString(application)).append("\n");
    sb.append("    referenceData: ").append(toIndentedString(referenceData)).append("\n");
    sb.append("    ipAddress: ").append(toIndentedString(ipAddress)).append("\n");
    sb.append("    device: ").append(toIndentedString(device)).append("\n");
    sb.append("    eventTimeUtc: ").append(toIndentedString(eventTimeUtc)).append("\n");
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