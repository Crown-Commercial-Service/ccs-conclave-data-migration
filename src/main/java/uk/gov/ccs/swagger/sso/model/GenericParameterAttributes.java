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
 * Gets or Sets GenericParameterAttributes
 */
@JsonAdapter(GenericParameterAttributes.Adapter.class)
public enum GenericParameterAttributes {
  NUMBER_0(0),
  NUMBER_1(1),
  NUMBER_2(2),
  NUMBER_3(3),
  NUMBER_4(4),
  NUMBER_8(8),
  NUMBER_16(16),
  NUMBER_28(28);

  private Integer value;

  GenericParameterAttributes(Integer value) {
    this.value = value;
  }

  public Integer getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static GenericParameterAttributes fromValue(String text) {
    for (GenericParameterAttributes b : GenericParameterAttributes.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "' for 'GenericParameterAttributes' enum.");
  }

  public static class Adapter extends TypeAdapter<GenericParameterAttributes> {
    @Override
    public void write(final JsonWriter jsonWriter, final GenericParameterAttributes enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public GenericParameterAttributes read(final JsonReader jsonReader) throws IOException {
      Object value = jsonReader.nextInt();
      return GenericParameterAttributes.fromValue(String.valueOf(value));
    }
  }
}