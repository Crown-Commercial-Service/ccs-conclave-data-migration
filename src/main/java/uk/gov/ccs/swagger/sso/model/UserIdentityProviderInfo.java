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
/**
 * UserIdentityProviderInfo
 */


public class UserIdentityProviderInfo {
  @SerializedName("identityProviderId")
  private Integer identityProviderId = null;

  @SerializedName("identityProvider")
  private String identityProvider = null;

  @SerializedName("identityProviderDisplayName")
  private String identityProviderDisplayName = null;

  public UserIdentityProviderInfo identityProviderId(Integer identityProviderId) {
    this.identityProviderId = identityProviderId;
    return this;
  }

   /**
   * Get identityProviderId
   * @return identityProviderId
  **/
  @Schema(description = "")
  public Integer getIdentityProviderId() {
    return identityProviderId;
  }

  public void setIdentityProviderId(Integer identityProviderId) {
    this.identityProviderId = identityProviderId;
  }

  public UserIdentityProviderInfo identityProvider(String identityProvider) {
    this.identityProvider = identityProvider;
    return this;
  }

   /**
   * Get identityProvider
   * @return identityProvider
  **/
  @Schema(description = "")
  public String getIdentityProvider() {
    return identityProvider;
  }

  public void setIdentityProvider(String identityProvider) {
    this.identityProvider = identityProvider;
  }

  public UserIdentityProviderInfo identityProviderDisplayName(String identityProviderDisplayName) {
    this.identityProviderDisplayName = identityProviderDisplayName;
    return this;
  }

   /**
   * Get identityProviderDisplayName
   * @return identityProviderDisplayName
  **/
  @Schema(description = "")
  public String getIdentityProviderDisplayName() {
    return identityProviderDisplayName;
  }

  public void setIdentityProviderDisplayName(String identityProviderDisplayName) {
    this.identityProviderDisplayName = identityProviderDisplayName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserIdentityProviderInfo userIdentityProviderInfo = (UserIdentityProviderInfo) o;
    return Objects.equals(this.identityProviderId, userIdentityProviderInfo.identityProviderId) &&
        Objects.equals(this.identityProvider, userIdentityProviderInfo.identityProvider) &&
        Objects.equals(this.identityProviderDisplayName, userIdentityProviderInfo.identityProviderDisplayName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identityProviderId, identityProvider, identityProviderDisplayName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserIdentityProviderInfo {\n");
    
    sb.append("    identityProviderId: ").append(toIndentedString(identityProviderId)).append("\n");
    sb.append("    identityProvider: ").append(toIndentedString(identityProvider)).append("\n");
    sb.append("    identityProviderDisplayName: ").append(toIndentedString(identityProviderDisplayName)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
