package uk.gov.ccs.conclave.data.migration.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Report")
@Getter
@Setter
public class Report {

    @Id
    @Column(name = "id", updatable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String errorDescription;

    private long errorCode;

    private String title;

    private long schemeId;

    private Boolean rightToBuy;

    private String lastName;

    private long identifierId;

    private String firstName;

    private String email;

    private String contactSocial;

    private String contactPhone;

    private String contactMobile;

    private String contactFax;

    private String contactEmail;


}
