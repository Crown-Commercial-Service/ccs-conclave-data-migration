package uk.gov.ccs.conclave.data.migration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("uk.gov.ccs.conclave.data.migration.*")
@EntityScan("uk.gov.ccs.conclave.data.migration.domain.*")
@SpringBootApplication
public class MigrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(MigrationApplication.class, args);
    }


}
