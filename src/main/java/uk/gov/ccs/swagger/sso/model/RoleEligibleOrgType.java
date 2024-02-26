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
import com.google.gson.annotations.SerializedName;
import java.io.IOException;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * Gets or Sets RoleEligibleOrgType
 */
@JsonAdapter(RoleEligibleOrgType.Adapter.class)
public enum RoleEligibleOrgType {
  @SerializedName("0")
  NUMBER_0(0),
  @SerializedName("1")
  NUMBER_1(1),
  @SerializedName("2")
  NUMBER_2(2);

  private Integer value;

  RoleEligibleOrgType(Integer value) {
    this.value = value;
  }

  public Integer getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static RoleEligibleOrgType fromValue(String text) {
    for (RoleEligibleOrgType b : RoleEligibleOrgType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "' for 'RoleEligibleOrgType' enum.");
  }

  public static class Adapter extends TypeAdapter<RoleEligibleOrgType> {
    @Override
    public void write(final JsonWriter jsonWriter, final RoleEligibleOrgType enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public RoleEligibleOrgType read(final JsonReader jsonReader) throws IOException {
      Object value = jsonReader.nextInt();
      return RoleEligibleOrgType.fromValue(String.valueOf(value));
    }
  }
}
