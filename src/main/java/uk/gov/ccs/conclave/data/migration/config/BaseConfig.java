package uk.gov.ccs.conclave.data.migration.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.vault.core.VaultOperations;

import javax.annotation.PostConstruct;
import java.util.Objects;

import static uk.gov.ccs.conclave.data.migration.config.VaultMigrationConfiguration.getBackendPath;

@Configuration
public class BaseConfig {

    protected final VaultOperations operations;

    protected MigrationProperties properties;

    public void setProperties(MigrationProperties properties) {
        this.properties = properties;
    }

    public BaseConfig(VaultOperations operations) {
        this.operations = operations;
    }

    @PostConstruct
    public void readSecrets() {
        var response = operations.read(getBackendPath(), MigrationProperties.class);
        setProperties(Objects.requireNonNull(response).getData());
    }

}
