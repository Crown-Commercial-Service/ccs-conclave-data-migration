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
import uk.gov.ccs.swagger.sso.model.OrganisationRole;
import uk.gov.ccs.swagger.sso.model.RoleEligibleOrgType;
import uk.gov.ccs.swagger.sso.model.RoleEligibleSubscriptionType;
import uk.gov.ccs.swagger.sso.model.RoleEligibleTradeType;
/**
 * ServiceRoleGroup
 */


public class ServiceRoleGroup {
  @SerializedName("id")
  private Integer id = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("key")
  private String key = null;

  @SerializedName("orgTypeEligibility")
  private RoleEligibleOrgType orgTypeEligibility = null;

  @SerializedName("subscriptionTypeEligibility")
  private RoleEligibleSubscriptionType subscriptionTypeEligibility = null;

  @SerializedName("tradeEligibility")
  private RoleEligibleTradeType tradeEligibility = null;

  @SerializedName("displayOrder")
  private Integer displayOrder = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("autoValidationRoleTypeEligibility")
  private List<Integer> autoValidationRoleTypeEligibility = null;

  @SerializedName("approvalRequired")
  private Integer approvalRequired = null;

  @SerializedName("roles")
  private List<OrganisationRole> roles = null;

  public ServiceRoleGroup id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @Schema(description = "")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ServiceRoleGroup name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @Schema(description = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ServiceRoleGroup key(String key) {
    this.key = key;
    return this;
  }

   /**
   * Get key
   * @return key
  **/
  @Schema(description = "")
  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public ServiceRoleGroup orgTypeEligibility(RoleEligibleOrgType orgTypeEligibility) {
    this.orgTypeEligibility = orgTypeEligibility;
    return this;
  }

   /**
   * Get orgTypeEligibility
   * @return orgTypeEligibility
  **/
  @Schema(description = "")
  public RoleEligibleOrgType getOrgTypeEligibility() {
    return orgTypeEligibility;
  }

  public void setOrgTypeEligibility(RoleEligibleOrgType orgTypeEligibility) {
    this.orgTypeEligibility = orgTypeEligibility;
  }

  public ServiceRoleGroup subscriptionTypeEligibility(RoleEligibleSubscriptionType subscriptionTypeEligibility) {
    this.subscriptionTypeEligibility = subscriptionTypeEligibility;
    return this;
  }

   /**
   * Get subscriptionTypeEligibility
   * @return subscriptionTypeEligibility
  **/
  @Schema(description = "")
  public RoleEligibleSubscriptionType getSubscriptionTypeEligibility() {
    return subscriptionTypeEligibility;
  }

  public void setSubscriptionTypeEligibility(RoleEligibleSubscriptionType subscriptionTypeEligibility) {
    this.subscriptionTypeEligibility = subscriptionTypeEligibility;
  }

  public ServiceRoleGroup tradeEligibility(RoleEligibleTradeType tradeEligibility) {
    this.tradeEligibility = tradeEligibility;
    return this;
  }

   /**
   * Get tradeEligibility
   * @return tradeEligibility
  **/
  @Schema(description = "")
  public RoleEligibleTradeType getTradeEligibility() {
    return tradeEligibility;
  }

  public void setTradeEligibility(RoleEligibleTradeType tradeEligibility) {
    this.tradeEligibility = tradeEligibility;
  }

  public ServiceRoleGroup displayOrder(Integer displayOrder) {
    this.displayOrder = displayOrder;
    return this;
  }

   /**
   * Get displayOrder
   * @return displayOrder
  **/
  @Schema(description = "")
  public Integer getDisplayOrder() {
    return displayOrder;
  }

  public void setDisplayOrder(Integer displayOrder) {
    this.displayOrder = displayOrder;
  }

  public ServiceRoleGroup description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @Schema(description = "")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ServiceRoleGroup autoValidationRoleTypeEligibility(List<Integer> autoValidationRoleTypeEligibility) {
    this.autoValidationRoleTypeEligibility = autoValidationRoleTypeEligibility;
    return this;
  }

  public ServiceRoleGroup addAutoValidationRoleTypeEligibilityItem(Integer autoValidationRoleTypeEligibilityItem) {
    if (this.autoValidationRoleTypeEligibility == null) {
      this.autoValidationRoleTypeEligibility = new ArrayList<Integer>();
    }
    this.autoValidationRoleTypeEligibility.add(autoValidationRoleTypeEligibilityItem);
    return this;
  }

   /**
   * Get autoValidationRoleTypeEligibility
   * @return autoValidationRoleTypeEligibility
  **/
  @Schema(description = "")
  public List<Integer> getAutoValidationRoleTypeEligibility() {
    return autoValidationRoleTypeEligibility;
  }

  public void setAutoValidationRoleTypeEligibility(List<Integer> autoValidationRoleTypeEligibility) {
    this.autoValidationRoleTypeEligibility = autoValidationRoleTypeEligibility;
  }

  public ServiceRoleGroup approvalRequired(Integer approvalRequired) {
    this.approvalRequired = approvalRequired;
    return this;
  }

   /**
   * Get approvalRequired
   * @return approvalRequired
  **/
  @Schema(description = "")
  public Integer getApprovalRequired() {
    return approvalRequired;
  }

  public void setApprovalRequired(Integer approvalRequired) {
    this.approvalRequired = approvalRequired;
  }

  public ServiceRoleGroup roles(List<OrganisationRole> roles) {
    this.roles = roles;
    return this;
  }

  public ServiceRoleGroup addRolesItem(OrganisationRole rolesItem) {
    if (this.roles == null) {
      this.roles = new ArrayList<OrganisationRole>();
    }
    this.roles.add(rolesItem);
    return this;
  }

   /**
   * Get roles
   * @return roles
  **/
  @Schema(description = "")
  public List<OrganisationRole> getRoles() {
    return roles;
  }

  public void setRoles(List<OrganisationRole> roles) {
    this.roles = roles;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceRoleGroup serviceRoleGroup = (ServiceRoleGroup) o;
    return Objects.equals(this.id, serviceRoleGroup.id) &&
        Objects.equals(this.name, serviceRoleGroup.name) &&
        Objects.equals(this.key, serviceRoleGroup.key) &&
        Objects.equals(this.orgTypeEligibility, serviceRoleGroup.orgTypeEligibility) &&
        Objects.equals(this.subscriptionTypeEligibility, serviceRoleGroup.subscriptionTypeEligibility) &&
        Objects.equals(this.tradeEligibility, serviceRoleGroup.tradeEligibility) &&
        Objects.equals(this.displayOrder, serviceRoleGroup.displayOrder) &&
        Objects.equals(this.description, serviceRoleGroup.description) &&
        Objects.equals(this.autoValidationRoleTypeEligibility, serviceRoleGroup.autoValidationRoleTypeEligibility) &&
        Objects.equals(this.approvalRequired, serviceRoleGroup.approvalRequired) &&
        Objects.equals(this.roles, serviceRoleGroup.roles);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, key, orgTypeEligibility, subscriptionTypeEligibility, tradeEligibility, displayOrder, description, autoValidationRoleTypeEligibility, approvalRequired, roles);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceRoleGroup {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    orgTypeEligibility: ").append(toIndentedString(orgTypeEligibility)).append("\n");
    sb.append("    subscriptionTypeEligibility: ").append(toIndentedString(subscriptionTypeEligibility)).append("\n");
    sb.append("    tradeEligibility: ").append(toIndentedString(tradeEligibility)).append("\n");
    sb.append("    displayOrder: ").append(toIndentedString(displayOrder)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    autoValidationRoleTypeEligibility: ").append(toIndentedString(autoValidationRoleTypeEligibility)).append("\n");
    sb.append("    approvalRequired: ").append(toIndentedString(approvalRequired)).append("\n");
    sb.append("    roles: ").append(toIndentedString(roles)).append("\n");
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