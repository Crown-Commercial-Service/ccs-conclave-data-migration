package uk.gov.ccs.conclave.data.migration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.core.VaultTemplate;
import uk.gov.ccs.swagger.sso.ApiClient;
import uk.gov.ccs.swagger.sso.api.UserApi;

//@Configuration
public class ConclaveConfig {
    private final VaultTemplate template;

    public ConclaveConfig(VaultTemplate template) {
        this.template = template;
    }

    @Bean
    public UserApi userApi() {
        return new UserApi(apiClient());
    }

    @Bean("conclaveClient")
    public ApiClient apiClient() {
        return new ApiClient()
                .addDefaultHeader("x-api-key", VaultMigrationConfiguration.readSecrets(template).getConclaveApiKey())
                .setBasePath(VaultMigrationConfiguration.readSecrets(template).getConclaveOrigin());
    }
}
