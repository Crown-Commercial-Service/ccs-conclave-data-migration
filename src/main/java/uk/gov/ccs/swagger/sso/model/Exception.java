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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import uk.gov.ccs.swagger.sso.model.Exception;
import uk.gov.ccs.swagger.sso.model.MethodBase;
/**
 * Exception
 */


public class Exception {
  @SerializedName("targetSite")
  private MethodBase targetSite = null;

  @SerializedName("message")
  private String message = null;

  @SerializedName("data")
  private Map<String, Object> data = null;

  @SerializedName("innerException")
  private Exception innerException = null;

  @SerializedName("helpLink")
  private String helpLink = null;

  @SerializedName("source")
  private String source = null;

  @SerializedName("hResult")
  private Integer hResult = null;

  @SerializedName("stackTrace")
  private String stackTrace = null;

  public Exception targetSite(MethodBase targetSite) {
    this.targetSite = targetSite;
    return this;
  }

   /**
   * Get targetSite
   * @return targetSite
  **/
  @Schema(description = "")
  public MethodBase getTargetSite() {
    return targetSite;
  }

  public void setTargetSite(MethodBase targetSite) {
    this.targetSite = targetSite;
  }

  public Exception message(String message) {
    this.message = message;
    return this;
  }

   /**
   * Get message
   * @return message
  **/
  @Schema(description = "")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

   /**
   * Get data
   * @return data
  **/
  @Schema(description = "")
  public Map<String, Object> getData() {
    return data;
  }

  public Exception innerException(Exception innerException) {
    this.innerException = innerException;
    return this;
  }

   /**
   * Get innerException
   * @return innerException
  **/
  @Schema(description = "")
  public Exception getInnerException() {
    return innerException;
  }

  public void setInnerException(Exception innerException) {
    this.innerException = innerException;
  }

  public Exception helpLink(String helpLink) {
    this.helpLink = helpLink;
    return this;
  }

   /**
   * Get helpLink
   * @return helpLink
  **/
  @Schema(description = "")
  public String getHelpLink() {
    return helpLink;
  }

  public void setHelpLink(String helpLink) {
    this.helpLink = helpLink;
  }

  public Exception source(String source) {
    this.source = source;
    return this;
  }

   /**
   * Get source
   * @return source
  **/
  @Schema(description = "")
  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public Exception hResult(Integer hResult) {
    this.hResult = hResult;
    return this;
  }

   /**
   * Get hResult
   * @return hResult
  **/
  @Schema(description = "")
  public Integer getHResult() {
    return hResult;
  }

  public void setHResult(Integer hResult) {
    this.hResult = hResult;
  }

   /**
   * Get stackTrace
   * @return stackTrace
  **/
  @Schema(description = "")
  public String getStackTrace() {
    return stackTrace;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Exception exception = (Exception) o;
    return Objects.equals(this.targetSite, exception.targetSite) &&
        Objects.equals(this.message, exception.message) &&
        Objects.equals(this.data, exception.data) &&
        Objects.equals(this.innerException, exception.innerException) &&
        Objects.equals(this.helpLink, exception.helpLink) &&
        Objects.equals(this.source, exception.source) &&
        Objects.equals(this.hResult, exception.hResult) &&
        Objects.equals(this.stackTrace, exception.stackTrace);
  }

  @Override
  public int hashCode() {
    return Objects.hash(targetSite, message, data, innerException, helpLink, source, hResult, stackTrace);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Exception {\n");
    
    sb.append("    targetSite: ").append(toIndentedString(targetSite)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    innerException: ").append(toIndentedString(innerException)).append("\n");
    sb.append("    helpLink: ").append(toIndentedString(helpLink)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    hResult: ").append(toIndentedString(hResult)).append("\n");
    sb.append("    stackTrace: ").append(toIndentedString(stackTrace)).append("\n");
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
