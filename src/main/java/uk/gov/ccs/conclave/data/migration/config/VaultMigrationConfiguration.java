package uk.gov.ccs.conclave.data.migration.config;

import io.pivotal.spring.cloud.vault.service.common.VaultServiceInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.authentication.ClientAuthentication;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.config.AbstractVaultConfiguration;
import org.springframework.vault.core.VaultOperations;
import org.springframework.vault.support.VaultResponseSupport;

@Configuration
public class VaultMigrationConfiguration extends AbstractVaultConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(VaultMigrationConfiguration.class);

    @Autowired
    private VaultOperations operations;

    VaultServiceInfo vaultService = getVaultServiceInfo();

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
        LOGGER.info("CLOUD INFO is : " + cloud.getServiceInfo("vault-service-data-migration-sandbox").toString());
        return (VaultServiceInfo) cloud.getServiceInfo("vault-service-data-migration-sandbox");
    }
}
