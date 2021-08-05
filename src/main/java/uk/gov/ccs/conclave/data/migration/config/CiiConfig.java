package uk.gov.ccs.conclave.data.migration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uk.gov.ccs.swagger.cii.ApiClient;
import uk.gov.ccs.swagger.cii.api.IdentitiesApi;

@Configuration
public class CiiConfig {

    private final MigrationProperties properties;

    public CiiConfig(MigrationProperties properties) {
        this.properties = properties;
    }

    @Bean
    IdentitiesApi identitiesApi() {
        return new IdentitiesApi(apiClient());
    }

    @Bean("ciiClient")
    public ApiClient apiClient() {
        return new ApiClient()
                .addDefaultHeader("x-api-key", properties.getCiiApiKey())
                .setBasePath(properties.getCiiOrigin());
    }
}
