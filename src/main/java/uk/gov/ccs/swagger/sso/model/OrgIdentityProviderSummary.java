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
import uk.gov.ccs.swagger.sso.model.OrgIdentityProvider;
/**
 * OrgIdentityProviderSummary
 */


public class OrgIdentityProviderSummary {
  @SerializedName("ciiOrganisationId")
  private String ciiOrganisationId = null;

  @SerializedName("changedOrgIdentityProviders")
  private List<OrgIdentityProvider> changedOrgIdentityProviders = null;

  public OrgIdentityProviderSummary ciiOrganisationId(String ciiOrganisationId) {
    this.ciiOrganisationId = ciiOrganisationId;
    return this;
  }

   /**
   * Get ciiOrganisationId
   * @return ciiOrganisationId
  **/
  @Schema(description = "")
  public String getCiiOrganisationId() {
    return ciiOrganisationId;
  }

  public void setCiiOrganisationId(String ciiOrganisationId) {
    this.ciiOrganisationId = ciiOrganisationId;
  }

  public OrgIdentityProviderSummary changedOrgIdentityProviders(List<OrgIdentityProvider> changedOrgIdentityProviders) {
    this.changedOrgIdentityProviders = changedOrgIdentityProviders;
    return this;
  }

  public OrgIdentityProviderSummary addChangedOrgIdentityProvidersItem(OrgIdentityProvider changedOrgIdentityProvidersItem) {
    if (this.changedOrgIdentityProviders == null) {
      this.changedOrgIdentityProviders = new ArrayList<OrgIdentityProvider>();
    }
    this.changedOrgIdentityProviders.add(changedOrgIdentityProvidersItem);
    return this;
  }

   /**
   * Get changedOrgIdentityProviders
   * @return changedOrgIdentityProviders
  **/
  @Schema(description = "")
  public List<OrgIdentityProvider> getChangedOrgIdentityProviders() {
    return changedOrgIdentityProviders;
  }

  public void setChangedOrgIdentityProviders(List<OrgIdentityProvider> changedOrgIdentityProviders) {
    this.changedOrgIdentityProviders = changedOrgIdentityProviders;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrgIdentityProviderSummary orgIdentityProviderSummary = (OrgIdentityProviderSummary) o;
    return Objects.equals(this.ciiOrganisationId, orgIdentityProviderSummary.ciiOrganisationId) &&
        Objects.equals(this.changedOrgIdentityProviders, orgIdentityProviderSummary.changedOrgIdentityProviders);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ciiOrganisationId, changedOrgIdentityProviders);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrgIdentityProviderSummary {\n");
    
    sb.append("    ciiOrganisationId: ").append(toIndentedString(ciiOrganisationId)).append("\n");
    sb.append("    changedOrgIdentityProviders: ").append(toIndentedString(changedOrgIdentityProviders)).append("\n");
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
