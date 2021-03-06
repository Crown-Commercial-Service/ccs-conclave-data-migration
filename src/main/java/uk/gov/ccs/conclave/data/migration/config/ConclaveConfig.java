package uk.gov.ccs.conclave.data.migration.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uk.gov.ccs.swagger.sso.ApiClient;
import uk.gov.ccs.swagger.sso.api.*;

@Configuration
@RequiredArgsConstructor
public class ConclaveConfig {

    private final MigrationProperties properties;

    @Bean
    public UserApi userApi() {
        return new UserApi(apiClient());
    }

    @Bean
    public UserContactApi userContactApi() {
        return new UserContactApi(apiClient());
    }

    @Bean
    public OrganisationApi organisationApi() {
        return new OrganisationApi(apiClient());
    }

    @Bean
    public OrganisationContactApi organisationContactApi() {
        return new OrganisationContactApi(apiClient());
    }

    @Bean
    public ConfigurationApi configurationApi() {
        return new ConfigurationApi(apiClient());
    }


    @Bean
    public ApiClient apiClient() {
        return new ApiClient()
                .addDefaultHeader("x-api-key", properties.getConclaveApiKey())
                .setBasePath(properties.getConclaveOrigin());
    }
}
