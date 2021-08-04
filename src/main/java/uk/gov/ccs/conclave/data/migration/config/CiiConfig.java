package uk.gov.ccs.conclave.data.migration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.core.VaultOperations;
import uk.gov.ccs.swagger.cii.ApiClient;
import uk.gov.ccs.swagger.cii.api.IdentitiesApi;

@Configuration
public class CiiConfig extends BaseConfig {


    public CiiConfig(VaultOperations operations) {
        super(operations);
    }

    @Bean
    IdentitiesApi identitiesApi() {
        return new IdentitiesApi(apiClient());
    }

    @Bean("ciiClient")
    public ApiClient apiClient() {
        return new ApiClient()
                .addDefaultHeader("x-api-key", readSecrets().getCiiApiKey())
                .setBasePath(readSecrets().getCiiOrigin());
    }
}
