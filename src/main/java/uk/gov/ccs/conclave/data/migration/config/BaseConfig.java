package uk.gov.ccs.conclave.data.migration.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.core.VaultOperations;
import org.springframework.vault.support.VaultResponseSupport;

import java.util.Map;
import java.util.Objects;

import static uk.gov.ccs.conclave.data.migration.config.VaultMigrationConfiguration.cfCredentials;
@Configuration
public class BaseConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseConfig.class);

    protected final VaultOperations operations;

    public BaseConfig(VaultOperations operations) {
        this.operations = operations;
    }


    public MigrationProperties readSecrets() {
        var backend = (Map<String, Object>) cfCredentials.getMap().get("backends_shared");
        String backendPath = backend.get("space").toString().concat("/migration");
        VaultResponseSupport<MigrationProperties> response = operations.read(backendPath, MigrationProperties.class);
        LOGGER.info("Response of operations is " + response.getData().getCiiOrigin());
        return Objects.requireNonNull(response).getData();
    }
}
