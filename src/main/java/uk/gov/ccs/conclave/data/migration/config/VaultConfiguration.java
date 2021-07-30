package uk.gov.ccs.conclave.data.migration.config;

import io.pivotal.spring.cloud.vault.service.common.VaultServiceInfo;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.vault.authentication.ClientAuthentication;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.config.AbstractVaultConfiguration;

import static uk.gov.ccs.conclave.data.migration.config.VaultReader.getVaultServiceInfo;

@Configuration
@Profile("cloud")
class VaultConfiguration extends AbstractVaultConfiguration {

    @Override
    public ClientAuthentication clientAuthentication() {
        VaultServiceInfo vaultService = getVaultServiceInfo();
        return new TokenAuthentication(String.valueOf(vaultService.getToken()));
    }

    @Override
    public VaultEndpoint vaultEndpoint() {
        VaultServiceInfo vaultService = getVaultServiceInfo();
        return VaultEndpoint.create(vaultService.getHost(), vaultService.getPort());
    }
}
