package uk.gov.ccs.conclave.data.migration.domain;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @CsvBindByName(column = "identifier-id", required = true)
    private Long identifierId;

    @CsvBindByName(column = "scheme-id", required = true)
    private String schemeId;

    @CsvBindByName(column = "rightToBuy", required = true)
    private Boolean rightToBuy;

    @CsvBindByName(column = "email", required = true)
    private String email;

    @CsvBindByName(column = "title")
    private String title;

    @CsvBindByName(column = "firstName", required = true)
    private String firstName;

    @CsvBindByName(column = "lastName", required = true)
    private String lastName;

    @CsvBindByName(column = "contactEmail")
    private String contactEmail;

    @CsvBindByName(column = "contactMobile")
    private String contactMobile;

    @CsvBindByName(column = "contactFax")
    private String contactFax;

    @CsvBindByName(column = "contactPhone")
    private String contactPhone;

    @CsvBindByName(column = "contactSocial")
    private String contactSocial;


}
