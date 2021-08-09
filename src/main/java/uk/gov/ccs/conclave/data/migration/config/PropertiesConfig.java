package uk.gov.ccs.conclave.data.migration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.core.VaultOperations;

import javax.annotation.PostConstruct;
import java.util.Objects;

import static uk.gov.ccs.conclave.data.migration.config.VaultMigrationConfig.getBackendPath;

@Configuration
public class PropertiesConfig {

    protected final VaultOperations operations;

    @lombok.Setter
    private MigrationProperties migrationProperties;

    @Bean
    public MigrationProperties getMigrationProperties() {
        return migrationProperties;
    }

    public PropertiesConfig(VaultOperations operations) {
        this.operations = operations;
    }

    @PostConstruct
    public void readSecrets() {
        var response = operations.read(getBackendPath(), MigrationProperties.class);
        setMigrationProperties(Objects.requireNonNull(response).getData());
    }

}
