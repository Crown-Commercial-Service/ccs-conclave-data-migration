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
import uk.gov.ccs.swagger.sso.model.CustomAttributeData;
import uk.gov.ccs.swagger.sso.model.MemberInfo;
import uk.gov.ccs.swagger.sso.model.ParameterAttributes;
import uk.gov.ccs.swagger.sso.model.Type;
/**
 * ParameterInfo
 */


public class ParameterInfo {
  @SerializedName("attributes")
  private ParameterAttributes attributes = null;

  @SerializedName("member")
  private MemberInfo member = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("parameterType")
  private Type parameterType = null;

  @SerializedName("position")
  private Integer position = null;

  @SerializedName("isIn")
  private Boolean isIn = null;

  @SerializedName("isLcid")
  private Boolean isLcid = null;

  @SerializedName("isOptional")
  private Boolean isOptional = null;

  @SerializedName("isOut")
  private Boolean isOut = null;

  @SerializedName("isRetval")
  private Boolean isRetval = null;

  @SerializedName("defaultValue")
  private Object defaultValue = null;

  @SerializedName("rawDefaultValue")
  private Object rawDefaultValue = null;

  @SerializedName("hasDefaultValue")
  private Boolean hasDefaultValue = null;

  @SerializedName("customAttributes")
  private List<CustomAttributeData> customAttributes = null;

  @SerializedName("metadataToken")
  private Integer metadataToken = null;

  public ParameterInfo attributes(ParameterAttributes attributes) {
    this.attributes = attributes;
    return this;
  }

   /**
   * Get attributes
   * @return attributes
  **/
  @Schema(description = "")
  public ParameterAttributes getAttributes() {
    return attributes;
  }

  public void setAttributes(ParameterAttributes attributes) {
    this.attributes = attributes;
  }

  public ParameterInfo member(MemberInfo member) {
    this.member = member;
    return this;
  }

   /**
   * Get member
   * @return member
  **/
  @Schema(description = "")
  public MemberInfo getMember() {
    return member;
  }

  public void setMember(MemberInfo member) {
    this.member = member;
  }

   /**
   * Get name
   * @return name
  **/
  @Schema(description = "")
  public String getName() {
    return name;
  }

  public ParameterInfo parameterType(Type parameterType) {
    this.parameterType = parameterType;
    return this;
  }

   /**
   * Get parameterType
   * @return parameterType
  **/
  @Schema(description = "")
  public Type getParameterType() {
    return parameterType;
  }

  public void setParameterType(Type parameterType) {
    this.parameterType = parameterType;
  }

   /**
   * Get position
   * @return position
  **/
  @Schema(description = "")
  public Integer getPosition() {
    return position;
  }

   /**
   * Get isIn
   * @return isIn
  **/
  @Schema(description = "")
  public Boolean isIsIn() {
    return isIn;
  }

   /**
   * Get isLcid
   * @return isLcid
  **/
  @Schema(description = "")
  public Boolean isIsLcid() {
    return isLcid;
  }

   /**
   * Get isOptional
   * @return isOptional
  **/
  @Schema(description = "")
  public Boolean isIsOptional() {
    return isOptional;
  }

   /**
   * Get isOut
   * @return isOut
  **/
  @Schema(description = "")
  public Boolean isIsOut() {
    return isOut;
  }

   /**
   * Get isRetval
   * @return isRetval
  **/
  @Schema(description = "")
  public Boolean isIsRetval() {
    return isRetval;
  }

   /**
   * Get defaultValue
   * @return defaultValue
  **/
  @Schema(description = "")
  public Object getDefaultValue() {
    return defaultValue;
  }

   /**
   * Get rawDefaultValue
   * @return rawDefaultValue
  **/
  @Schema(description = "")
  public Object getRawDefaultValue() {
    return rawDefaultValue;
  }

   /**
   * Get hasDefaultValue
   * @return hasDefaultValue
  **/
  @Schema(description = "")
  public Boolean isHasDefaultValue() {
    return hasDefaultValue;
  }

   /**
   * Get customAttributes
   * @return customAttributes
  **/
  @Schema(description = "")
  public List<CustomAttributeData> getCustomAttributes() {
    return customAttributes;
  }

   /**
   * Get metadataToken
   * @return metadataToken
  **/
  @Schema(description = "")
  public Integer getMetadataToken() {
    return metadataToken;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ParameterInfo parameterInfo = (ParameterInfo) o;
    return Objects.equals(this.attributes, parameterInfo.attributes) &&
        Objects.equals(this.member, parameterInfo.member) &&
        Objects.equals(this.name, parameterInfo.name) &&
        Objects.equals(this.parameterType, parameterInfo.parameterType) &&
        Objects.equals(this.position, parameterInfo.position) &&
        Objects.equals(this.isIn, parameterInfo.isIn) &&
        Objects.equals(this.isLcid, parameterInfo.isLcid) &&
        Objects.equals(this.isOptional, parameterInfo.isOptional) &&
        Objects.equals(this.isOut, parameterInfo.isOut) &&
        Objects.equals(this.isRetval, parameterInfo.isRetval) &&
        Objects.equals(this.defaultValue, parameterInfo.defaultValue) &&
        Objects.equals(this.rawDefaultValue, parameterInfo.rawDefaultValue) &&
        Objects.equals(this.hasDefaultValue, parameterInfo.hasDefaultValue) &&
        Objects.equals(this.customAttributes, parameterInfo.customAttributes) &&
        Objects.equals(this.metadataToken, parameterInfo.metadataToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attributes, member, name, parameterType, position, isIn, isLcid, isOptional, isOut, isRetval, defaultValue, rawDefaultValue, hasDefaultValue, customAttributes, metadataToken);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ParameterInfo {\n");
    
    sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
    sb.append("    member: ").append(toIndentedString(member)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    parameterType: ").append(toIndentedString(parameterType)).append("\n");
    sb.append("    position: ").append(toIndentedString(position)).append("\n");
    sb.append("    isIn: ").append(toIndentedString(isIn)).append("\n");
    sb.append("    isLcid: ").append(toIndentedString(isLcid)).append("\n");
    sb.append("    isOptional: ").append(toIndentedString(isOptional)).append("\n");
    sb.append("    isOut: ").append(toIndentedString(isOut)).append("\n");
    sb.append("    isRetval: ").append(toIndentedString(isRetval)).append("\n");
    sb.append("    defaultValue: ").append(toIndentedString(defaultValue)).append("\n");
    sb.append("    rawDefaultValue: ").append(toIndentedString(rawDefaultValue)).append("\n");
    sb.append("    hasDefaultValue: ").append(toIndentedString(hasDefaultValue)).append("\n");
    sb.append("    customAttributes: ").append(toIndentedString(customAttributes)).append("\n");
    sb.append("    metadataToken: ").append(toIndentedString(metadataToken)).append("\n");
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
