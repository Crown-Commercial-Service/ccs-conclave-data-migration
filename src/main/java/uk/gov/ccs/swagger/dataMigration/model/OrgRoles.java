package uk.gov.ccs.swagger.dataMigration.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * OrgRoles
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-08-06T08:59:45.567Z[GMT]")


public class OrgRoles   {
  @JsonProperty("name")
  private String name = null;

  public OrgRoles name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Organisation Roles
   * @return name
   **/
  @Schema(example = "RMI", description = "Organisation Roles")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrgRoles orgRoles = (OrgRoles) o;
    return Objects.equals(this.name, orgRoles.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrgRoles {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
