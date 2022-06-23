package uk.gov.ccs.swagger.dataMigration.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.List;
import uk.gov.ccs.swagger.dataMigration.model.OrgRoles;
import uk.gov.ccs.swagger.dataMigration.model.Status;
import uk.gov.ccs.swagger.dataMigration.model.UserMin;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Summary
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class Summary {

  @JsonProperty("identifier-id")
  private String identifierId;

  @JsonProperty("scheme-id")
  private String schemeId;

  @JsonProperty("rightToBuy")
  private Boolean rightToBuy;

  @JsonProperty("orgRoles")
  @Valid
  private List<OrgRoles> orgRoles = null;

  @JsonProperty("user")
  @Valid
  private List<UserMin> user = null;

  @JsonProperty("Status")
  @Valid
  private List<Status> status = null;

  public Summary identifierId(String identifierId) {
    this.identifierId = identifierId;
    return this;
  }

  /**
   * Identifier ID
   * @return identifierId
  */
  
  @Schema(name = "identifier-id", example = "100009655", description = "Identifier ID", required = false)
  public String getIdentifierId() {
    return identifierId;
  }

  public void setIdentifierId(String identifierId) {
    this.identifierId = identifierId;
  }

  public Summary schemeId(String schemeId) {
    this.schemeId = schemeId;
    return this;
  }

  /**
   * Scheme ID (GB-COH, US-DUNS, SF-URN, SF-ID)
   * @return schemeId
  */
  
  @Schema(name = "scheme-id", example = "GB-COH", description = "Scheme ID (GB-COH, US-DUNS, SF-URN, SF-ID)", required = false)
  public String getSchemeId() {
    return schemeId;
  }

  public void setSchemeId(String schemeId) {
    this.schemeId = schemeId;
  }

  public Summary rightToBuy(Boolean rightToBuy) {
    this.rightToBuy = rightToBuy;
    return this;
  }

  /**
   * Buyer status
   * @return rightToBuy
  */
  
  @Schema(name = "rightToBuy", example = "true", description = "Buyer status", required = false)
  public Boolean getRightToBuy() {
    return rightToBuy;
  }

  public void setRightToBuy(Boolean rightToBuy) {
    this.rightToBuy = rightToBuy;
  }

  public Summary orgRoles(List<OrgRoles> orgRoles) {
    this.orgRoles = orgRoles;
    return this;
  }

  public Summary addOrgRolesItem(OrgRoles orgRolesItem) {
    if (this.orgRoles == null) {
      this.orgRoles = new ArrayList<>();
    }
    this.orgRoles.add(orgRolesItem);
    return this;
  }

  /**
   * Get orgRoles
   * @return orgRoles
  */
  @Valid 
  @Schema(name = "orgRoles", required = false)
  public List<OrgRoles> getOrgRoles() {
    return orgRoles;
  }

  public void setOrgRoles(List<OrgRoles> orgRoles) {
    this.orgRoles = orgRoles;
  }

  public Summary user(List<UserMin> user) {
    this.user = user;
    return this;
  }

  public Summary addUserItem(UserMin userItem) {
    if (this.user == null) {
      this.user = new ArrayList<>();
    }
    this.user.add(userItem);
    return this;
  }

  /**
   * Get user
   * @return user
  */
  @Valid 
  @Schema(name = "user", required = false)
  public List<UserMin> getUser() {
    return user;
  }

  public void setUser(List<UserMin> user) {
    this.user = user;
  }

  public Summary status(List<Status> status) {
    this.status = status;
    return this;
  }

  public Summary addStatusItem(Status statusItem) {
    if (this.status == null) {
      this.status = new ArrayList<>();
    }
    this.status.add(statusItem);
    return this;
  }

  /**
   * Get status
   * @return status
  */
  @Valid 
  @Schema(name = "Status", required = false)
  public List<Status> getStatus() {
    return status;
  }

  public void setStatus(List<Status> status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Summary summary = (Summary) o;
    return Objects.equals(this.identifierId, summary.identifierId) &&
        Objects.equals(this.schemeId, summary.schemeId) &&
        Objects.equals(this.rightToBuy, summary.rightToBuy) &&
        Objects.equals(this.orgRoles, summary.orgRoles) &&
        Objects.equals(this.user, summary.user) &&
        Objects.equals(this.status, summary.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identifierId, schemeId, rightToBuy, orgRoles, user, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Summary {\n");
    sb.append("    identifierId: ").append(toIndentedString(identifierId)).append("\n");
    sb.append("    schemeId: ").append(toIndentedString(schemeId)).append("\n");
    sb.append("    rightToBuy: ").append(toIndentedString(rightToBuy)).append("\n");
    sb.append("    orgRoles: ").append(toIndentedString(orgRoles)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

