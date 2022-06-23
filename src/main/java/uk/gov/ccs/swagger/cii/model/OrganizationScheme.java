/*
 * CCS Central Identity Index Service (CII)
 * This is an example CCS Central Identity Index (CII) Service API.
 *
 * OpenAPI spec version: 1.0.4
 * Contact: apiteam@crowncommercial.gov.uk
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package uk.gov.ccs.swagger.cii.model;

import java.util.Objects;
import java.util.Arrays;
import io.swagger.v3.oas.annotations.media.Schema;
import com.google.gson.annotations.SerializedName;
import java.io.IOException;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * Organization identifiers should be taken from an existing organization identifier list. The scheme field is used to indicate the list or register from which the identifier is taken. This value should be taken from the [Organization Identifier Scheme](https://standard.open-contracting.org/latest/en/schema/codelists/#organization-identifier-scheme) codelist.
 */
@JsonAdapter(OrganizationScheme.Adapter.class)
public enum OrganizationScheme {
  COH("GB-COH"),
  MPR("GB-MPR"),
  NIC("GB-NIC"),
  CHC("GB-CHC"),
  SC("GB-SC"),
  WALEDU("GB-WALEDU"),
  SCOTEDU("GB-SCOTEDU"),
  GOR("GB-GOR"),
  LANI("GB-LANI"),
  NHS("GB-NHS");

  private String value;

  OrganizationScheme(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static OrganizationScheme fromValue(String input) {
    for (OrganizationScheme b : OrganizationScheme.values()) {
      if (b.value.equals(input)) {
        return b;
      }
    }
    return null;
  }

  public static class Adapter extends TypeAdapter<OrganizationScheme> {
    @Override
    public void write(final JsonWriter jsonWriter, final OrganizationScheme enumeration) throws IOException {
      jsonWriter.value(String.valueOf(enumeration.getValue()));
    }

    @Override
    public OrganizationScheme read(final JsonReader jsonReader) throws IOException {
      Object value = jsonReader.nextString();
      return OrganizationScheme.fromValue((String)(value));
    }
  }
}
