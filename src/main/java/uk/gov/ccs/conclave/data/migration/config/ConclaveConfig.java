package uk.gov.ccs.conclave.data.migration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.core.VaultOperations;
import uk.gov.ccs.swagger.sso.ApiClient;
import uk.gov.ccs.swagger.sso.api.UserApi;

@Configuration
public class ConclaveConfig extends BaseConfig {

    public ConclaveConfig(VaultOperations operations) {
        super(operations);
    }

    @Bean
    public UserApi userApi() {
        return new UserApi(apiClient());
    }

    @Bean("conclaveClient")
    public ApiClient apiClient() {
        return new ApiClient()
                .addDefaultHeader("x-api-key", readSecrets().getConclaveApiKey())
                .setBasePath(readSecrets().getConclaveOrigin());
    }
}
