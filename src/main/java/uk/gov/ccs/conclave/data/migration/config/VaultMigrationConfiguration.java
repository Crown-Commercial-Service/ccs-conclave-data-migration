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

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
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
        VaultEndpoint endpoint = null;
        try {
            String address = cfCredentials.getString("address");
            LOGGER.info("Address from environment is " + address);

            endpoint = VaultEndpoint.from(new URI(address));
        } catch (URISyntaxException e) {
            LOGGER.error("Error while creating vault URI " + e.getMessage());
        }
        return endpoint;
    }

    public static MigrationProperties readSecrets(VaultOperations operations) {
        String backendPath = cfCredentials.getString("backends_shared", "space");
        LOGGER.info("BACKENd path " + backendPath);
        VaultResponseSupport<MigrationProperties> response = operations.read(backendPath.concat("migration"), MigrationProperties.class);
        return Objects.requireNonNull(response).getData();
    }

    private static CfCredentials getVaultCredentials() {
        CfEnv cfEnv = new CfEnv();
        CfCredentials credentials = cfEnv.findCredentialsByName("vault-service-data-migration-sandbox");
        LOGGER.info("reading credentials :: host" + credentials.getHost());
        LOGGER.info("reading map :: host" + credentials.getMap().toString());
        return credentials;
    }
}
