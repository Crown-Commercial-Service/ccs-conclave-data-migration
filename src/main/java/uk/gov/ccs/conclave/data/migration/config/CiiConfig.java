package uk.gov.ccs.conclave.data.migration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.core.VaultTemplate;
import uk.gov.ccs.swagger.cii.ApiClient;
import uk.gov.ccs.swagger.cii.api.IdentitiesApi;

@Configuration
public class CiiConfig {

    private final VaultTemplate template;

    public CiiConfig(VaultTemplate template) {
        this.template = template;
    }

    @Bean
    IdentitiesApi identitiesApi() {
        return new IdentitiesApi(apiClient());
    }

    @Bean("ciiClient")
    public ApiClient apiClient() {
        return new ApiClient()
                .addDefaultHeader("x-api-key", VaultMigrationConfiguration.readSecrets(template).getCiiApiKey())
                .setBasePath(VaultMigrationConfiguration.readSecrets(template).getCiiOrigin());
    }
}
