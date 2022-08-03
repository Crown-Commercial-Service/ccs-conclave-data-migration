package uk.gov.ccs.conclave.data.migration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.core.VaultOperations;

import java.util.Objects;

import static uk.gov.ccs.conclave.data.migration.config.VaultMigrationConfig.getBackendPath;

@Configuration
public class PropertiesConfig {

    protected final VaultOperations operations;

    @Bean
    public MigrationProperties migrationProperties() {
        var response = operations.read(getBackendPath(), MigrationProperties.class);
        return Objects.requireNonNull(response).getData();
    }

    public PropertiesConfig(VaultOperations operations) {
        this.operations = operations;
    }

}
