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
/**
 * OrganisationDetail
 */


public class OrganisationDetail {
  @SerializedName("organisationId")
  private String organisationId = null;

  @SerializedName("creationDate")
  private String creationDate = null;

  @SerializedName("businessType")
  private String businessType = null;

  @SerializedName("supplierBuyerType")
  private Integer supplierBuyerType = null;

  @SerializedName("isSme")
  private Boolean isSme = null;

  @SerializedName("isVcse")
  private Boolean isVcse = null;

  @SerializedName("rightToBuy")
  private Boolean rightToBuy = null;

  @SerializedName("isActive")
  private Boolean isActive = null;

  @SerializedName("domainName")
  private String domainName = null;

  public OrganisationDetail organisationId(String organisationId) {
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

  public OrganisationDetail creationDate(String creationDate) {
    this.creationDate = creationDate;
    return this;
  }

   /**
   * Get creationDate
   * @return creationDate
  **/
  @Schema(description = "")
  public String getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(String creationDate) {
    this.creationDate = creationDate;
  }

  public OrganisationDetail businessType(String businessType) {
    this.businessType = businessType;
    return this;
  }

   /**
   * Get businessType
   * @return businessType
  **/
  @Schema(description = "")
  public String getBusinessType() {
    return businessType;
  }

  public void setBusinessType(String businessType) {
    this.businessType = businessType;
  }

  public OrganisationDetail supplierBuyerType(Integer supplierBuyerType) {
    this.supplierBuyerType = supplierBuyerType;
    return this;
  }

   /**
   * Get supplierBuyerType
   * @return supplierBuyerType
  **/
  @Schema(description = "")
  public Integer getSupplierBuyerType() {
    return supplierBuyerType;
  }

  public void setSupplierBuyerType(Integer supplierBuyerType) {
    this.supplierBuyerType = supplierBuyerType;
  }

  public OrganisationDetail isSme(Boolean isSme) {
    this.isSme = isSme;
    return this;
  }

   /**
   * Get isSme
   * @return isSme
  **/
  @Schema(description = "")
  public Boolean isIsSme() {
    return isSme;
  }

  public void setIsSme(Boolean isSme) {
    this.isSme = isSme;
  }

  public OrganisationDetail isVcse(Boolean isVcse) {
    this.isVcse = isVcse;
    return this;
  }

   /**
   * Get isVcse
   * @return isVcse
  **/
  @Schema(description = "")
  public Boolean isIsVcse() {
    return isVcse;
  }

  public void setIsVcse(Boolean isVcse) {
    this.isVcse = isVcse;
  }

  public OrganisationDetail rightToBuy(Boolean rightToBuy) {
    this.rightToBuy = rightToBuy;
    return this;
  }

   /**
   * Get rightToBuy
   * @return rightToBuy
  **/
  @Schema(description = "")
  public Boolean isRightToBuy() {
    return rightToBuy;
  }

  public void setRightToBuy(Boolean rightToBuy) {
    this.rightToBuy = rightToBuy;
  }

  public OrganisationDetail isActive(Boolean isActive) {
    this.isActive = isActive;
    return this;
  }

   /**
   * Get isActive
   * @return isActive
  **/
  @Schema(description = "")
  public Boolean isIsActive() {
    return isActive;
  }

  public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
  }

  public OrganisationDetail domainName(String domainName) {
    this.domainName = domainName;
    return this;
  }

   /**
   * Get domainName
   * @return domainName
  **/
  @Schema(description = "")
  public String getDomainName() {
    return domainName;
  }

  public void setDomainName(String domainName) {
    this.domainName = domainName;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrganisationDetail organisationDetail = (OrganisationDetail) o;
    return Objects.equals(this.organisationId, organisationDetail.organisationId) &&
        Objects.equals(this.creationDate, organisationDetail.creationDate) &&
        Objects.equals(this.businessType, organisationDetail.businessType) &&
        Objects.equals(this.supplierBuyerType, organisationDetail.supplierBuyerType) &&
        Objects.equals(this.isSme, organisationDetail.isSme) &&
        Objects.equals(this.isVcse, organisationDetail.isVcse) &&
        Objects.equals(this.rightToBuy, organisationDetail.rightToBuy) &&
        Objects.equals(this.isActive, organisationDetail.isActive) &&
        Objects.equals(this.domainName, organisationDetail.domainName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(organisationId, creationDate, businessType, supplierBuyerType, isSme, isVcse, rightToBuy, isActive, domainName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrganisationDetail {\n");
    
    sb.append("    organisationId: ").append(toIndentedString(organisationId)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    businessType: ").append(toIndentedString(businessType)).append("\n");
    sb.append("    supplierBuyerType: ").append(toIndentedString(supplierBuyerType)).append("\n");
    sb.append("    isSme: ").append(toIndentedString(isSme)).append("\n");
    sb.append("    isVcse: ").append(toIndentedString(isVcse)).append("\n");
    sb.append("    rightToBuy: ").append(toIndentedString(rightToBuy)).append("\n");
    sb.append("    isActive: ").append(toIndentedString(isActive)).append("\n");
    sb.append("    domainName: ").append(toIndentedString(domainName)).append("\n");
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
