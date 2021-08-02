package uk.gov.ccs.conclave.data.migration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uk.gov.ccs.swagger.sso.ApiClient;
import uk.gov.ccs.swagger.sso.api.UserApi;

@Configuration
public class ConclaveConfig {
    private final VaultMigrationConfiguration configuration;

    public ConclaveConfig(VaultMigrationConfiguration configuration) {
        this.configuration = configuration;
    }

    @Bean
    public UserApi userApi() {
        return new UserApi(apiClient());
    }

    @Bean("conclaveClient")
    public ApiClient apiClient() {
        return new ApiClient()
                .addDefaultHeader("x-api-key", configuration.readSecrets().getConclaveApiKey())
                .setBasePath(configuration.readSecrets().getConclaveOrigin());
    }
}
