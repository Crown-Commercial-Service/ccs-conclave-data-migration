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
import uk.gov.ccs.swagger.sso.model.UserRequestDetail;
import uk.gov.ccs.swagger.sso.model.UserTitle;
/**
 * UserProfileEditRequestInfo
 */


public class UserProfileEditRequestInfo {
  @SerializedName("userName")
  private String userName = null;

  @SerializedName("organisationId")
  private String organisationId = null;

  @SerializedName("firstName")
  private String firstName = null;

  @SerializedName("lastName")
  private String lastName = null;

  @SerializedName("title")
  private UserTitle title = null;

  @SerializedName("mfaEnabled")
  private Boolean mfaEnabled = null;

  @SerializedName("password")
  private String password = null;

  @SerializedName("accountVerified")
  private Boolean accountVerified = null;

  @SerializedName("sendUserRegistrationEmail")
  private Boolean sendUserRegistrationEmail = null;

  @SerializedName("detail")
  private UserRequestDetail detail = null;

  public UserProfileEditRequestInfo userName(String userName) {
    this.userName = userName;
    return this;
  }

   /**
   * Get userName
   * @return userName
  **/
  @Schema(description = "")
  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public UserProfileEditRequestInfo organisationId(String organisationId) {
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

  public UserProfileEditRequestInfo firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

   /**
   * Get firstName
   * @return firstName
  **/
  @Schema(description = "")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public UserProfileEditRequestInfo lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

   /**
   * Get lastName
   * @return lastName
  **/
  @Schema(description = "")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public UserProfileEditRequestInfo title(UserTitle title) {
    this.title = title;
    return this;
  }

   /**
   * Get title
   * @return title
  **/
  @Schema(description = "")
  public UserTitle getTitle() {
    return title;
  }

  public void setTitle(UserTitle title) {
    this.title = title;
  }

  public UserProfileEditRequestInfo mfaEnabled(Boolean mfaEnabled) {
    this.mfaEnabled = mfaEnabled;
    return this;
  }

   /**
   * Get mfaEnabled
   * @return mfaEnabled
  **/
  @Schema(description = "")
  public Boolean isMfaEnabled() {
    return mfaEnabled;
  }

  public void setMfaEnabled(Boolean mfaEnabled) {
    this.mfaEnabled = mfaEnabled;
  }

  public UserProfileEditRequestInfo password(String password) {
    this.password = password;
    return this;
  }

   /**
   * Get password
   * @return password
  **/
  @Schema(description = "")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public UserProfileEditRequestInfo accountVerified(Boolean accountVerified) {
    this.accountVerified = accountVerified;
    return this;
  }

   /**
   * Get accountVerified
   * @return accountVerified
  **/
  @Schema(description = "")
  public Boolean isAccountVerified() {
    return accountVerified;
  }

  public void setAccountVerified(Boolean accountVerified) {
    this.accountVerified = accountVerified;
  }

  public UserProfileEditRequestInfo sendUserRegistrationEmail(Boolean sendUserRegistrationEmail) {
    this.sendUserRegistrationEmail = sendUserRegistrationEmail;
    return this;
  }

   /**
   * Get sendUserRegistrationEmail
   * @return sendUserRegistrationEmail
  **/
  @Schema(description = "")
  public Boolean isSendUserRegistrationEmail() {
    return sendUserRegistrationEmail;
  }

  public void setSendUserRegistrationEmail(Boolean sendUserRegistrationEmail) {
    this.sendUserRegistrationEmail = sendUserRegistrationEmail;
  }

  public UserProfileEditRequestInfo detail(UserRequestDetail detail) {
    this.detail = detail;
    return this;
  }

   /**
   * Get detail
   * @return detail
  **/
  @Schema(description = "")
  public UserRequestDetail getDetail() {
    return detail;
  }

  public void setDetail(UserRequestDetail detail) {
    this.detail = detail;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserProfileEditRequestInfo userProfileEditRequestInfo = (UserProfileEditRequestInfo) o;
    return Objects.equals(this.userName, userProfileEditRequestInfo.userName) &&
        Objects.equals(this.organisationId, userProfileEditRequestInfo.organisationId) &&
        Objects.equals(this.firstName, userProfileEditRequestInfo.firstName) &&
        Objects.equals(this.lastName, userProfileEditRequestInfo.lastName) &&
        Objects.equals(this.title, userProfileEditRequestInfo.title) &&
        Objects.equals(this.mfaEnabled, userProfileEditRequestInfo.mfaEnabled) &&
        Objects.equals(this.password, userProfileEditRequestInfo.password) &&
        Objects.equals(this.accountVerified, userProfileEditRequestInfo.accountVerified) &&
        Objects.equals(this.sendUserRegistrationEmail, userProfileEditRequestInfo.sendUserRegistrationEmail) &&
        Objects.equals(this.detail, userProfileEditRequestInfo.detail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userName, organisationId, firstName, lastName, title, mfaEnabled, password, accountVerified, sendUserRegistrationEmail, detail);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserProfileEditRequestInfo {\n");
    
    sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
    sb.append("    organisationId: ").append(toIndentedString(organisationId)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    mfaEnabled: ").append(toIndentedString(mfaEnabled)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    accountVerified: ").append(toIndentedString(accountVerified)).append("\n");
    sb.append("    sendUserRegistrationEmail: ").append(toIndentedString(sendUserRegistrationEmail)).append("\n");
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
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
