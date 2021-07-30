package uk.gov.ccs.conclave.data.migration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import uk.gov.ccs.conclave.data.migration.config.VaultReader;

@SpringBootApplication
public class MigrationApplication implements CommandLineRunner {

    private final VaultReader reader;

    public MigrationApplication(VaultReader reader) {
        this.reader = reader;
    }

    public static void main(String[] args) {
        SpringApplication.run(MigrationApplication.class, args);
    }

    @Override
    public void run(String... args) {

        Logger LOGGER = LoggerFactory.getLogger(MigrationApplication.class);

        LOGGER.info("----------------------------------------");
        LOGGER.info("Configuration properties");
        LOGGER.info("		migration properties is {}", reader.readSecrets().getConclaveOrigin());
       // LOGGER.info("		dm.conclaveHost is {}", vaultTemplate.read("cf/5718307e-5904-4fcc-8660-f6d603ba81dd/secret/migration", MigrationProperties.class).getData().getConclaveOrigin());
        LOGGER.info("----------------------------------------");
    }

}
