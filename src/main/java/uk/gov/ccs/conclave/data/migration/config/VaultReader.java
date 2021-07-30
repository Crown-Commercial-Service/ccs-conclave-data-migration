package uk.gov.ccs.conclave.data.migration.config;

import io.pivotal.spring.cloud.vault.service.common.VaultServiceInfo;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.vault.core.VaultOperations;
import org.springframework.vault.support.VaultResponseSupport;

@Configuration
@Profile("cloud")
public class VaultReader {

    private final VaultOperations operations;

    public VaultReader(VaultOperations operations) {
        this.operations = operations;
    }

    public MigrationProperties readSecrets() {
        VaultServiceInfo vaultService = getVaultServiceInfo();

        VaultResponseSupport<MigrationProperties> response = operations.read(vaultService.getSharedBackends().get("space"), MigrationProperties.class);
        return response.getData();
    }

    static VaultServiceInfo getVaultServiceInfo() {
        CloudFactory cloudFactory = new CloudFactory();
        Cloud cloud = cloudFactory.getCloud();
        return (VaultServiceInfo) cloud.getServiceInfo("hashicorp-vault");
    }
}
