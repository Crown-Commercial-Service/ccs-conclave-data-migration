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
import uk.gov.ccs.swagger.sso.model.EventAttributes;
import uk.gov.ccs.swagger.sso.model.MemberTypes;
import uk.gov.ccs.swagger.sso.model.MethodInfo;
import uk.gov.ccs.swagger.sso.model.Module;
import uk.gov.ccs.swagger.sso.model.Type;
/**
 * EventInfo
 */


public class EventInfo {
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

  @SerializedName("attributes")
  private EventAttributes attributes = null;

  @SerializedName("isSpecialName")
  private Boolean isSpecialName = null;

  @SerializedName("addMethod")
  private MethodInfo addMethod = null;

  @SerializedName("removeMethod")
  private MethodInfo removeMethod = null;

  @SerializedName("raiseMethod")
  private MethodInfo raiseMethod = null;

  @SerializedName("isMulticast")
  private Boolean isMulticast = null;

  @SerializedName("eventHandlerType")
  private Type eventHandlerType = null;

   /**
   * Get name
   * @return name
  **/
  @Schema(description = "")
  public String getName() {
    return name;
  }

  public EventInfo declaringType(Type declaringType) {
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

  public EventInfo reflectedType(Type reflectedType) {
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

  public EventInfo module(Module module) {
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

  public EventInfo memberType(MemberTypes memberType) {
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

  public EventInfo attributes(EventAttributes attributes) {
    this.attributes = attributes;
    return this;
  }

   /**
   * Get attributes
   * @return attributes
  **/
  @Schema(description = "")
  public EventAttributes getAttributes() {
    return attributes;
  }

  public void setAttributes(EventAttributes attributes) {
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

  public EventInfo addMethod(MethodInfo addMethod) {
    this.addMethod = addMethod;
    return this;
  }

   /**
   * Get addMethod
   * @return addMethod
  **/
  @Schema(description = "")
  public MethodInfo getAddMethod() {
    return addMethod;
  }

  public void setAddMethod(MethodInfo addMethod) {
    this.addMethod = addMethod;
  }

  public EventInfo removeMethod(MethodInfo removeMethod) {
    this.removeMethod = removeMethod;
    return this;
  }

   /**
   * Get removeMethod
   * @return removeMethod
  **/
  @Schema(description = "")
  public MethodInfo getRemoveMethod() {
    return removeMethod;
  }

  public void setRemoveMethod(MethodInfo removeMethod) {
    this.removeMethod = removeMethod;
  }

  public EventInfo raiseMethod(MethodInfo raiseMethod) {
    this.raiseMethod = raiseMethod;
    return this;
  }

   /**
   * Get raiseMethod
   * @return raiseMethod
  **/
  @Schema(description = "")
  public MethodInfo getRaiseMethod() {
    return raiseMethod;
  }

  public void setRaiseMethod(MethodInfo raiseMethod) {
    this.raiseMethod = raiseMethod;
  }

   /**
   * Get isMulticast
   * @return isMulticast
  **/
  @Schema(description = "")
  public Boolean isIsMulticast() {
    return isMulticast;
  }

  public EventInfo eventHandlerType(Type eventHandlerType) {
    this.eventHandlerType = eventHandlerType;
    return this;
  }

   /**
   * Get eventHandlerType
   * @return eventHandlerType
  **/
  @Schema(description = "")
  public Type getEventHandlerType() {
    return eventHandlerType;
  }

  public void setEventHandlerType(Type eventHandlerType) {
    this.eventHandlerType = eventHandlerType;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventInfo eventInfo = (EventInfo) o;
    return Objects.equals(this.name, eventInfo.name) &&
        Objects.equals(this.declaringType, eventInfo.declaringType) &&
        Objects.equals(this.reflectedType, eventInfo.reflectedType) &&
        Objects.equals(this.module, eventInfo.module) &&
        Objects.equals(this.customAttributes, eventInfo.customAttributes) &&
        Objects.equals(this.isCollectible, eventInfo.isCollectible) &&
        Objects.equals(this.metadataToken, eventInfo.metadataToken) &&
        Objects.equals(this.memberType, eventInfo.memberType) &&
        Objects.equals(this.attributes, eventInfo.attributes) &&
        Objects.equals(this.isSpecialName, eventInfo.isSpecialName) &&
        Objects.equals(this.addMethod, eventInfo.addMethod) &&
        Objects.equals(this.removeMethod, eventInfo.removeMethod) &&
        Objects.equals(this.raiseMethod, eventInfo.raiseMethod) &&
        Objects.equals(this.isMulticast, eventInfo.isMulticast) &&
        Objects.equals(this.eventHandlerType, eventInfo.eventHandlerType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, declaringType, reflectedType, module, customAttributes, isCollectible, metadataToken, memberType, attributes, isSpecialName, addMethod, removeMethod, raiseMethod, isMulticast, eventHandlerType);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventInfo {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    declaringType: ").append(toIndentedString(declaringType)).append("\n");
    sb.append("    reflectedType: ").append(toIndentedString(reflectedType)).append("\n");
    sb.append("    module: ").append(toIndentedString(module)).append("\n");
    sb.append("    customAttributes: ").append(toIndentedString(customAttributes)).append("\n");
    sb.append("    isCollectible: ").append(toIndentedString(isCollectible)).append("\n");
    sb.append("    metadataToken: ").append(toIndentedString(metadataToken)).append("\n");
    sb.append("    memberType: ").append(toIndentedString(memberType)).append("\n");
    sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
    sb.append("    isSpecialName: ").append(toIndentedString(isSpecialName)).append("\n");
    sb.append("    addMethod: ").append(toIndentedString(addMethod)).append("\n");
    sb.append("    removeMethod: ").append(toIndentedString(removeMethod)).append("\n");
    sb.append("    raiseMethod: ").append(toIndentedString(raiseMethod)).append("\n");
    sb.append("    isMulticast: ").append(toIndentedString(isMulticast)).append("\n");
    sb.append("    eventHandlerType: ").append(toIndentedString(eventHandlerType)).append("\n");
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
