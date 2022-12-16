package uk.gov.ccs.conclave.data.migration.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uk.gov.ccs.swagger.cii.ApiClient;
import uk.gov.ccs.swagger.cii.api.IdentitiesApi;

@Configuration
@RequiredArgsConstructor
public class CiiConfig {

    private final MigrationProperties properties;

    @Bean
    IdentitiesApi identitiesApi() {
        return new IdentitiesApi(apiClient());
    }

    public ApiClient apiClient() {
        return new ApiClient()
                .addDefaultHeader("x-api-key", properties.getCiiApiKey())
                .addDefaultHeader("x-api-key-delete", properties.getCiiDeleteToken())
                .setBasePath(properties.getCiiOrigin());
    }
}
