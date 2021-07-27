package uk.gov.ccs.conclave.data.migration.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uk.gov.ccs.swagger.cii.ApiClient;
import uk.gov.ccs.swagger.cii.api.IdentitiesApi;

@Configuration
public class CiiConfig {

    private final String apiKey;

    private final String origin;

    public CiiConfig(@Value("${cii.api.key}") String apiKey, @Value("${cii.host}") String origin) {
        this.apiKey = apiKey;
        this.origin = origin;
    }

    @Bean
    IdentitiesApi identitiesApi() {
        return new IdentitiesApi(apiClient());
    }

    @Bean("ciiClient")
    public ApiClient apiClient() {
        return new ApiClient()
                .addDefaultHeader("x-api-key", apiKey)
                .setBasePath(origin);
    }
}
