package uk.gov.ccs.conclave.data.migration.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {

    @Id
    @Column(name = "id", updatable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String email;

    private String title;

    private String firstName;

    private String lastName;

    private String contactEmail;

    private String contactMobile;

    private String contactFax;

    private String contactPhone;

    private String contactSocial;

    private String userRoles;

    private String status;

    @ManyToOne
    @JoinColumn(name="org_id", nullable=false)
    private Org org;


}
