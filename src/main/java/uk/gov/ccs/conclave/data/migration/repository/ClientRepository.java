package uk.gov.ccs.conclave.data.migration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import uk.gov.ccs.conclave.data.migration.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

    //@Query("SELECT * FROM clients WHERE clients.api_key = ?1")
    //ClientRepository findClient(String apiKey);
}
