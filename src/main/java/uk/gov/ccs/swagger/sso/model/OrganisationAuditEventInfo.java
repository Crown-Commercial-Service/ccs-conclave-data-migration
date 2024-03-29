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
/**
 * OrganisationAuditEventInfo
 */


public class OrganisationAuditEventInfo {
  @SerializedName("organisationId")
  private String organisationId = null;

  @SerializedName("schemeIdentifier")
  private String schemeIdentifier = null;

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

  @SerializedName("roles")
  private String roles = null;

  public OrganisationAuditEventInfo organisationId(String organisationId) {
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

  public OrganisationAuditEventInfo schemeIdentifier(String schemeIdentifier) {
    this.schemeIdentifier = schemeIdentifier;
    return this;
  }

   /**
   * Get schemeIdentifier
   * @return schemeIdentifier
  **/
  @Schema(description = "")
  public String getSchemeIdentifier() {
    return schemeIdentifier;
  }

  public void setSchemeIdentifier(String schemeIdentifier) {
    this.schemeIdentifier = schemeIdentifier;
  }

  public OrganisationAuditEventInfo firstName(String firstName) {
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

  public OrganisationAuditEventInfo lastName(String lastName) {
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

  public OrganisationAuditEventInfo groupId(UUID groupId) {
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

  public OrganisationAuditEventInfo actioned(String actioned) {
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

  public OrganisationAuditEventInfo actionedBy(String actionedBy) {
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

  public OrganisationAuditEventInfo event(String event) {
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

  public OrganisationAuditEventInfo roles(String roles) {
    this.roles = roles;
    return this;
  }

   /**
   * Get roles
   * @return roles
  **/
  @Schema(description = "")
  public String getRoles() {
    return roles;
  }

  public void setRoles(String roles) {
    this.roles = roles;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrganisationAuditEventInfo organisationAuditEventInfo = (OrganisationAuditEventInfo) o;
    return Objects.equals(this.organisationId, organisationAuditEventInfo.organisationId) &&
        Objects.equals(this.schemeIdentifier, organisationAuditEventInfo.schemeIdentifier) &&
        Objects.equals(this.firstName, organisationAuditEventInfo.firstName) &&
        Objects.equals(this.lastName, organisationAuditEventInfo.lastName) &&
        Objects.equals(this.groupId, organisationAuditEventInfo.groupId) &&
        Objects.equals(this.actioned, organisationAuditEventInfo.actioned) &&
        Objects.equals(this.actionedBy, organisationAuditEventInfo.actionedBy) &&
        Objects.equals(this.event, organisationAuditEventInfo.event) &&
        Objects.equals(this.roles, organisationAuditEventInfo.roles);
  }

  @Override
  public int hashCode() {
    return Objects.hash(organisationId, schemeIdentifier, firstName, lastName, groupId, actioned, actionedBy, event, roles);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrganisationAuditEventInfo {\n");
    
    sb.append("    organisationId: ").append(toIndentedString(organisationId)).append("\n");
    sb.append("    schemeIdentifier: ").append(toIndentedString(schemeIdentifier)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    groupId: ").append(toIndentedString(groupId)).append("\n");
    sb.append("    actioned: ").append(toIndentedString(actioned)).append("\n");
    sb.append("    actionedBy: ").append(toIndentedString(actionedBy)).append("\n");
    sb.append("    event: ").append(toIndentedString(event)).append("\n");
    sb.append("    roles: ").append(toIndentedString(roles)).append("\n");
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
