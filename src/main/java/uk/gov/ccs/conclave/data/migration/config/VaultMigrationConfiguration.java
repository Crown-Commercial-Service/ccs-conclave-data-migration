package uk.gov.ccs.conclave.data.migration.config;

import io.pivotal.cfenv.core.CfCredentials;
import io.pivotal.cfenv.core.CfEnv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.vault.authentication.ClientAuthentication;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.config.AbstractVaultConfiguration;
import org.springframework.vault.core.VaultOperations;
import org.springframework.vault.support.VaultResponseSupport;

import java.net.URI;
import java.util.Map;
import java.util.Objects;

@Configuration
@Profile("cloud")
public class VaultMigrationConfiguration extends AbstractVaultConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(VaultMigrationConfiguration.class);

    private static CfCredentials cfCredentials = getVaultCredentials();

    @Override
    public ClientAuthentication clientAuthentication() {
        return new TokenAuthentication(cfCredentials.getString("auth", "token"));
    }

    @Override
    public VaultEndpoint vaultEndpoint() {
        return VaultEndpoint.from((URI) cfCredentials.getMap().get("address"));
    }

    public static MigrationProperties readSecrets(VaultOperations operations) {
        Map<String, Object> backend = (Map<String, Object>) cfCredentials.getMap().get("backends_shared");
        LOGGER.info("BACKENd is " + backend);
        String backendPath = backend.get("space").toString();
        LOGGER.info("BACKENd path " + backend);
        VaultResponseSupport<MigrationProperties> response = operations.read(backendPath.concat("migration"), MigrationProperties.class);
        return Objects.requireNonNull(response).getData();
    }

    private static CfCredentials getVaultCredentials() {
        CfEnv cfEnv = new CfEnv();
        CfCredentials credentials = cfEnv.findCredentialsByName("vault-service-data-migration-sandbox");
        return credentials;
    }
}
