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
import uk.gov.ccs.swagger.sso.model.CallingConventions;
import uk.gov.ccs.swagger.sso.model.CustomAttributeData;
import uk.gov.ccs.swagger.sso.model.ICustomAttributeProvider;
import uk.gov.ccs.swagger.sso.model.MemberTypes;
import uk.gov.ccs.swagger.sso.model.MethodAttributes;
import uk.gov.ccs.swagger.sso.model.MethodImplAttributes;
import uk.gov.ccs.swagger.sso.model.Module;
import uk.gov.ccs.swagger.sso.model.ParameterInfo;
import uk.gov.ccs.swagger.sso.model.RuntimeMethodHandle;
import uk.gov.ccs.swagger.sso.model.Type;
/**
 * MethodInfo
 */


public class MethodInfo {
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

  @SerializedName("attributes")
  private MethodAttributes attributes = null;

  @SerializedName("methodImplementationFlags")
  private MethodImplAttributes methodImplementationFlags = null;

  @SerializedName("callingConvention")
  private CallingConventions callingConvention = null;

  @SerializedName("isAbstract")
  private Boolean isAbstract = null;

  @SerializedName("isConstructor")
  private Boolean isConstructor = null;

  @SerializedName("isFinal")
  private Boolean isFinal = null;

  @SerializedName("isHideBySig")
  private Boolean isHideBySig = null;

  @SerializedName("isSpecialName")
  private Boolean isSpecialName = null;

  @SerializedName("isStatic")
  private Boolean isStatic = null;

  @SerializedName("isVirtual")
  private Boolean isVirtual = null;

  @SerializedName("isAssembly")
  private Boolean isAssembly = null;

  @SerializedName("isFamily")
  private Boolean isFamily = null;

  @SerializedName("isFamilyAndAssembly")
  private Boolean isFamilyAndAssembly = null;

  @SerializedName("isFamilyOrAssembly")
  private Boolean isFamilyOrAssembly = null;

  @SerializedName("isPrivate")
  private Boolean isPrivate = null;

  @SerializedName("isPublic")
  private Boolean isPublic = null;

  @SerializedName("isConstructedGenericMethod")
  private Boolean isConstructedGenericMethod = null;

  @SerializedName("isGenericMethod")
  private Boolean isGenericMethod = null;

  @SerializedName("isGenericMethodDefinition")
  private Boolean isGenericMethodDefinition = null;

  @SerializedName("containsGenericParameters")
  private Boolean containsGenericParameters = null;

  @SerializedName("methodHandle")
  private RuntimeMethodHandle methodHandle = null;

  @SerializedName("isSecurityCritical")
  private Boolean isSecurityCritical = null;

  @SerializedName("isSecuritySafeCritical")
  private Boolean isSecuritySafeCritical = null;

  @SerializedName("isSecurityTransparent")
  private Boolean isSecurityTransparent = null;

  @SerializedName("memberType")
  private MemberTypes memberType = null;

  @SerializedName("returnParameter")
  private ParameterInfo returnParameter = null;

  @SerializedName("returnType")
  private Type returnType = null;

  @SerializedName("returnTypeCustomAttributes")
  private ICustomAttributeProvider returnTypeCustomAttributes = null;

   /**
   * Get name
   * @return name
  **/
  @Schema(description = "")
  public String getName() {
    return name;
  }

  public MethodInfo declaringType(Type declaringType) {
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

  public MethodInfo reflectedType(Type reflectedType) {
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

  public MethodInfo module(Module module) {
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

  public MethodInfo attributes(MethodAttributes attributes) {
    this.attributes = attributes;
    return this;
  }

   /**
   * Get attributes
   * @return attributes
  **/
  @Schema(description = "")
  public MethodAttributes getAttributes() {
    return attributes;
  }

  public void setAttributes(MethodAttributes attributes) {
    this.attributes = attributes;
  }

  public MethodInfo methodImplementationFlags(MethodImplAttributes methodImplementationFlags) {
    this.methodImplementationFlags = methodImplementationFlags;
    return this;
  }

   /**
   * Get methodImplementationFlags
   * @return methodImplementationFlags
  **/
  @Schema(description = "")
  public MethodImplAttributes getMethodImplementationFlags() {
    return methodImplementationFlags;
  }

  public void setMethodImplementationFlags(MethodImplAttributes methodImplementationFlags) {
    this.methodImplementationFlags = methodImplementationFlags;
  }

  public MethodInfo callingConvention(CallingConventions callingConvention) {
    this.callingConvention = callingConvention;
    return this;
  }

   /**
   * Get callingConvention
   * @return callingConvention
  **/
  @Schema(description = "")
  public CallingConventions getCallingConvention() {
    return callingConvention;
  }

  public void setCallingConvention(CallingConventions callingConvention) {
    this.callingConvention = callingConvention;
  }

   /**
   * Get isAbstract
   * @return isAbstract
  **/
  @Schema(description = "")
  public Boolean isIsAbstract() {
    return isAbstract;
  }

   /**
   * Get isConstructor
   * @return isConstructor
  **/
  @Schema(description = "")
  public Boolean isIsConstructor() {
    return isConstructor;
  }

   /**
   * Get isFinal
   * @return isFinal
  **/
  @Schema(description = "")
  public Boolean isIsFinal() {
    return isFinal;
  }

   /**
   * Get isHideBySig
   * @return isHideBySig
  **/
  @Schema(description = "")
  public Boolean isIsHideBySig() {
    return isHideBySig;
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
   * Get isStatic
   * @return isStatic
  **/
  @Schema(description = "")
  public Boolean isIsStatic() {
    return isStatic;
  }

   /**
   * Get isVirtual
   * @return isVirtual
  **/
  @Schema(description = "")
  public Boolean isIsVirtual() {
    return isVirtual;
  }

   /**
   * Get isAssembly
   * @return isAssembly
  **/
  @Schema(description = "")
  public Boolean isIsAssembly() {
    return isAssembly;
  }

   /**
   * Get isFamily
   * @return isFamily
  **/
  @Schema(description = "")
  public Boolean isIsFamily() {
    return isFamily;
  }

   /**
   * Get isFamilyAndAssembly
   * @return isFamilyAndAssembly
  **/
  @Schema(description = "")
  public Boolean isIsFamilyAndAssembly() {
    return isFamilyAndAssembly;
  }

   /**
   * Get isFamilyOrAssembly
   * @return isFamilyOrAssembly
  **/
  @Schema(description = "")
  public Boolean isIsFamilyOrAssembly() {
    return isFamilyOrAssembly;
  }

   /**
   * Get isPrivate
   * @return isPrivate
  **/
  @Schema(description = "")
  public Boolean isIsPrivate() {
    return isPrivate;
  }

   /**
   * Get isPublic
   * @return isPublic
  **/
  @Schema(description = "")
  public Boolean isIsPublic() {
    return isPublic;
  }

   /**
   * Get isConstructedGenericMethod
   * @return isConstructedGenericMethod
  **/
  @Schema(description = "")
  public Boolean isIsConstructedGenericMethod() {
    return isConstructedGenericMethod;
  }

   /**
   * Get isGenericMethod
   * @return isGenericMethod
  **/
  @Schema(description = "")
  public Boolean isIsGenericMethod() {
    return isGenericMethod;
  }

   /**
   * Get isGenericMethodDefinition
   * @return isGenericMethodDefinition
  **/
  @Schema(description = "")
  public Boolean isIsGenericMethodDefinition() {
    return isGenericMethodDefinition;
  }

   /**
   * Get containsGenericParameters
   * @return containsGenericParameters
  **/
  @Schema(description = "")
  public Boolean isContainsGenericParameters() {
    return containsGenericParameters;
  }

  public MethodInfo methodHandle(RuntimeMethodHandle methodHandle) {
    this.methodHandle = methodHandle;
    return this;
  }

   /**
   * Get methodHandle
   * @return methodHandle
  **/
  @Schema(description = "")
  public RuntimeMethodHandle getMethodHandle() {
    return methodHandle;
  }

  public void setMethodHandle(RuntimeMethodHandle methodHandle) {
    this.methodHandle = methodHandle;
  }

   /**
   * Get isSecurityCritical
   * @return isSecurityCritical
  **/
  @Schema(description = "")
  public Boolean isIsSecurityCritical() {
    return isSecurityCritical;
  }

   /**
   * Get isSecuritySafeCritical
   * @return isSecuritySafeCritical
  **/
  @Schema(description = "")
  public Boolean isIsSecuritySafeCritical() {
    return isSecuritySafeCritical;
  }

   /**
   * Get isSecurityTransparent
   * @return isSecurityTransparent
  **/
  @Schema(description = "")
  public Boolean isIsSecurityTransparent() {
    return isSecurityTransparent;
  }

  public MethodInfo memberType(MemberTypes memberType) {
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

  public MethodInfo returnParameter(ParameterInfo returnParameter) {
    this.returnParameter = returnParameter;
    return this;
  }

   /**
   * Get returnParameter
   * @return returnParameter
  **/
  @Schema(description = "")
  public ParameterInfo getReturnParameter() {
    return returnParameter;
  }

  public void setReturnParameter(ParameterInfo returnParameter) {
    this.returnParameter = returnParameter;
  }

  public MethodInfo returnType(Type returnType) {
    this.returnType = returnType;
    return this;
  }

   /**
   * Get returnType
   * @return returnType
  **/
  @Schema(description = "")
  public Type getReturnType() {
    return returnType;
  }

  public void setReturnType(Type returnType) {
    this.returnType = returnType;
  }

  public MethodInfo returnTypeCustomAttributes(ICustomAttributeProvider returnTypeCustomAttributes) {
    this.returnTypeCustomAttributes = returnTypeCustomAttributes;
    return this;
  }

   /**
   * Get returnTypeCustomAttributes
   * @return returnTypeCustomAttributes
  **/
  @Schema(description = "")
  public ICustomAttributeProvider getReturnTypeCustomAttributes() {
    return returnTypeCustomAttributes;
  }

  public void setReturnTypeCustomAttributes(ICustomAttributeProvider returnTypeCustomAttributes) {
    this.returnTypeCustomAttributes = returnTypeCustomAttributes;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MethodInfo methodInfo = (MethodInfo) o;
    return Objects.equals(this.name, methodInfo.name) &&
        Objects.equals(this.declaringType, methodInfo.declaringType) &&
        Objects.equals(this.reflectedType, methodInfo.reflectedType) &&
        Objects.equals(this.module, methodInfo.module) &&
        Objects.equals(this.customAttributes, methodInfo.customAttributes) &&
        Objects.equals(this.isCollectible, methodInfo.isCollectible) &&
        Objects.equals(this.metadataToken, methodInfo.metadataToken) &&
        Objects.equals(this.attributes, methodInfo.attributes) &&
        Objects.equals(this.methodImplementationFlags, methodInfo.methodImplementationFlags) &&
        Objects.equals(this.callingConvention, methodInfo.callingConvention) &&
        Objects.equals(this.isAbstract, methodInfo.isAbstract) &&
        Objects.equals(this.isConstructor, methodInfo.isConstructor) &&
        Objects.equals(this.isFinal, methodInfo.isFinal) &&
        Objects.equals(this.isHideBySig, methodInfo.isHideBySig) &&
        Objects.equals(this.isSpecialName, methodInfo.isSpecialName) &&
        Objects.equals(this.isStatic, methodInfo.isStatic) &&
        Objects.equals(this.isVirtual, methodInfo.isVirtual) &&
        Objects.equals(this.isAssembly, methodInfo.isAssembly) &&
        Objects.equals(this.isFamily, methodInfo.isFamily) &&
        Objects.equals(this.isFamilyAndAssembly, methodInfo.isFamilyAndAssembly) &&
        Objects.equals(this.isFamilyOrAssembly, methodInfo.isFamilyOrAssembly) &&
        Objects.equals(this.isPrivate, methodInfo.isPrivate) &&
        Objects.equals(this.isPublic, methodInfo.isPublic) &&
        Objects.equals(this.isConstructedGenericMethod, methodInfo.isConstructedGenericMethod) &&
        Objects.equals(this.isGenericMethod, methodInfo.isGenericMethod) &&
        Objects.equals(this.isGenericMethodDefinition, methodInfo.isGenericMethodDefinition) &&
        Objects.equals(this.containsGenericParameters, methodInfo.containsGenericParameters) &&
        Objects.equals(this.methodHandle, methodInfo.methodHandle) &&
        Objects.equals(this.isSecurityCritical, methodInfo.isSecurityCritical) &&
        Objects.equals(this.isSecuritySafeCritical, methodInfo.isSecuritySafeCritical) &&
        Objects.equals(this.isSecurityTransparent, methodInfo.isSecurityTransparent) &&
        Objects.equals(this.memberType, methodInfo.memberType) &&
        Objects.equals(this.returnParameter, methodInfo.returnParameter) &&
        Objects.equals(this.returnType, methodInfo.returnType) &&
        Objects.equals(this.returnTypeCustomAttributes, methodInfo.returnTypeCustomAttributes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, declaringType, reflectedType, module, customAttributes, isCollectible, metadataToken, attributes, methodImplementationFlags, callingConvention, isAbstract, isConstructor, isFinal, isHideBySig, isSpecialName, isStatic, isVirtual, isAssembly, isFamily, isFamilyAndAssembly, isFamilyOrAssembly, isPrivate, isPublic, isConstructedGenericMethod, isGenericMethod, isGenericMethodDefinition, containsGenericParameters, methodHandle, isSecurityCritical, isSecuritySafeCritical, isSecurityTransparent, memberType, returnParameter, returnType, returnTypeCustomAttributes);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MethodInfo {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    declaringType: ").append(toIndentedString(declaringType)).append("\n");
    sb.append("    reflectedType: ").append(toIndentedString(reflectedType)).append("\n");
    sb.append("    module: ").append(toIndentedString(module)).append("\n");
    sb.append("    customAttributes: ").append(toIndentedString(customAttributes)).append("\n");
    sb.append("    isCollectible: ").append(toIndentedString(isCollectible)).append("\n");
    sb.append("    metadataToken: ").append(toIndentedString(metadataToken)).append("\n");
    sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
    sb.append("    methodImplementationFlags: ").append(toIndentedString(methodImplementationFlags)).append("\n");
    sb.append("    callingConvention: ").append(toIndentedString(callingConvention)).append("\n");
    sb.append("    isAbstract: ").append(toIndentedString(isAbstract)).append("\n");
    sb.append("    isConstructor: ").append(toIndentedString(isConstructor)).append("\n");
    sb.append("    isFinal: ").append(toIndentedString(isFinal)).append("\n");
    sb.append("    isHideBySig: ").append(toIndentedString(isHideBySig)).append("\n");
    sb.append("    isSpecialName: ").append(toIndentedString(isSpecialName)).append("\n");
    sb.append("    isStatic: ").append(toIndentedString(isStatic)).append("\n");
    sb.append("    isVirtual: ").append(toIndentedString(isVirtual)).append("\n");
    sb.append("    isAssembly: ").append(toIndentedString(isAssembly)).append("\n");
    sb.append("    isFamily: ").append(toIndentedString(isFamily)).append("\n");
    sb.append("    isFamilyAndAssembly: ").append(toIndentedString(isFamilyAndAssembly)).append("\n");
    sb.append("    isFamilyOrAssembly: ").append(toIndentedString(isFamilyOrAssembly)).append("\n");
    sb.append("    isPrivate: ").append(toIndentedString(isPrivate)).append("\n");
    sb.append("    isPublic: ").append(toIndentedString(isPublic)).append("\n");
    sb.append("    isConstructedGenericMethod: ").append(toIndentedString(isConstructedGenericMethod)).append("\n");
    sb.append("    isGenericMethod: ").append(toIndentedString(isGenericMethod)).append("\n");
    sb.append("    isGenericMethodDefinition: ").append(toIndentedString(isGenericMethodDefinition)).append("\n");
    sb.append("    containsGenericParameters: ").append(toIndentedString(containsGenericParameters)).append("\n");
    sb.append("    methodHandle: ").append(toIndentedString(methodHandle)).append("\n");
    sb.append("    isSecurityCritical: ").append(toIndentedString(isSecurityCritical)).append("\n");
    sb.append("    isSecuritySafeCritical: ").append(toIndentedString(isSecuritySafeCritical)).append("\n");
    sb.append("    isSecurityTransparent: ").append(toIndentedString(isSecurityTransparent)).append("\n");
    sb.append("    memberType: ").append(toIndentedString(memberType)).append("\n");
    sb.append("    returnParameter: ").append(toIndentedString(returnParameter)).append("\n");
    sb.append("    returnType: ").append(toIndentedString(returnType)).append("\n");
    sb.append("    returnTypeCustomAttributes: ").append(toIndentedString(returnTypeCustomAttributes)).append("\n");
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