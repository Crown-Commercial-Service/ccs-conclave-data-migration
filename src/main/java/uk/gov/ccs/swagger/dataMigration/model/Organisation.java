package uk.gov.ccs.swagger.dataMigration.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.List;
import uk.gov.ccs.swagger.dataMigration.model.OrgRoles;
import uk.gov.ccs.swagger.dataMigration.model.User;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Organisation
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class Organisation {

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
  private List<User> user = null;

  public Organisation identifierId(String identifierId) {
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

  public Organisation schemeId(String schemeId) {
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

  public Organisation rightToBuy(Boolean rightToBuy) {
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

  public Organisation orgRoles(List<OrgRoles> orgRoles) {
    this.orgRoles = orgRoles;
    return this;
  }

  public Organisation addOrgRolesItem(OrgRoles orgRolesItem) {
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

  public Organisation user(List<User> user) {
    this.user = user;
    return this;
  }

  public Organisation addUserItem(User userItem) {
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
  public List<User> getUser() {
    return user;
  }

  public void setUser(List<User> user) {
    this.user = user;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Organisation organisation = (Organisation) o;
    return Objects.equals(this.identifierId, organisation.identifierId) &&
        Objects.equals(this.schemeId, organisation.schemeId) &&
        Objects.equals(this.rightToBuy, organisation.rightToBuy) &&
        Objects.equals(this.orgRoles, organisation.orgRoles) &&
        Objects.equals(this.user, organisation.user);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identifierId, schemeId, rightToBuy, orgRoles, user);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Organisation {\n");
    sb.append("    identifierId: ").append(toIndentedString(identifierId)).append("\n");
    sb.append("    schemeId: ").append(toIndentedString(schemeId)).append("\n");
    sb.append("    rightToBuy: ").append(toIndentedString(rightToBuy)).append("\n");
    sb.append("    orgRoles: ").append(toIndentedString(orgRoles)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
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

