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
import uk.gov.ccs.swagger.sso.model.CiiDto;
/**
 * OrganisationRegistrationDto
 */


public class OrganisationRegistrationDto {
  @SerializedName("ciiDetails")
  private CiiDto ciiDetails = null;

  @SerializedName("rightToBuy")
  private Boolean rightToBuy = null;

  @SerializedName("businessType")
  private String businessType = null;

  @SerializedName("supplierBuyerType")
  private Integer supplierBuyerType = null;

  @SerializedName("adminUserName")
  private String adminUserName = null;

  @SerializedName("adminUserFirstName")
  private String adminUserFirstName = null;

  @SerializedName("adminUserLastName")
  private String adminUserLastName = null;

  public OrganisationRegistrationDto ciiDetails(CiiDto ciiDetails) {
    this.ciiDetails = ciiDetails;
    return this;
  }

   /**
   * Get ciiDetails
   * @return ciiDetails
  **/
  @Schema(description = "")
  public CiiDto getCiiDetails() {
    return ciiDetails;
  }

  public void setCiiDetails(CiiDto ciiDetails) {
    this.ciiDetails = ciiDetails;
  }

  public OrganisationRegistrationDto rightToBuy(Boolean rightToBuy) {
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

  public OrganisationRegistrationDto businessType(String businessType) {
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

  public OrganisationRegistrationDto supplierBuyerType(Integer supplierBuyerType) {
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

  public OrganisationRegistrationDto adminUserName(String adminUserName) {
    this.adminUserName = adminUserName;
    return this;
  }

   /**
   * Get adminUserName
   * @return adminUserName
  **/
  @Schema(description = "")
  public String getAdminUserName() {
    return adminUserName;
  }

  public void setAdminUserName(String adminUserName) {
    this.adminUserName = adminUserName;
  }

  public OrganisationRegistrationDto adminUserFirstName(String adminUserFirstName) {
    this.adminUserFirstName = adminUserFirstName;
    return this;
  }

   /**
   * Get adminUserFirstName
   * @return adminUserFirstName
  **/
  @Schema(description = "")
  public String getAdminUserFirstName() {
    return adminUserFirstName;
  }

  public void setAdminUserFirstName(String adminUserFirstName) {
    this.adminUserFirstName = adminUserFirstName;
  }

  public OrganisationRegistrationDto adminUserLastName(String adminUserLastName) {
    this.adminUserLastName = adminUserLastName;
    return this;
  }

   /**
   * Get adminUserLastName
   * @return adminUserLastName
  **/
  @Schema(description = "")
  public String getAdminUserLastName() {
    return adminUserLastName;
  }

  public void setAdminUserLastName(String adminUserLastName) {
    this.adminUserLastName = adminUserLastName;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrganisationRegistrationDto organisationRegistrationDto = (OrganisationRegistrationDto) o;
    return Objects.equals(this.ciiDetails, organisationRegistrationDto.ciiDetails) &&
        Objects.equals(this.rightToBuy, organisationRegistrationDto.rightToBuy) &&
        Objects.equals(this.businessType, organisationRegistrationDto.businessType) &&
        Objects.equals(this.supplierBuyerType, organisationRegistrationDto.supplierBuyerType) &&
        Objects.equals(this.adminUserName, organisationRegistrationDto.adminUserName) &&
        Objects.equals(this.adminUserFirstName, organisationRegistrationDto.adminUserFirstName) &&
        Objects.equals(this.adminUserLastName, organisationRegistrationDto.adminUserLastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ciiDetails, rightToBuy, businessType, supplierBuyerType, adminUserName, adminUserFirstName, adminUserLastName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrganisationRegistrationDto {\n");
    
    sb.append("    ciiDetails: ").append(toIndentedString(ciiDetails)).append("\n");
    sb.append("    rightToBuy: ").append(toIndentedString(rightToBuy)).append("\n");
    sb.append("    businessType: ").append(toIndentedString(businessType)).append("\n");
    sb.append("    supplierBuyerType: ").append(toIndentedString(supplierBuyerType)).append("\n");
    sb.append("    adminUserName: ").append(toIndentedString(adminUserName)).append("\n");
    sb.append("    adminUserFirstName: ").append(toIndentedString(adminUserFirstName)).append("\n");
    sb.append("    adminUserLastName: ").append(toIndentedString(adminUserLastName)).append("\n");
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
