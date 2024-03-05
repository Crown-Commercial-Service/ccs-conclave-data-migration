package uk.gov.ccs.swagger.dataMigration.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Organisation
 */
@Validated


public class Organisation   {
  @JsonProperty("identifier-id")
  private String identifierId = null;

  @JsonProperty("scheme-id")
  private String schemeId = null;

  @JsonProperty("domainName")
  private String domainName = null;

  @JsonProperty("organisationType")
  private String organisationType = null;

  @JsonProperty("orgRoles")
  @Valid
  private List<OrgRole> orgRoles = null;

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
   **/
  @Schema(example = "100009655", required = true, description = "Identifier ID")
      @NotNull

  @Size(min=1)   public String getIdentifierId() {
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
   **/
  @Schema(example = "GB-COH", required = true, description = "Scheme ID (GB-COH, US-DUNS, SF-URN, SF-ID)")
      @NotNull

  @Size(min=1)   public String getSchemeId() {
    return schemeId;
  }

  public void setSchemeId(String schemeId) {
    this.schemeId = schemeId;
  }

  public Organisation organisationType(String organisationType) {
    this.organisationType = organisationType;
    return this;
  }

  /**
   * domainName
   * @return domainName
   **/
  @Schema(example = "kier.com", required = true, description = "domainName")
  @NotNull

  @Size(min=1)   public String getDomainName() {
    return domainName;
  }

  public void setDomainName(String domainName) {
    this.domainName = domainName;
  }

  public Organisation domainName(String domainName) {
    this.domainName = domainName;
    return this;
  }

  /**
   * Buyer status
   * @return organisationType
   **/
  @Schema(example = "true", required = true, description = "Buyer status")
      @NotNull

  @Pattern(regexp="^[0-9]{0,2}$") @Size(min=1)   public String getOrganisationType() {
    return organisationType;
  }

  public void setOrganisationType(String organisationType) {
    this.organisationType = organisationType;
  }

  public Organisation orgRoles(List<OrgRole> orgRoles) {
    this.orgRoles = orgRoles;
    return this;
  }

  public Organisation addOrgRolesItem(OrgRole orgRolesItem) {
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

  public Organisation user(List<User> user) {
    this.user = user;
    return this;
  }

  public Organisation addUserItem(User userItem) {
    if (this.user == null) {
      this.user = new ArrayList<User>();
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
    public List<User> getUser() {
    return user;
  }

  public void setUser(List<User> user) {
    this.user = user;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Organisation organisation = (Organisation) o;
    return Objects.equals(this.identifierId, organisation.identifierId) &&
        Objects.equals(this.schemeId, organisation.schemeId) &&
        Objects.equals(this.organisationType, organisation.organisationType) &&
        Objects.equals(this.domainName, organisation.domainName) &&
        Objects.equals(this.orgRoles, organisation.orgRoles) &&
        Objects.equals(this.user, organisation.user);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identifierId, schemeId, domainName, organisationType, orgRoles, user);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Organisation {\n");
    
    sb.append("    identifierId: ").append(toIndentedString(identifierId)).append("\n");
    sb.append("    schemeId: ").append(toIndentedString(schemeId)).append("\n");
    sb.append("    domainName: ").append(toIndentedString(domainName)).append("\n");
    sb.append("    organisationType: ").append(toIndentedString(organisationType)).append("\n");
    sb.append("    orgRoles: ").append(toIndentedString(orgRoles)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
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
