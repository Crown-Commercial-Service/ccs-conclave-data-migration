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
import uk.gov.ccs.swagger.sso.model.ContactResponseInfo;
import uk.gov.ccs.swagger.sso.model.SiteDetailInfo;
/**
 * OrganisationSiteContactInfoList
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-12-07T09:38:21.309374Z[Europe/London]")
public class OrganisationSiteContactInfoList {
  @SerializedName("detail")
  private SiteDetailInfo detail = null;

  @SerializedName("contactPoints")
  private List<ContactResponseInfo> contactPoints = null;

  public OrganisationSiteContactInfoList detail(SiteDetailInfo detail) {
    this.detail = detail;
    return this;
  }

   /**
   * Get detail
   * @return detail
  **/
  @Schema(description = "")
  public SiteDetailInfo getDetail() {
    return detail;
  }

  public void setDetail(SiteDetailInfo detail) {
    this.detail = detail;
  }

  public OrganisationSiteContactInfoList contactPoints(List<ContactResponseInfo> contactPoints) {
    this.contactPoints = contactPoints;
    return this;
  }

  public OrganisationSiteContactInfoList addContactPointsItem(ContactResponseInfo contactPointsItem) {
    if (this.contactPoints == null) {
      this.contactPoints = new ArrayList<ContactResponseInfo>();
    }
    this.contactPoints.add(contactPointsItem);
    return this;
  }

   /**
   * Get contactPoints
   * @return contactPoints
  **/
  @Schema(description = "")
  public List<ContactResponseInfo> getContactPoints() {
    return contactPoints;
  }

  public void setContactPoints(List<ContactResponseInfo> contactPoints) {
    this.contactPoints = contactPoints;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrganisationSiteContactInfoList organisationSiteContactInfoList = (OrganisationSiteContactInfoList) o;
    return Objects.equals(this.detail, organisationSiteContactInfoList.detail) &&
        Objects.equals(this.contactPoints, organisationSiteContactInfoList.contactPoints);
  }

  @Override
  public int hashCode() {
    return Objects.hash(detail, contactPoints);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrganisationSiteContactInfoList {\n");
    
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
    sb.append("    contactPoints: ").append(toIndentedString(contactPoints)).append("\n");
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
