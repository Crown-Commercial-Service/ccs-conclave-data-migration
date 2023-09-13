package uk.gov.ccs.conclave.data.migration.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "org")
@Getter
@Setter
public class Org {

    @Id
    @Column(name = "org_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orgId;

    private String identifierId;

    private String schemeId;

    private String domainName;

    private Boolean rightToBuy;

    private String orgRoles;

    private Integer status;

    private String statusDescription;

    @OneToMany(mappedBy = "org", cascade = CascadeType.ALL)
    private Set<User> users;

}
