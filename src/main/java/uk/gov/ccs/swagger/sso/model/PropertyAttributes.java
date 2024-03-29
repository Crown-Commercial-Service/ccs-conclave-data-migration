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
 * Gets or Sets PropertyAttributes
 */
@JsonAdapter(PropertyAttributes.Adapter.class)
public enum PropertyAttributes {
  NUMBER_0(0),
  NUMBER_512(512),
  NUMBER_1024(1024),
  NUMBER_4096(4096),
  NUMBER_8192(8192),
  NUMBER_16384(16384),
  NUMBER_32768(32768),
  NUMBER_62464(62464);

  private Integer value;

  PropertyAttributes(Integer value) {
    this.value = value;
  }

  public Integer getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static PropertyAttributes fromValue(String text) {
    for (PropertyAttributes b : PropertyAttributes.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "' for 'PropertyAttributes' enum.");
  }

  public static class Adapter extends TypeAdapter<PropertyAttributes> {
    @Override
    public void write(final JsonWriter jsonWriter, final PropertyAttributes enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public PropertyAttributes read(final JsonReader jsonReader) throws IOException {
      Object value = jsonReader.nextInt();
      return PropertyAttributes.fromValue(String.valueOf(value));
    }
  }
}
