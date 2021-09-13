package uk.gov.ccs.conclave.data.migration.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "organisation")
@Getter
@Setter
public class Org {

    @Id
    @Column(name = "org_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long orgId;

    private Long identifierId;

    private String schemeId;

    private Boolean rightToBuy;

    private String orgRoles;

    private String status;

    @OneToMany(mappedBy="organisation")
    private Set<User> users;

}
