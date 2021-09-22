package uk.gov.ccs.conclave.data.migration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.gov.ccs.conclave.data.migration.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
