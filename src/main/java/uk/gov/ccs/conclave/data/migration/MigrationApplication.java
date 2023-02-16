package uk.gov.ccs.conclave.data.migration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import uk.gov.ccs.conclave.data.migration.config.ApplicationConfig;

@SpringBootApplication
@Import({ ApplicationConfig.class })
public class MigrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(MigrationApplication.class, args);
    }


}
