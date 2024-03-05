package uk.gov.ccs.swagger.dataMigration.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Summary
 */
@Validated


public class Summary   {
  @JsonProperty("identifier-id")
  private String identifierId = null;

  @JsonProperty("scheme-id")
  private String schemeId = null;

  @JsonProperty("organisationType")
  private String organisationType = null;

  @JsonProperty("orgRoles")
  @Valid
  private List<OrgRole> orgRoles = null;

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

  public String getOrganisationType() {
    return organisationType;
  }

  public void setOrganisationType(String organisationType) {
    this.organisationType = organisationType;
  }

  /**
   * Identifier ID
   * @return identifierId
   **/
  @Schema(example = "100009655", description = "Identifier ID")
  
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
   **/
  @Schema(example = "GB-COH", description = "Scheme ID (GB-COH, US-DUNS, SF-URN, SF-ID)")
  
    public String getSchemeId() {
    return schemeId;
  }

  public void setSchemeId(String schemeId) {
    this.schemeId = schemeId;
  }




  public Summary orgRoles(List<OrgRole> orgRoles) {
    this.orgRoles = orgRoles;
    return this;
  }

  public Summary addOrgRolesItem(OrgRole orgRolesItem) {
    if (this.orgRoles == null) {
      this.orgRoles = new ArrayList<OrgRole>();
    }
    this.orgRoles.add(orgRolesItem);
    return this;
  }

  /**
   * Get orgRoles
   * @return orgRoles
   **/
  @Schema(description = "")
      @Valid
    public List<OrgRole> getOrgRoles() {
    return orgRoles;
  }

  public void setOrgRoles(List<OrgRole> orgRoles) {
    this.orgRoles = orgRoles;
  }

  public Summary user(List<UserMin> user) {
    this.user = user;
    return this;
  }

  public Summary addUserItem(UserMin userItem) {
    if (this.user == null) {
      this.user = new ArrayList<UserMin>();
    }
    this.user.add(userItem);
    return this;
  }

  /**
   * Get user
   * @return user
   **/
  @Schema(description = "")
      @Valid
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
      this.status = new ArrayList<Status>();
    }
    this.status.add(statusItem);
    return this;
  }

  /**
   * Get status
   * @return status
   **/
  @Schema(description = "")
      @Valid
    public List<Status> getStatus() {
    return status;
  }

  public void setStatus(List<Status> status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Summary summary = (Summary) o;
    return Objects.equals(this.identifierId, summary.identifierId) &&
        Objects.equals(this.schemeId, summary.schemeId) &&
        Objects.equals(this.organisationType, summary.organisationType) &&
        Objects.equals(this.orgRoles, summary.orgRoles) &&
        Objects.equals(this.user, summary.user) &&
        Objects.equals(this.status, summary.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identifierId, schemeId, organisationType, orgRoles, user, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Summary {\n");
    
    sb.append("    identifierId: ").append(toIndentedString(identifierId)).append("\n");
    sb.append("    schemeId: ").append(toIndentedString(schemeId)).append("\n");
    sb.append("    organisationType: ").append(toIndentedString(organisationType)).append("\n");
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
