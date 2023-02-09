package uk.gov.ccs.conclave.data.migration.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import uk.gov.ccs.conclave.data.migration.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByApiKey(String apiKey);
}
