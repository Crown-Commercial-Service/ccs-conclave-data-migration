package uk.gov.ccs.conclave.data.migration.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "clients")
@Getter
@Setter
public class Client {

    @Id
    @Column(name = "client_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long clientId;

    private String apiKey;

    private String clientKeyDescription;

}
