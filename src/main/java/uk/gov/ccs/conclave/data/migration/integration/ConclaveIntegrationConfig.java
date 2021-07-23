package uk.gov.ccs.conclave.data.migration.integration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uk.gov.ccs.swagger.sso.ApiClient;
import uk.gov.ccs.swagger.sso.api.UserApi;

@Configuration
public class ConclaveIntegrationConfig {

    private String apiKey;

    private String origin;

    public ConclaveIntegrationConfig(@Value("${conclave.api.key}") String apiKey, @Value("${conclave.host}") String origin) {
        this.apiKey = apiKey;
        this.origin = origin;
    }

    @Bean
    public UserApi userApi() {
        return new UserApi(apiClient());
    }

    @Bean
    public ApiClient apiClient() {
        return new ApiClient()
                .addDefaultHeader("x-api-key", apiKey)
                .setBasePath(origin);
    }
}
