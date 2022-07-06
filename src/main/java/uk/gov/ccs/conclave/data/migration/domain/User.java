package uk.gov.ccs.conclave.data.migration.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @Column(name = "user_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    private String email;

    private String title;

    private String firstName;

    private String lastName;

    private String contactPointName;

    private String contactEmail;

    private String contactMobile;

    private String contactFax;

    private String contactPhone;

    private String contactSocial;

    private String userRoles;

    private Integer status;

    private String statusDescription;

    @ManyToOne
    @JoinColumn(name="org_id", nullable=false)
    private Org org;
}
