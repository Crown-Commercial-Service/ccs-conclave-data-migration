package uk.gov.ccs.conclave.data.migration.config;

import io.pivotal.cfenv.core.CfCredentials;
import io.pivotal.cfenv.core.CfEnv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.authentication.ClientAuthentication;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.config.AbstractVaultConfiguration;
import org.springframework.vault.core.VaultOperations;
import org.springframework.vault.support.VaultResponseSupport;

import java.net.URI;
import java.util.Objects;

@Configuration
public class VaultMigrationConfiguration extends AbstractVaultConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(VaultMigrationConfiguration.class);

    @Autowired
    private VaultOperations operations;

    CfCredentials cfCredentials = getVaultServiceInfo();

    @Override
    public ClientAuthentication clientAuthentication() {
        return new TokenAuthentication(cfCredentials.getString("auth", "token"));
    }

    @Override
    public VaultEndpoint vaultEndpoint() {
        return VaultEndpoint.from(URI.create(cfCredentials.getString("address")));
    }

    public MigrationProperties readSecrets() {
        VaultResponseSupport<MigrationProperties> response = operations.read(cfCredentials.getString("backends_shared", "space"), MigrationProperties.class);
        return Objects.requireNonNull(response).getData();
    }

    private static CfCredentials getVaultServiceInfo() {
        CfEnv cfEnv = new CfEnv();
        CfCredentials credentials = cfEnv.findCredentialsByName("vault-service-data-migration-sandbox");
        LOGGER.info("reading credentials :: host" + credentials.getHost());
        LOGGER.info("reading map :: host" + credentials.getMap().toString());
        return credentials;
    }
}
