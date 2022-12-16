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
public class VaultMigrationConfig extends AbstractVaultConfiguration {

    private static final CfCredentials cfCredentials = getVaultCredentials();

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
        System.out.println("\nHERE-->0001!!\n");
        //System.out.println(cfEnv.findServicesByName("conclave-data-migration-integration-ssm-service"));
        System.out.println(cfEnv.findCredentialsByLabel("user-provided"));
        System.out.println(cfEnv.findAllServices());
        System.out.println("\nHERE-->0002!!\n");
        return cfEnv.findCredentialsByLabel("hashicorp-vault");
    }

    public static String getBackendPath() {
        var backend = (Map<String, Object>) cfCredentials.getMap().get("backends_shared");
        return backend.get("space").toString().concat("/migration");
    }
}
