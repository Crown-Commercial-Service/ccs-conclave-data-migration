package uk.gov.ccs.conclave.data.migration.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.vault.core.VaultOperations;

import java.util.Map;
import java.util.Objects;

import static uk.gov.ccs.conclave.data.migration.config.VaultMigrationConfiguration.cfCredentials;

@Configuration
public class BaseConfig {

    protected final VaultOperations operations;

    public BaseConfig(VaultOperations operations) {
        this.operations = operations;
    }


    public MigrationProperties readSecrets() {
        var response = operations.read(getBackendPath(), MigrationProperties.class);
        return Objects.requireNonNull(response).getData();
    }

    private String getBackendPath() {
        var backend = (Map<String, Object>) cfCredentials.getMap().get("backends_shared");
        return backend.get("space").toString().concat("/migration");
    }
}
