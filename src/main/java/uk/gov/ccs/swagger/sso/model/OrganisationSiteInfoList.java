/*
 * CcsSso.WrapperApi
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
import uk.gov.ccs.swagger.sso.model.OrganisationSite;
/**
 * OrganisationSiteInfoList
 */


public class OrganisationSiteInfoList {
  @SerializedName("organisationId")
  private String organisationId = null;

  @SerializedName("sites")
  private List<OrganisationSite> sites = null;

  public OrganisationSiteInfoList organisationId(String organisationId) {
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

  public OrganisationSiteInfoList sites(List<OrganisationSite> sites) {
    this.sites = sites;
    return this;
  }

  public OrganisationSiteInfoList addSitesItem(OrganisationSite sitesItem) {
    if (this.sites == null) {
      this.sites = new ArrayList<OrganisationSite>();
    }
    this.sites.add(sitesItem);
    return this;
  }

   /**
   * Get sites
   * @return sites
  **/
  @Schema(description = "")
  public List<OrganisationSite> getSites() {
    return sites;
  }

  public void setSites(List<OrganisationSite> sites) {
    this.sites = sites;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrganisationSiteInfoList organisationSiteInfoList = (OrganisationSiteInfoList) o;
    return Objects.equals(this.organisationId, organisationSiteInfoList.organisationId) &&
        Objects.equals(this.sites, organisationSiteInfoList.sites);
  }

  @Override
  public int hashCode() {
    return Objects.hash(organisationId, sites);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrganisationSiteInfoList {\n");
    
    sb.append("    organisationId: ").append(toIndentedString(organisationId)).append("\n");
    sb.append("    sites: ").append(toIndentedString(sites)).append("\n");
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
