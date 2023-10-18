/*
 * CcsSso.UserApi
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
import uk.gov.ccs.swagger.sso.model.UserAccessRolePendingDetailsInfo;
/**
 * UserAccessRolePendingRequestDetails
 */


public class UserAccessRolePendingRequestDetails {
  @SerializedName("userAccessRolePendingDetailsInfo")
  private List<UserAccessRolePendingDetailsInfo> userAccessRolePendingDetailsInfo = null;

  public UserAccessRolePendingRequestDetails userAccessRolePendingDetailsInfo(List<UserAccessRolePendingDetailsInfo> userAccessRolePendingDetailsInfo) {
    this.userAccessRolePendingDetailsInfo = userAccessRolePendingDetailsInfo;
    return this;
  }

  public UserAccessRolePendingRequestDetails addUserAccessRolePendingDetailsInfoItem(UserAccessRolePendingDetailsInfo userAccessRolePendingDetailsInfoItem) {
    if (this.userAccessRolePendingDetailsInfo == null) {
      this.userAccessRolePendingDetailsInfo = new ArrayList<UserAccessRolePendingDetailsInfo>();
    }
    this.userAccessRolePendingDetailsInfo.add(userAccessRolePendingDetailsInfoItem);
    return this;
  }

   /**
   * Get userAccessRolePendingDetailsInfo
   * @return userAccessRolePendingDetailsInfo
  **/
  @Schema(description = "")
  public List<UserAccessRolePendingDetailsInfo> getUserAccessRolePendingDetailsInfo() {
    return userAccessRolePendingDetailsInfo;
  }

  public void setUserAccessRolePendingDetailsInfo(List<UserAccessRolePendingDetailsInfo> userAccessRolePendingDetailsInfo) {
    this.userAccessRolePendingDetailsInfo = userAccessRolePendingDetailsInfo;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserAccessRolePendingRequestDetails userAccessRolePendingRequestDetails = (UserAccessRolePendingRequestDetails) o;
    return Objects.equals(this.userAccessRolePendingDetailsInfo, userAccessRolePendingRequestDetails.userAccessRolePendingDetailsInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userAccessRolePendingDetailsInfo);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserAccessRolePendingRequestDetails {\n");
    
    sb.append("    userAccessRolePendingDetailsInfo: ").append(toIndentedString(userAccessRolePendingDetailsInfo)).append("\n");
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
