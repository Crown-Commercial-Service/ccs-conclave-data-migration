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
import uk.gov.ccs.swagger.sso.model.MemberTypes;
import uk.gov.ccs.swagger.sso.model.MethodInfo;
import uk.gov.ccs.swagger.sso.model.Module;
import uk.gov.ccs.swagger.sso.model.PropertyAttributes;
import uk.gov.ccs.swagger.sso.model.Type;
/**
 * PropertyInfo
 */


public class PropertyInfo {
  @SerializedName("name")
  private String name = null;

  @SerializedName("declaringType")
  private Type declaringType = null;

  @SerializedName("reflectedType")
  private Type reflectedType = null;

  @SerializedName("module")
  private Module module = null;

  @SerializedName("customAttributes")
  private List<CustomAttributeData> customAttributes = null;

  @SerializedName("isCollectible")
  private Boolean isCollectible = null;

  @SerializedName("metadataToken")
  private Integer metadataToken = null;

  @SerializedName("memberType")
  private MemberTypes memberType = null;

  @SerializedName("propertyType")
  private Type propertyType = null;

  @SerializedName("attributes")
  private PropertyAttributes attributes = null;

  @SerializedName("isSpecialName")
  private Boolean isSpecialName = null;

  @SerializedName("canRead")
  private Boolean canRead = null;

  @SerializedName("canWrite")
  private Boolean canWrite = null;

  @SerializedName("getMethod")
  private MethodInfo getMethod = null;

  @SerializedName("setMethod")
  private MethodInfo setMethod = null;

   /**
   * Get name
   * @return name
  **/
  @Schema(description = "")
  public String getName() {
    return name;
  }

  public PropertyInfo declaringType(Type declaringType) {
    this.declaringType = declaringType;
    return this;
  }

   /**
   * Get declaringType
   * @return declaringType
  **/
  @Schema(description = "")
  public Type getDeclaringType() {
    return declaringType;
  }

  public void setDeclaringType(Type declaringType) {
    this.declaringType = declaringType;
  }

  public PropertyInfo reflectedType(Type reflectedType) {
    this.reflectedType = reflectedType;
    return this;
  }

   /**
   * Get reflectedType
   * @return reflectedType
  **/
  @Schema(description = "")
  public Type getReflectedType() {
    return reflectedType;
  }

  public void setReflectedType(Type reflectedType) {
    this.reflectedType = reflectedType;
  }

  public PropertyInfo module(Module module) {
    this.module = module;
    return this;
  }

   /**
   * Get module
   * @return module
  **/
  @Schema(description = "")
  public Module getModule() {
    return module;
  }

  public void setModule(Module module) {
    this.module = module;
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
   * Get isCollectible
   * @return isCollectible
  **/
  @Schema(description = "")
  public Boolean isIsCollectible() {
    return isCollectible;
  }

   /**
   * Get metadataToken
   * @return metadataToken
  **/
  @Schema(description = "")
  public Integer getMetadataToken() {
    return metadataToken;
  }

  public PropertyInfo memberType(MemberTypes memberType) {
    this.memberType = memberType;
    return this;
  }

   /**
   * Get memberType
   * @return memberType
  **/
  @Schema(description = "")
  public MemberTypes getMemberType() {
    return memberType;
  }

  public void setMemberType(MemberTypes memberType) {
    this.memberType = memberType;
  }

  public PropertyInfo propertyType(Type propertyType) {
    this.propertyType = propertyType;
    return this;
  }

   /**
   * Get propertyType
   * @return propertyType
  **/
  @Schema(description = "")
  public Type getPropertyType() {
    return propertyType;
  }

  public void setPropertyType(Type propertyType) {
    this.propertyType = propertyType;
  }

  public PropertyInfo attributes(PropertyAttributes attributes) {
    this.attributes = attributes;
    return this;
  }

   /**
   * Get attributes
   * @return attributes
  **/
  @Schema(description = "")
  public PropertyAttributes getAttributes() {
    return attributes;
  }

  public void setAttributes(PropertyAttributes attributes) {
    this.attributes = attributes;
  }

   /**
   * Get isSpecialName
   * @return isSpecialName
  **/
  @Schema(description = "")
  public Boolean isIsSpecialName() {
    return isSpecialName;
  }

   /**
   * Get canRead
   * @return canRead
  **/
  @Schema(description = "")
  public Boolean isCanRead() {
    return canRead;
  }

   /**
   * Get canWrite
   * @return canWrite
  **/
  @Schema(description = "")
  public Boolean isCanWrite() {
    return canWrite;
  }

  public PropertyInfo getMethod(MethodInfo getMethod) {
    this.getMethod = getMethod;
    return this;
  }

   /**
   * Get getMethod
   * @return getMethod
  **/
  @Schema(description = "")
  public MethodInfo getGetMethod() {
    return getMethod;
  }

  public void setGetMethod(MethodInfo getMethod) {
    this.getMethod = getMethod;
  }

  public PropertyInfo setMethod(MethodInfo setMethod) {
    this.setMethod = setMethod;
    return this;
  }

   /**
   * Get setMethod
   * @return setMethod
  **/
  @Schema(description = "")
  public MethodInfo getSetMethod() {
    return setMethod;
  }

  public void setSetMethod(MethodInfo setMethod) {
    this.setMethod = setMethod;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PropertyInfo propertyInfo = (PropertyInfo) o;
    return Objects.equals(this.name, propertyInfo.name) &&
        Objects.equals(this.declaringType, propertyInfo.declaringType) &&
        Objects.equals(this.reflectedType, propertyInfo.reflectedType) &&
        Objects.equals(this.module, propertyInfo.module) &&
        Objects.equals(this.customAttributes, propertyInfo.customAttributes) &&
        Objects.equals(this.isCollectible, propertyInfo.isCollectible) &&
        Objects.equals(this.metadataToken, propertyInfo.metadataToken) &&
        Objects.equals(this.memberType, propertyInfo.memberType) &&
        Objects.equals(this.propertyType, propertyInfo.propertyType) &&
        Objects.equals(this.attributes, propertyInfo.attributes) &&
        Objects.equals(this.isSpecialName, propertyInfo.isSpecialName) &&
        Objects.equals(this.canRead, propertyInfo.canRead) &&
        Objects.equals(this.canWrite, propertyInfo.canWrite) &&
        Objects.equals(this.getMethod, propertyInfo.getMethod) &&
        Objects.equals(this.setMethod, propertyInfo.setMethod);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, declaringType, reflectedType, module, customAttributes, isCollectible, metadataToken, memberType, propertyType, attributes, isSpecialName, canRead, canWrite, getMethod, setMethod);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PropertyInfo {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    declaringType: ").append(toIndentedString(declaringType)).append("\n");
    sb.append("    reflectedType: ").append(toIndentedString(reflectedType)).append("\n");
    sb.append("    module: ").append(toIndentedString(module)).append("\n");
    sb.append("    customAttributes: ").append(toIndentedString(customAttributes)).append("\n");
    sb.append("    isCollectible: ").append(toIndentedString(isCollectible)).append("\n");
    sb.append("    metadataToken: ").append(toIndentedString(metadataToken)).append("\n");
    sb.append("    memberType: ").append(toIndentedString(memberType)).append("\n");
    sb.append("    propertyType: ").append(toIndentedString(propertyType)).append("\n");
    sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
    sb.append("    isSpecialName: ").append(toIndentedString(isSpecialName)).append("\n");
    sb.append("    canRead: ").append(toIndentedString(canRead)).append("\n");
    sb.append("    canWrite: ").append(toIndentedString(canWrite)).append("\n");
    sb.append("    getMethod: ").append(toIndentedString(getMethod)).append("\n");
    sb.append("    setMethod: ").append(toIndentedString(setMethod)).append("\n");
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
