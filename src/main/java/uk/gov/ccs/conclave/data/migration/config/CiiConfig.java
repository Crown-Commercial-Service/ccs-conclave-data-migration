package uk.gov.ccs.conclave.data.migration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uk.gov.ccs.swagger.cii.ApiClient;
import uk.gov.ccs.swagger.cii.api.IdentitiesApi;

@Configuration
public class CiiConfig {

    private final VaultMigrationConfiguration configuration;

    public CiiConfig(VaultMigrationConfiguration configuration) {
        this.configuration = configuration;
    }


    @Bean
    IdentitiesApi identitiesApi() {
        return new IdentitiesApi(apiClient());
    }

    @Bean("ciiClient")
    public ApiClient apiClient() {
        return new ApiClient()
                .addDefaultHeader("x-api-key", configuration.readSecrets().getCiiApiKey())
                .setBasePath(configuration.readSecrets().getCiiOrigin());
    }
}
