package uk.gov.ccs.conclave.data.migration.config;

import io.pivotal.cfenv.core.CfCredentials;
import io.pivotal.cfenv.core.CfEnv;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.vault.authentication.ClientAuthentication;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.config.AbstractVaultConfiguration;

import java.net.URI;
import java.util.Map;

@Configuration
@Profile("cloud")
public class VaultMigrationConfiguration extends AbstractVaultConfiguration {

    public static CfCredentials cfCredentials = getVaultCredentials();

    @Override
    public ClientAuthentication clientAuthentication() {
        Map<String, Object> auth = (Map<String, Object>) cfCredentials.getMap().get("auth");
        return new TokenAuthentication(auth.get("token").toString());
    }

    @SneakyThrows
    @Override
    public VaultEndpoint vaultEndpoint() {
        return VaultEndpoint.from(URI.create(cfCredentials.getMap().get("address").toString()));
    }

    private static CfCredentials getVaultCredentials() {
        CfEnv cfEnv = new CfEnv();
        return cfEnv.findCredentialsByName("vault-service-data-migration-sandbox");
    }
}
