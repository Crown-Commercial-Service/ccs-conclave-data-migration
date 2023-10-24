package uk.gov.ccs.conclave.data.migration.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uk.gov.ccs.swagger.sso.ApiClient;
import uk.gov.ccs.swagger.sso.api.*;

@Configuration
@RequiredArgsConstructor
public class ConclaveConfig {

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
    public OrganisationAutoValidationApi organisationAutoValidationApiApi() {
        return new OrganisationAutoValidationApi(apiClient());
    }

    @Bean
    public OrganisationContactApi organisationContactApi() {
        return new OrganisationContactApi(apiClient());
    }

    @Bean
    public ConfigurationServicesApi configurationServicesApi() {
        return new ConfigurationServicesApi(apiClient());
    }

    @Bean
    public OrganisationUserApi organisationUserApi() {
        return new OrganisationUserApi(apiClient());
    }


    @Bean
    public ApiClient apiClient() {
        return new ApiClient()
                .addDefaultHeader("x-api-key", MigrationProperties.getConclaveApiKey())
                .setBasePath(MigrationProperties.getConclaveOrigin());
    }
}
