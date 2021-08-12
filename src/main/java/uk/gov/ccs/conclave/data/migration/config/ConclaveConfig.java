package uk.gov.ccs.conclave.data.migration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uk.gov.ccs.swagger.sso.ApiClient;
import uk.gov.ccs.swagger.sso.api.OrganisationApi;
import uk.gov.ccs.swagger.sso.api.UserApi;

@Configuration
public class ConclaveConfig {

    private final MigrationProperties properties;

    public ConclaveConfig(MigrationProperties properties) {
        this.properties = properties;
    }

    @Bean
    public UserApi userApi() {
        return new UserApi(apiClient());
    }

    @Bean
    public OrganisationApi organisationApi() {
        return new OrganisationApi(apiClient());
    }

    @Bean
    public ApiClient apiClient() {
        return new ApiClient()
                .addDefaultHeader("x-api-key", properties.getConclaveApiKey())
                .setBasePath(properties.getConclaveOrigin());
    }
}
