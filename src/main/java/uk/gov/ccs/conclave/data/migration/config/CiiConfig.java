package uk.gov.ccs.conclave.data.migration.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uk.gov.ccs.swagger.cii.ApiClient;
import uk.gov.ccs.swagger.cii.api.IdentitiesApi;

@Configuration
@RequiredArgsConstructor
public class CiiConfig {

    @Bean
    IdentitiesApi identitiesApi() {
        return new IdentitiesApi(apiClient());
    }

    @Bean("ciiClient")
    public ApiClient apiClient() {
        return new ApiClient()
                .addDefaultHeader("x-api-key", MigrationProperties.getCiiApiKey())
                .addDefaultHeader("x-api-key-delete", MigrationProperties.getCiiDeleteToken())
                .setBasePath(MigrationProperties.getCiiOrigin());
    }
}
