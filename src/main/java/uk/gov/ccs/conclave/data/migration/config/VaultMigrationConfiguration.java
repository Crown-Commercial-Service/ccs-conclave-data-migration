package uk.gov.ccs.conclave.data.migration.config;

import io.pivotal.spring.cloud.vault.service.common.VaultServiceInfo;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.vault.authentication.ClientAuthentication;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.config.AbstractVaultConfiguration;
import org.springframework.vault.core.VaultOperations;
import org.springframework.vault.support.VaultResponseSupport;

@Configuration
@Profile("cloud")
public class VaultMigrationConfiguration extends AbstractVaultConfiguration {

    private final VaultOperations operations;

    VaultServiceInfo vaultService = getVaultServiceInfo();

    VaultMigrationConfiguration(VaultOperations operations) {
        this.operations = operations;
    }

    @Override
    public ClientAuthentication clientAuthentication() {
        return new TokenAuthentication(String.valueOf(vaultService.getToken()));
    }

    @Override
    public VaultEndpoint vaultEndpoint() {
        return VaultEndpoint.create(vaultService.getHost(), vaultService.getPort());
    }

    public MigrationProperties readSecrets() {
        VaultResponseSupport<MigrationProperties> response = operations.read(vaultService.getSharedBackends().get("space"), MigrationProperties.class);
        return response.getData();
    }

    private static VaultServiceInfo getVaultServiceInfo() {
        CloudFactory cloudFactory = new CloudFactory();
        Cloud cloud = cloudFactory.getCloud();
        return (VaultServiceInfo) cloud.getServiceInfo("hashicorp-vault");
    }
}
