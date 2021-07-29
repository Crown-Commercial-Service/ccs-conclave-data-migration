package uk.gov.ccs.conclave.data.migration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;
import uk.gov.ccs.conclave.data.migration.config.MigrationProperties;

@SpringBootApplication
@EnableConfigurationProperties(MigrationProperties.class)
public class MigrationApplication implements CommandLineRunner {
    private final Environment env;

    private final MigrationProperties properties;

    public MigrationApplication(MigrationProperties properties, Environment environment) {

        this.properties = properties;
        this.env = environment;
    }

    public static void main(String[] args) {
        SpringApplication.run(MigrationApplication.class, args);
    }

    @Override
    public void run(String... args) {

        Logger LOGGER = LoggerFactory.getLogger(MigrationApplication.class);

        LOGGER.info("----------------------------------------");
        LOGGER.info("Configuration properties");
        LOGGER.info("		dm.host is {}", properties.getCiiOrigin());
        LOGGER.info("		dm.conclaveHost is {}", properties.getConclaveOrigin());
        LOGGER.info("		dm.conclaveHost is {}", env.getProperty("ciiOrigin", MigrationProperties.class));
        LOGGER.info("----------------------------------------");
    }

}
