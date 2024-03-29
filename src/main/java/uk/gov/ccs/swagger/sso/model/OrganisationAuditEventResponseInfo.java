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
import java.util.UUID;
import org.threeten.bp.OffsetDateTime;
/**
 * OrganisationAuditEventResponseInfo
 */


public class OrganisationAuditEventResponseInfo {
  @SerializedName("organisationId")
  private String organisationId = null;

  @SerializedName("firstName")
  private String firstName = null;

  @SerializedName("lastName")
  private String lastName = null;

  @SerializedName("groupId")
  private UUID groupId = null;

  @SerializedName("actioned")
  private String actioned = null;

  @SerializedName("actionedBy")
  private String actionedBy = null;

  @SerializedName("event")
  private String event = null;

  @SerializedName("date")
  private OffsetDateTime date = null;

  @SerializedName("role")
  private String role = null;

  @SerializedName("roleKey")
  private String roleKey = null;

  @SerializedName("serviceName")
  private String serviceName = null;

  public OrganisationAuditEventResponseInfo organisationId(String organisationId) {
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

  public OrganisationAuditEventResponseInfo firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

   /**
   * Get firstName
   * @return firstName
  **/
  @Schema(description = "")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public OrganisationAuditEventResponseInfo lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

   /**
   * Get lastName
   * @return lastName
  **/
  @Schema(description = "")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public OrganisationAuditEventResponseInfo groupId(UUID groupId) {
    this.groupId = groupId;
    return this;
  }

   /**
   * Get groupId
   * @return groupId
  **/
  @Schema(description = "")
  public UUID getGroupId() {
    return groupId;
  }

  public void setGroupId(UUID groupId) {
    this.groupId = groupId;
  }

  public OrganisationAuditEventResponseInfo actioned(String actioned) {
    this.actioned = actioned;
    return this;
  }

   /**
   * Get actioned
   * @return actioned
  **/
  @Schema(description = "")
  public String getActioned() {
    return actioned;
  }

  public void setActioned(String actioned) {
    this.actioned = actioned;
  }

  public OrganisationAuditEventResponseInfo actionedBy(String actionedBy) {
    this.actionedBy = actionedBy;
    return this;
  }

   /**
   * Get actionedBy
   * @return actionedBy
  **/
  @Schema(description = "")
  public String getActionedBy() {
    return actionedBy;
  }

  public void setActionedBy(String actionedBy) {
    this.actionedBy = actionedBy;
  }

  public OrganisationAuditEventResponseInfo event(String event) {
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

  public OrganisationAuditEventResponseInfo date(OffsetDateTime date) {
    this.date = date;
    return this;
  }

   /**
   * Get date
   * @return date
  **/
  @Schema(description = "")
  public OffsetDateTime getDate() {
    return date;
  }

  public void setDate(OffsetDateTime date) {
    this.date = date;
  }

  public OrganisationAuditEventResponseInfo role(String role) {
    this.role = role;
    return this;
  }

   /**
   * Get role
   * @return role
  **/
  @Schema(description = "")
  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public OrganisationAuditEventResponseInfo roleKey(String roleKey) {
    this.roleKey = roleKey;
    return this;
  }

   /**
   * Get roleKey
   * @return roleKey
  **/
  @Schema(description = "")
  public String getRoleKey() {
    return roleKey;
  }

  public void setRoleKey(String roleKey) {
    this.roleKey = roleKey;
  }

  public OrganisationAuditEventResponseInfo serviceName(String serviceName) {
    this.serviceName = serviceName;
    return this;
  }

   /**
   * Get serviceName
   * @return serviceName
  **/
  @Schema(description = "")
  public String getServiceName() {
    return serviceName;
  }

  public void setServiceName(String serviceName) {
    this.serviceName = serviceName;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrganisationAuditEventResponseInfo organisationAuditEventResponseInfo = (OrganisationAuditEventResponseInfo) o;
    return Objects.equals(this.organisationId, organisationAuditEventResponseInfo.organisationId) &&
        Objects.equals(this.firstName, organisationAuditEventResponseInfo.firstName) &&
        Objects.equals(this.lastName, organisationAuditEventResponseInfo.lastName) &&
        Objects.equals(this.groupId, organisationAuditEventResponseInfo.groupId) &&
        Objects.equals(this.actioned, organisationAuditEventResponseInfo.actioned) &&
        Objects.equals(this.actionedBy, organisationAuditEventResponseInfo.actionedBy) &&
        Objects.equals(this.event, organisationAuditEventResponseInfo.event) &&
        Objects.equals(this.date, organisationAuditEventResponseInfo.date) &&
        Objects.equals(this.role, organisationAuditEventResponseInfo.role) &&
        Objects.equals(this.roleKey, organisationAuditEventResponseInfo.roleKey) &&
        Objects.equals(this.serviceName, organisationAuditEventResponseInfo.serviceName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(organisationId, firstName, lastName, groupId, actioned, actionedBy, event, date, role, roleKey, serviceName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrganisationAuditEventResponseInfo {\n");
    
    sb.append("    organisationId: ").append(toIndentedString(organisationId)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    groupId: ").append(toIndentedString(groupId)).append("\n");
    sb.append("    actioned: ").append(toIndentedString(actioned)).append("\n");
    sb.append("    actionedBy: ").append(toIndentedString(actionedBy)).append("\n");
    sb.append("    event: ").append(toIndentedString(event)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    roleKey: ").append(toIndentedString(roleKey)).append("\n");
    sb.append("    serviceName: ").append(toIndentedString(serviceName)).append("\n");
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
