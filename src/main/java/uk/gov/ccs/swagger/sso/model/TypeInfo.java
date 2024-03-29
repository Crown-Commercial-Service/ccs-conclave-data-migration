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
import java.util.UUID;
import uk.gov.ccs.swagger.sso.model.Assembly;
import uk.gov.ccs.swagger.sso.model.ConstructorInfo;
import uk.gov.ccs.swagger.sso.model.CustomAttributeData;
import uk.gov.ccs.swagger.sso.model.EventInfo;
import uk.gov.ccs.swagger.sso.model.FieldInfo;
import uk.gov.ccs.swagger.sso.model.GenericParameterAttributes;
import uk.gov.ccs.swagger.sso.model.MemberInfo;
import uk.gov.ccs.swagger.sso.model.MemberTypes;
import uk.gov.ccs.swagger.sso.model.MethodBase;
import uk.gov.ccs.swagger.sso.model.MethodInfo;
import uk.gov.ccs.swagger.sso.model.Module;
import uk.gov.ccs.swagger.sso.model.PropertyInfo;
import uk.gov.ccs.swagger.sso.model.RuntimeTypeHandle;
import uk.gov.ccs.swagger.sso.model.StructLayoutAttribute;
import uk.gov.ccs.swagger.sso.model.Type;
import uk.gov.ccs.swagger.sso.model.TypeAttributes;
import uk.gov.ccs.swagger.sso.model.TypeInfo;
/**
 * TypeInfo
 */


public class TypeInfo {
  @SerializedName("name")
  private String name = null;

  @SerializedName("customAttributes")
  private List<CustomAttributeData> customAttributes = null;

  @SerializedName("isCollectible")
  private Boolean isCollectible = null;

  @SerializedName("metadataToken")
  private Integer metadataToken = null;

  @SerializedName("isInterface")
  private Boolean isInterface = null;

  @SerializedName("memberType")
  private MemberTypes memberType = null;

  @SerializedName("namespace")
  private String namespace = null;

  @SerializedName("assemblyQualifiedName")
  private String assemblyQualifiedName = null;

  @SerializedName("fullName")
  private String fullName = null;

  @SerializedName("assembly")
  private Assembly assembly = null;

  @SerializedName("module")
  private Module module = null;

  @SerializedName("isNested")
  private Boolean isNested = null;

  @SerializedName("declaringType")
  private Type declaringType = null;

  @SerializedName("declaringMethod")
  private MethodBase declaringMethod = null;

  @SerializedName("reflectedType")
  private Type reflectedType = null;

  @SerializedName("underlyingSystemType")
  private Type underlyingSystemType = null;

  @SerializedName("isTypeDefinition")
  private Boolean isTypeDefinition = null;

  @SerializedName("isArray")
  private Boolean isArray = null;

  @SerializedName("isByRef")
  private Boolean isByRef = null;

  @SerializedName("isPointer")
  private Boolean isPointer = null;

  @SerializedName("isConstructedGenericType")
  private Boolean isConstructedGenericType = null;

  @SerializedName("isGenericParameter")
  private Boolean isGenericParameter = null;

  @SerializedName("isGenericTypeParameter")
  private Boolean isGenericTypeParameter = null;

  @SerializedName("isGenericMethodParameter")
  private Boolean isGenericMethodParameter = null;

  @SerializedName("isGenericType")
  private Boolean isGenericType = null;

  @SerializedName("isGenericTypeDefinition")
  private Boolean isGenericTypeDefinition = null;

  @SerializedName("isSZArray")
  private Boolean isSZArray = null;

  @SerializedName("isVariableBoundArray")
  private Boolean isVariableBoundArray = null;

  @SerializedName("isByRefLike")
  private Boolean isByRefLike = null;

  @SerializedName("hasElementType")
  private Boolean hasElementType = null;

  @SerializedName("genericTypeArguments")
  private List<Type> genericTypeArguments = null;

  @SerializedName("genericParameterPosition")
  private Integer genericParameterPosition = null;

  @SerializedName("genericParameterAttributes")
  private GenericParameterAttributes genericParameterAttributes = null;

  @SerializedName("attributes")
  private TypeAttributes attributes = null;

  @SerializedName("isAbstract")
  private Boolean isAbstract = null;

  @SerializedName("isImport")
  private Boolean isImport = null;

  @SerializedName("isSealed")
  private Boolean isSealed = null;

  @SerializedName("isSpecialName")
  private Boolean isSpecialName = null;

  @SerializedName("isClass")
  private Boolean isClass = null;

  @SerializedName("isNestedAssembly")
  private Boolean isNestedAssembly = null;

  @SerializedName("isNestedFamANDAssem")
  private Boolean isNestedFamANDAssem = null;

  @SerializedName("isNestedFamily")
  private Boolean isNestedFamily = null;

  @SerializedName("isNestedFamORAssem")
  private Boolean isNestedFamORAssem = null;

  @SerializedName("isNestedPrivate")
  private Boolean isNestedPrivate = null;

  @SerializedName("isNestedPublic")
  private Boolean isNestedPublic = null;

  @SerializedName("isNotPublic")
  private Boolean isNotPublic = null;

  @SerializedName("isPublic")
  private Boolean isPublic = null;

  @SerializedName("isAutoLayout")
  private Boolean isAutoLayout = null;

  @SerializedName("isExplicitLayout")
  private Boolean isExplicitLayout = null;

  @SerializedName("isLayoutSequential")
  private Boolean isLayoutSequential = null;

  @SerializedName("isAnsiClass")
  private Boolean isAnsiClass = null;

  @SerializedName("isAutoClass")
  private Boolean isAutoClass = null;

  @SerializedName("isUnicodeClass")
  private Boolean isUnicodeClass = null;

  @SerializedName("isCOMObject")
  private Boolean isCOMObject = null;

  @SerializedName("isContextful")
  private Boolean isContextful = null;

  @SerializedName("isEnum")
  private Boolean isEnum = null;

  @SerializedName("isMarshalByRef")
  private Boolean isMarshalByRef = null;

  @SerializedName("isPrimitive")
  private Boolean isPrimitive = null;

  @SerializedName("isValueType")
  private Boolean isValueType = null;

  @SerializedName("isSignatureType")
  private Boolean isSignatureType = null;

  @SerializedName("isSecurityCritical")
  private Boolean isSecurityCritical = null;

  @SerializedName("isSecuritySafeCritical")
  private Boolean isSecuritySafeCritical = null;

  @SerializedName("isSecurityTransparent")
  private Boolean isSecurityTransparent = null;

  @SerializedName("structLayoutAttribute")
  private StructLayoutAttribute structLayoutAttribute = null;

  @SerializedName("typeInitializer")
  private ConstructorInfo typeInitializer = null;

  @SerializedName("typeHandle")
  private RuntimeTypeHandle typeHandle = null;

  @SerializedName("guid")
  private UUID guid = null;

  @SerializedName("baseType")
  private Type baseType = null;

  @SerializedName("isSerializable")
  private Boolean isSerializable = null;

  @SerializedName("containsGenericParameters")
  private Boolean containsGenericParameters = null;

  @SerializedName("isVisible")
  private Boolean isVisible = null;

  @SerializedName("genericTypeParameters")
  private List<Type> genericTypeParameters = null;

  @SerializedName("declaredConstructors")
  private List<ConstructorInfo> declaredConstructors = null;

  @SerializedName("declaredEvents")
  private List<EventInfo> declaredEvents = null;

  @SerializedName("declaredFields")
  private List<FieldInfo> declaredFields = null;

  @SerializedName("declaredMembers")
  private List<MemberInfo> declaredMembers = null;

  @SerializedName("declaredMethods")
  private List<MethodInfo> declaredMethods = null;

  @SerializedName("declaredNestedTypes")
  private List<TypeInfo> declaredNestedTypes = null;

  @SerializedName("declaredProperties")
  private List<PropertyInfo> declaredProperties = null;

  @SerializedName("implementedInterfaces")
  private List<Type> implementedInterfaces = null;

   /**
   * Get name
   * @return name
  **/
  @Schema(description = "")
  public String getName() {
    return name;
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

   /**
   * Get isInterface
   * @return isInterface
  **/
  @Schema(description = "")
  public Boolean isIsInterface() {
    return isInterface;
  }

  public TypeInfo memberType(MemberTypes memberType) {
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

   /**
   * Get namespace
   * @return namespace
  **/
  @Schema(description = "")
  public String getNamespace() {
    return namespace;
  }

   /**
   * Get assemblyQualifiedName
   * @return assemblyQualifiedName
  **/
  @Schema(description = "")
  public String getAssemblyQualifiedName() {
    return assemblyQualifiedName;
  }

   /**
   * Get fullName
   * @return fullName
  **/
  @Schema(description = "")
  public String getFullName() {
    return fullName;
  }

  public TypeInfo assembly(Assembly assembly) {
    this.assembly = assembly;
    return this;
  }

   /**
   * Get assembly
   * @return assembly
  **/
  @Schema(description = "")
  public Assembly getAssembly() {
    return assembly;
  }

  public void setAssembly(Assembly assembly) {
    this.assembly = assembly;
  }

  public TypeInfo module(Module module) {
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
   * Get isNested
   * @return isNested
  **/
  @Schema(description = "")
  public Boolean isIsNested() {
    return isNested;
  }

  public TypeInfo declaringType(Type declaringType) {
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

  public TypeInfo declaringMethod(MethodBase declaringMethod) {
    this.declaringMethod = declaringMethod;
    return this;
  }

   /**
   * Get declaringMethod
   * @return declaringMethod
  **/
  @Schema(description = "")
  public MethodBase getDeclaringMethod() {
    return declaringMethod;
  }

  public void setDeclaringMethod(MethodBase declaringMethod) {
    this.declaringMethod = declaringMethod;
  }

  public TypeInfo reflectedType(Type reflectedType) {
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

  public TypeInfo underlyingSystemType(Type underlyingSystemType) {
    this.underlyingSystemType = underlyingSystemType;
    return this;
  }

   /**
   * Get underlyingSystemType
   * @return underlyingSystemType
  **/
  @Schema(description = "")
  public Type getUnderlyingSystemType() {
    return underlyingSystemType;
  }

  public void setUnderlyingSystemType(Type underlyingSystemType) {
    this.underlyingSystemType = underlyingSystemType;
  }

   /**
   * Get isTypeDefinition
   * @return isTypeDefinition
  **/
  @Schema(description = "")
  public Boolean isIsTypeDefinition() {
    return isTypeDefinition;
  }

   /**
   * Get isArray
   * @return isArray
  **/
  @Schema(description = "")
  public Boolean isIsArray() {
    return isArray;
  }

   /**
   * Get isByRef
   * @return isByRef
  **/
  @Schema(description = "")
  public Boolean isIsByRef() {
    return isByRef;
  }

   /**
   * Get isPointer
   * @return isPointer
  **/
  @Schema(description = "")
  public Boolean isIsPointer() {
    return isPointer;
  }

   /**
   * Get isConstructedGenericType
   * @return isConstructedGenericType
  **/
  @Schema(description = "")
  public Boolean isIsConstructedGenericType() {
    return isConstructedGenericType;
  }

   /**
   * Get isGenericParameter
   * @return isGenericParameter
  **/
  @Schema(description = "")
  public Boolean isIsGenericParameter() {
    return isGenericParameter;
  }

   /**
   * Get isGenericTypeParameter
   * @return isGenericTypeParameter
  **/
  @Schema(description = "")
  public Boolean isIsGenericTypeParameter() {
    return isGenericTypeParameter;
  }

   /**
   * Get isGenericMethodParameter
   * @return isGenericMethodParameter
  **/
  @Schema(description = "")
  public Boolean isIsGenericMethodParameter() {
    return isGenericMethodParameter;
  }

   /**
   * Get isGenericType
   * @return isGenericType
  **/
  @Schema(description = "")
  public Boolean isIsGenericType() {
    return isGenericType;
  }

   /**
   * Get isGenericTypeDefinition
   * @return isGenericTypeDefinition
  **/
  @Schema(description = "")
  public Boolean isIsGenericTypeDefinition() {
    return isGenericTypeDefinition;
  }

   /**
   * Get isSZArray
   * @return isSZArray
  **/
  @Schema(description = "")
  public Boolean isIsSZArray() {
    return isSZArray;
  }

   /**
   * Get isVariableBoundArray
   * @return isVariableBoundArray
  **/
  @Schema(description = "")
  public Boolean isIsVariableBoundArray() {
    return isVariableBoundArray;
  }

   /**
   * Get isByRefLike
   * @return isByRefLike
  **/
  @Schema(description = "")
  public Boolean isIsByRefLike() {
    return isByRefLike;
  }

   /**
   * Get hasElementType
   * @return hasElementType
  **/
  @Schema(description = "")
  public Boolean isHasElementType() {
    return hasElementType;
  }

   /**
   * Get genericTypeArguments
   * @return genericTypeArguments
  **/
  @Schema(description = "")
  public List<Type> getGenericTypeArguments() {
    return genericTypeArguments;
  }

   /**
   * Get genericParameterPosition
   * @return genericParameterPosition
  **/
  @Schema(description = "")
  public Integer getGenericParameterPosition() {
    return genericParameterPosition;
  }

  public TypeInfo genericParameterAttributes(GenericParameterAttributes genericParameterAttributes) {
    this.genericParameterAttributes = genericParameterAttributes;
    return this;
  }

   /**
   * Get genericParameterAttributes
   * @return genericParameterAttributes
  **/
  @Schema(description = "")
  public GenericParameterAttributes getGenericParameterAttributes() {
    return genericParameterAttributes;
  }

  public void setGenericParameterAttributes(GenericParameterAttributes genericParameterAttributes) {
    this.genericParameterAttributes = genericParameterAttributes;
  }

  public TypeInfo attributes(TypeAttributes attributes) {
    this.attributes = attributes;
    return this;
  }

   /**
   * Get attributes
   * @return attributes
  **/
  @Schema(description = "")
  public TypeAttributes getAttributes() {
    return attributes;
  }

  public void setAttributes(TypeAttributes attributes) {
    this.attributes = attributes;
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
   * Get isImport
   * @return isImport
  **/
  @Schema(description = "")
  public Boolean isIsImport() {
    return isImport;
  }

   /**
   * Get isSealed
   * @return isSealed
  **/
  @Schema(description = "")
  public Boolean isIsSealed() {
    return isSealed;
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
   * Get isClass
   * @return isClass
  **/
  @Schema(description = "")
  public Boolean isIsClass() {
    return isClass;
  }

   /**
   * Get isNestedAssembly
   * @return isNestedAssembly
  **/
  @Schema(description = "")
  public Boolean isIsNestedAssembly() {
    return isNestedAssembly;
  }

   /**
   * Get isNestedFamANDAssem
   * @return isNestedFamANDAssem
  **/
  @Schema(description = "")
  public Boolean isIsNestedFamANDAssem() {
    return isNestedFamANDAssem;
  }

   /**
   * Get isNestedFamily
   * @return isNestedFamily
  **/
  @Schema(description = "")
  public Boolean isIsNestedFamily() {
    return isNestedFamily;
  }

   /**
   * Get isNestedFamORAssem
   * @return isNestedFamORAssem
  **/
  @Schema(description = "")
  public Boolean isIsNestedFamORAssem() {
    return isNestedFamORAssem;
  }

   /**
   * Get isNestedPrivate
   * @return isNestedPrivate
  **/
  @Schema(description = "")
  public Boolean isIsNestedPrivate() {
    return isNestedPrivate;
  }

   /**
   * Get isNestedPublic
   * @return isNestedPublic
  **/
  @Schema(description = "")
  public Boolean isIsNestedPublic() {
    return isNestedPublic;
  }

   /**
   * Get isNotPublic
   * @return isNotPublic
  **/
  @Schema(description = "")
  public Boolean isIsNotPublic() {
    return isNotPublic;
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
   * Get isAutoLayout
   * @return isAutoLayout
  **/
  @Schema(description = "")
  public Boolean isIsAutoLayout() {
    return isAutoLayout;
  }

   /**
   * Get isExplicitLayout
   * @return isExplicitLayout
  **/
  @Schema(description = "")
  public Boolean isIsExplicitLayout() {
    return isExplicitLayout;
  }

   /**
   * Get isLayoutSequential
   * @return isLayoutSequential
  **/
  @Schema(description = "")
  public Boolean isIsLayoutSequential() {
    return isLayoutSequential;
  }

   /**
   * Get isAnsiClass
   * @return isAnsiClass
  **/
  @Schema(description = "")
  public Boolean isIsAnsiClass() {
    return isAnsiClass;
  }

   /**
   * Get isAutoClass
   * @return isAutoClass
  **/
  @Schema(description = "")
  public Boolean isIsAutoClass() {
    return isAutoClass;
  }

   /**
   * Get isUnicodeClass
   * @return isUnicodeClass
  **/
  @Schema(description = "")
  public Boolean isIsUnicodeClass() {
    return isUnicodeClass;
  }

   /**
   * Get isCOMObject
   * @return isCOMObject
  **/
  @Schema(description = "")
  public Boolean isIsCOMObject() {
    return isCOMObject;
  }

   /**
   * Get isContextful
   * @return isContextful
  **/
  @Schema(description = "")
  public Boolean isIsContextful() {
    return isContextful;
  }

   /**
   * Get isEnum
   * @return isEnum
  **/
  @Schema(description = "")
  public Boolean isIsEnum() {
    return isEnum;
  }

   /**
   * Get isMarshalByRef
   * @return isMarshalByRef
  **/
  @Schema(description = "")
  public Boolean isIsMarshalByRef() {
    return isMarshalByRef;
  }

   /**
   * Get isPrimitive
   * @return isPrimitive
  **/
  @Schema(description = "")
  public Boolean isIsPrimitive() {
    return isPrimitive;
  }

   /**
   * Get isValueType
   * @return isValueType
  **/
  @Schema(description = "")
  public Boolean isIsValueType() {
    return isValueType;
  }

   /**
   * Get isSignatureType
   * @return isSignatureType
  **/
  @Schema(description = "")
  public Boolean isIsSignatureType() {
    return isSignatureType;
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

  public TypeInfo structLayoutAttribute(StructLayoutAttribute structLayoutAttribute) {
    this.structLayoutAttribute = structLayoutAttribute;
    return this;
  }

   /**
   * Get structLayoutAttribute
   * @return structLayoutAttribute
  **/
  @Schema(description = "")
  public StructLayoutAttribute getStructLayoutAttribute() {
    return structLayoutAttribute;
  }

  public void setStructLayoutAttribute(StructLayoutAttribute structLayoutAttribute) {
    this.structLayoutAttribute = structLayoutAttribute;
  }

  public TypeInfo typeInitializer(ConstructorInfo typeInitializer) {
    this.typeInitializer = typeInitializer;
    return this;
  }

   /**
   * Get typeInitializer
   * @return typeInitializer
  **/
  @Schema(description = "")
  public ConstructorInfo getTypeInitializer() {
    return typeInitializer;
  }

  public void setTypeInitializer(ConstructorInfo typeInitializer) {
    this.typeInitializer = typeInitializer;
  }

  public TypeInfo typeHandle(RuntimeTypeHandle typeHandle) {
    this.typeHandle = typeHandle;
    return this;
  }

   /**
   * Get typeHandle
   * @return typeHandle
  **/
  @Schema(description = "")
  public RuntimeTypeHandle getTypeHandle() {
    return typeHandle;
  }

  public void setTypeHandle(RuntimeTypeHandle typeHandle) {
    this.typeHandle = typeHandle;
  }

   /**
   * Get guid
   * @return guid
  **/
  @Schema(description = "")
  public UUID getGuid() {
    return guid;
  }

  public TypeInfo baseType(Type baseType) {
    this.baseType = baseType;
    return this;
  }

   /**
   * Get baseType
   * @return baseType
  **/
  @Schema(description = "")
  public Type getBaseType() {
    return baseType;
  }

  public void setBaseType(Type baseType) {
    this.baseType = baseType;
  }

   /**
   * Get isSerializable
   * @return isSerializable
  **/
  @Schema(description = "")
  public Boolean isIsSerializable() {
    return isSerializable;
  }

   /**
   * Get containsGenericParameters
   * @return containsGenericParameters
  **/
  @Schema(description = "")
  public Boolean isContainsGenericParameters() {
    return containsGenericParameters;
  }

   /**
   * Get isVisible
   * @return isVisible
  **/
  @Schema(description = "")
  public Boolean isIsVisible() {
    return isVisible;
  }

   /**
   * Get genericTypeParameters
   * @return genericTypeParameters
  **/
  @Schema(description = "")
  public List<Type> getGenericTypeParameters() {
    return genericTypeParameters;
  }

   /**
   * Get declaredConstructors
   * @return declaredConstructors
  **/
  @Schema(description = "")
  public List<ConstructorInfo> getDeclaredConstructors() {
    return declaredConstructors;
  }

   /**
   * Get declaredEvents
   * @return declaredEvents
  **/
  @Schema(description = "")
  public List<EventInfo> getDeclaredEvents() {
    return declaredEvents;
  }

   /**
   * Get declaredFields
   * @return declaredFields
  **/
  @Schema(description = "")
  public List<FieldInfo> getDeclaredFields() {
    return declaredFields;
  }

   /**
   * Get declaredMembers
   * @return declaredMembers
  **/
  @Schema(description = "")
  public List<MemberInfo> getDeclaredMembers() {
    return declaredMembers;
  }

   /**
   * Get declaredMethods
   * @return declaredMethods
  **/
  @Schema(description = "")
  public List<MethodInfo> getDeclaredMethods() {
    return declaredMethods;
  }

   /**
   * Get declaredNestedTypes
   * @return declaredNestedTypes
  **/
  @Schema(description = "")
  public List<TypeInfo> getDeclaredNestedTypes() {
    return declaredNestedTypes;
  }

   /**
   * Get declaredProperties
   * @return declaredProperties
  **/
  @Schema(description = "")
  public List<PropertyInfo> getDeclaredProperties() {
    return declaredProperties;
  }

   /**
   * Get implementedInterfaces
   * @return implementedInterfaces
  **/
  @Schema(description = "")
  public List<Type> getImplementedInterfaces() {
    return implementedInterfaces;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TypeInfo typeInfo = (TypeInfo) o;
    return Objects.equals(this.name, typeInfo.name) &&
        Objects.equals(this.customAttributes, typeInfo.customAttributes) &&
        Objects.equals(this.isCollectible, typeInfo.isCollectible) &&
        Objects.equals(this.metadataToken, typeInfo.metadataToken) &&
        Objects.equals(this.isInterface, typeInfo.isInterface) &&
        Objects.equals(this.memberType, typeInfo.memberType) &&
        Objects.equals(this.namespace, typeInfo.namespace) &&
        Objects.equals(this.assemblyQualifiedName, typeInfo.assemblyQualifiedName) &&
        Objects.equals(this.fullName, typeInfo.fullName) &&
        Objects.equals(this.assembly, typeInfo.assembly) &&
        Objects.equals(this.module, typeInfo.module) &&
        Objects.equals(this.isNested, typeInfo.isNested) &&
        Objects.equals(this.declaringType, typeInfo.declaringType) &&
        Objects.equals(this.declaringMethod, typeInfo.declaringMethod) &&
        Objects.equals(this.reflectedType, typeInfo.reflectedType) &&
        Objects.equals(this.underlyingSystemType, typeInfo.underlyingSystemType) &&
        Objects.equals(this.isTypeDefinition, typeInfo.isTypeDefinition) &&
        Objects.equals(this.isArray, typeInfo.isArray) &&
        Objects.equals(this.isByRef, typeInfo.isByRef) &&
        Objects.equals(this.isPointer, typeInfo.isPointer) &&
        Objects.equals(this.isConstructedGenericType, typeInfo.isConstructedGenericType) &&
        Objects.equals(this.isGenericParameter, typeInfo.isGenericParameter) &&
        Objects.equals(this.isGenericTypeParameter, typeInfo.isGenericTypeParameter) &&
        Objects.equals(this.isGenericMethodParameter, typeInfo.isGenericMethodParameter) &&
        Objects.equals(this.isGenericType, typeInfo.isGenericType) &&
        Objects.equals(this.isGenericTypeDefinition, typeInfo.isGenericTypeDefinition) &&
        Objects.equals(this.isSZArray, typeInfo.isSZArray) &&
        Objects.equals(this.isVariableBoundArray, typeInfo.isVariableBoundArray) &&
        Objects.equals(this.isByRefLike, typeInfo.isByRefLike) &&
        Objects.equals(this.hasElementType, typeInfo.hasElementType) &&
        Objects.equals(this.genericTypeArguments, typeInfo.genericTypeArguments) &&
        Objects.equals(this.genericParameterPosition, typeInfo.genericParameterPosition) &&
        Objects.equals(this.genericParameterAttributes, typeInfo.genericParameterAttributes) &&
        Objects.equals(this.attributes, typeInfo.attributes) &&
        Objects.equals(this.isAbstract, typeInfo.isAbstract) &&
        Objects.equals(this.isImport, typeInfo.isImport) &&
        Objects.equals(this.isSealed, typeInfo.isSealed) &&
        Objects.equals(this.isSpecialName, typeInfo.isSpecialName) &&
        Objects.equals(this.isClass, typeInfo.isClass) &&
        Objects.equals(this.isNestedAssembly, typeInfo.isNestedAssembly) &&
        Objects.equals(this.isNestedFamANDAssem, typeInfo.isNestedFamANDAssem) &&
        Objects.equals(this.isNestedFamily, typeInfo.isNestedFamily) &&
        Objects.equals(this.isNestedFamORAssem, typeInfo.isNestedFamORAssem) &&
        Objects.equals(this.isNestedPrivate, typeInfo.isNestedPrivate) &&
        Objects.equals(this.isNestedPublic, typeInfo.isNestedPublic) &&
        Objects.equals(this.isNotPublic, typeInfo.isNotPublic) &&
        Objects.equals(this.isPublic, typeInfo.isPublic) &&
        Objects.equals(this.isAutoLayout, typeInfo.isAutoLayout) &&
        Objects.equals(this.isExplicitLayout, typeInfo.isExplicitLayout) &&
        Objects.equals(this.isLayoutSequential, typeInfo.isLayoutSequential) &&
        Objects.equals(this.isAnsiClass, typeInfo.isAnsiClass) &&
        Objects.equals(this.isAutoClass, typeInfo.isAutoClass) &&
        Objects.equals(this.isUnicodeClass, typeInfo.isUnicodeClass) &&
        Objects.equals(this.isCOMObject, typeInfo.isCOMObject) &&
        Objects.equals(this.isContextful, typeInfo.isContextful) &&
        Objects.equals(this.isEnum, typeInfo.isEnum) &&
        Objects.equals(this.isMarshalByRef, typeInfo.isMarshalByRef) &&
        Objects.equals(this.isPrimitive, typeInfo.isPrimitive) &&
        Objects.equals(this.isValueType, typeInfo.isValueType) &&
        Objects.equals(this.isSignatureType, typeInfo.isSignatureType) &&
        Objects.equals(this.isSecurityCritical, typeInfo.isSecurityCritical) &&
        Objects.equals(this.isSecuritySafeCritical, typeInfo.isSecuritySafeCritical) &&
        Objects.equals(this.isSecurityTransparent, typeInfo.isSecurityTransparent) &&
        Objects.equals(this.structLayoutAttribute, typeInfo.structLayoutAttribute) &&
        Objects.equals(this.typeInitializer, typeInfo.typeInitializer) &&
        Objects.equals(this.typeHandle, typeInfo.typeHandle) &&
        Objects.equals(this.guid, typeInfo.guid) &&
        Objects.equals(this.baseType, typeInfo.baseType) &&
        Objects.equals(this.isSerializable, typeInfo.isSerializable) &&
        Objects.equals(this.containsGenericParameters, typeInfo.containsGenericParameters) &&
        Objects.equals(this.isVisible, typeInfo.isVisible) &&
        Objects.equals(this.genericTypeParameters, typeInfo.genericTypeParameters) &&
        Objects.equals(this.declaredConstructors, typeInfo.declaredConstructors) &&
        Objects.equals(this.declaredEvents, typeInfo.declaredEvents) &&
        Objects.equals(this.declaredFields, typeInfo.declaredFields) &&
        Objects.equals(this.declaredMembers, typeInfo.declaredMembers) &&
        Objects.equals(this.declaredMethods, typeInfo.declaredMethods) &&
        Objects.equals(this.declaredNestedTypes, typeInfo.declaredNestedTypes) &&
        Objects.equals(this.declaredProperties, typeInfo.declaredProperties) &&
        Objects.equals(this.implementedInterfaces, typeInfo.implementedInterfaces);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, customAttributes, isCollectible, metadataToken, isInterface, memberType, namespace, assemblyQualifiedName, fullName, assembly, module, isNested, declaringType, declaringMethod, reflectedType, underlyingSystemType, isTypeDefinition, isArray, isByRef, isPointer, isConstructedGenericType, isGenericParameter, isGenericTypeParameter, isGenericMethodParameter, isGenericType, isGenericTypeDefinition, isSZArray, isVariableBoundArray, isByRefLike, hasElementType, genericTypeArguments, genericParameterPosition, genericParameterAttributes, attributes, isAbstract, isImport, isSealed, isSpecialName, isClass, isNestedAssembly, isNestedFamANDAssem, isNestedFamily, isNestedFamORAssem, isNestedPrivate, isNestedPublic, isNotPublic, isPublic, isAutoLayout, isExplicitLayout, isLayoutSequential, isAnsiClass, isAutoClass, isUnicodeClass, isCOMObject, isContextful, isEnum, isMarshalByRef, isPrimitive, isValueType, isSignatureType, isSecurityCritical, isSecuritySafeCritical, isSecurityTransparent, structLayoutAttribute, typeInitializer, typeHandle, guid, baseType, isSerializable, containsGenericParameters, isVisible, genericTypeParameters, declaredConstructors, declaredEvents, declaredFields, declaredMembers, declaredMethods, declaredNestedTypes, declaredProperties, implementedInterfaces);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TypeInfo {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    customAttributes: ").append(toIndentedString(customAttributes)).append("\n");
    sb.append("    isCollectible: ").append(toIndentedString(isCollectible)).append("\n");
    sb.append("    metadataToken: ").append(toIndentedString(metadataToken)).append("\n");
    sb.append("    isInterface: ").append(toIndentedString(isInterface)).append("\n");
    sb.append("    memberType: ").append(toIndentedString(memberType)).append("\n");
    sb.append("    namespace: ").append(toIndentedString(namespace)).append("\n");
    sb.append("    assemblyQualifiedName: ").append(toIndentedString(assemblyQualifiedName)).append("\n");
    sb.append("    fullName: ").append(toIndentedString(fullName)).append("\n");
    sb.append("    assembly: ").append(toIndentedString(assembly)).append("\n");
    sb.append("    module: ").append(toIndentedString(module)).append("\n");
    sb.append("    isNested: ").append(toIndentedString(isNested)).append("\n");
    sb.append("    declaringType: ").append(toIndentedString(declaringType)).append("\n");
    sb.append("    declaringMethod: ").append(toIndentedString(declaringMethod)).append("\n");
    sb.append("    reflectedType: ").append(toIndentedString(reflectedType)).append("\n");
    sb.append("    underlyingSystemType: ").append(toIndentedString(underlyingSystemType)).append("\n");
    sb.append("    isTypeDefinition: ").append(toIndentedString(isTypeDefinition)).append("\n");
    sb.append("    isArray: ").append(toIndentedString(isArray)).append("\n");
    sb.append("    isByRef: ").append(toIndentedString(isByRef)).append("\n");
    sb.append("    isPointer: ").append(toIndentedString(isPointer)).append("\n");
    sb.append("    isConstructedGenericType: ").append(toIndentedString(isConstructedGenericType)).append("\n");
    sb.append("    isGenericParameter: ").append(toIndentedString(isGenericParameter)).append("\n");
    sb.append("    isGenericTypeParameter: ").append(toIndentedString(isGenericTypeParameter)).append("\n");
    sb.append("    isGenericMethodParameter: ").append(toIndentedString(isGenericMethodParameter)).append("\n");
    sb.append("    isGenericType: ").append(toIndentedString(isGenericType)).append("\n");
    sb.append("    isGenericTypeDefinition: ").append(toIndentedString(isGenericTypeDefinition)).append("\n");
    sb.append("    isSZArray: ").append(toIndentedString(isSZArray)).append("\n");
    sb.append("    isVariableBoundArray: ").append(toIndentedString(isVariableBoundArray)).append("\n");
    sb.append("    isByRefLike: ").append(toIndentedString(isByRefLike)).append("\n");
    sb.append("    hasElementType: ").append(toIndentedString(hasElementType)).append("\n");
    sb.append("    genericTypeArguments: ").append(toIndentedString(genericTypeArguments)).append("\n");
    sb.append("    genericParameterPosition: ").append(toIndentedString(genericParameterPosition)).append("\n");
    sb.append("    genericParameterAttributes: ").append(toIndentedString(genericParameterAttributes)).append("\n");
    sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
    sb.append("    isAbstract: ").append(toIndentedString(isAbstract)).append("\n");
    sb.append("    isImport: ").append(toIndentedString(isImport)).append("\n");
    sb.append("    isSealed: ").append(toIndentedString(isSealed)).append("\n");
    sb.append("    isSpecialName: ").append(toIndentedString(isSpecialName)).append("\n");
    sb.append("    isClass: ").append(toIndentedString(isClass)).append("\n");
    sb.append("    isNestedAssembly: ").append(toIndentedString(isNestedAssembly)).append("\n");
    sb.append("    isNestedFamANDAssem: ").append(toIndentedString(isNestedFamANDAssem)).append("\n");
    sb.append("    isNestedFamily: ").append(toIndentedString(isNestedFamily)).append("\n");
    sb.append("    isNestedFamORAssem: ").append(toIndentedString(isNestedFamORAssem)).append("\n");
    sb.append("    isNestedPrivate: ").append(toIndentedString(isNestedPrivate)).append("\n");
    sb.append("    isNestedPublic: ").append(toIndentedString(isNestedPublic)).append("\n");
    sb.append("    isNotPublic: ").append(toIndentedString(isNotPublic)).append("\n");
    sb.append("    isPublic: ").append(toIndentedString(isPublic)).append("\n");
    sb.append("    isAutoLayout: ").append(toIndentedString(isAutoLayout)).append("\n");
    sb.append("    isExplicitLayout: ").append(toIndentedString(isExplicitLayout)).append("\n");
    sb.append("    isLayoutSequential: ").append(toIndentedString(isLayoutSequential)).append("\n");
    sb.append("    isAnsiClass: ").append(toIndentedString(isAnsiClass)).append("\n");
    sb.append("    isAutoClass: ").append(toIndentedString(isAutoClass)).append("\n");
    sb.append("    isUnicodeClass: ").append(toIndentedString(isUnicodeClass)).append("\n");
    sb.append("    isCOMObject: ").append(toIndentedString(isCOMObject)).append("\n");
    sb.append("    isContextful: ").append(toIndentedString(isContextful)).append("\n");
    sb.append("    isEnum: ").append(toIndentedString(isEnum)).append("\n");
    sb.append("    isMarshalByRef: ").append(toIndentedString(isMarshalByRef)).append("\n");
    sb.append("    isPrimitive: ").append(toIndentedString(isPrimitive)).append("\n");
    sb.append("    isValueType: ").append(toIndentedString(isValueType)).append("\n");
    sb.append("    isSignatureType: ").append(toIndentedString(isSignatureType)).append("\n");
    sb.append("    isSecurityCritical: ").append(toIndentedString(isSecurityCritical)).append("\n");
    sb.append("    isSecuritySafeCritical: ").append(toIndentedString(isSecuritySafeCritical)).append("\n");
    sb.append("    isSecurityTransparent: ").append(toIndentedString(isSecurityTransparent)).append("\n");
    sb.append("    structLayoutAttribute: ").append(toIndentedString(structLayoutAttribute)).append("\n");
    sb.append("    typeInitializer: ").append(toIndentedString(typeInitializer)).append("\n");
    sb.append("    typeHandle: ").append(toIndentedString(typeHandle)).append("\n");
    sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    isSerializable: ").append(toIndentedString(isSerializable)).append("\n");
    sb.append("    containsGenericParameters: ").append(toIndentedString(containsGenericParameters)).append("\n");
    sb.append("    isVisible: ").append(toIndentedString(isVisible)).append("\n");
    sb.append("    genericTypeParameters: ").append(toIndentedString(genericTypeParameters)).append("\n");
    sb.append("    declaredConstructors: ").append(toIndentedString(declaredConstructors)).append("\n");
    sb.append("    declaredEvents: ").append(toIndentedString(declaredEvents)).append("\n");
    sb.append("    declaredFields: ").append(toIndentedString(declaredFields)).append("\n");
    sb.append("    declaredMembers: ").append(toIndentedString(declaredMembers)).append("\n");
    sb.append("    declaredMethods: ").append(toIndentedString(declaredMethods)).append("\n");
    sb.append("    declaredNestedTypes: ").append(toIndentedString(declaredNestedTypes)).append("\n");
    sb.append("    declaredProperties: ").append(toIndentedString(declaredProperties)).append("\n");
    sb.append("    implementedInterfaces: ").append(toIndentedString(implementedInterfaces)).append("\n");
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
