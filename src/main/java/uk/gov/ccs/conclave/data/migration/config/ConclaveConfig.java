package uk.gov.ccs.conclave.data.migration.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uk.gov.ccs.swagger.sso.ApiClient;
import uk.gov.ccs.swagger.sso.api.*;

import static uk.gov.ccs.conclave.data.migration.config.AWSConfig.X_API_KEY;
import static uk.gov.ccs.conclave.data.migration.config.MigrationProperties.*;

@Configuration
@RequiredArgsConstructor
public class ConclaveConfig {

    @Bean
    public UserApi userApi() {
        return new UserApi(userApiClient());
    }

    @Bean
    public UserContactApi userContactApi() {
        return new UserContactApi(userApiClient());
    }

    @Bean
    public OrganisationApi organisationApi() {
        return new OrganisationApi(apiClient());
    }

    @Bean
    public OrganisationRoleApi organisationRoleApi() {
        return new OrganisationRoleApi(apiClient());
    }

    @Bean
    public OrganisationAutoValidationApi organisationAutoValidationApi() {
        return new OrganisationAutoValidationApi(apiClient());
    }

    @Bean
    public OrganisationIdentityProviderApi organisationIdentityProviderApi() {
        return new OrganisationIdentityProviderApi(apiClient());
    }

    @Bean
    public OrganisationContactApi organisationContactApi() {
        return new OrganisationContactApi(apiClient());
    }

    @Bean
    public ConfigurationServicesApi configurationServicesApi() {
        return new ConfigurationServicesApi(configApiClient());
    }

    @Bean
    public OrganisationUserApi organisationUserApi() {
        return new OrganisationUserApi(apiClient());
    }


    @Bean
    public ApiClient apiClient() {
        return new ApiClient()
                .setBasePath(getConclaveOrigin())
                .addDefaultHeader(X_API_KEY, getConclaveApiKey());
    }

    @Bean
    public ApiClient userApiClient() {
        return new ApiClient()
                .setBasePath(getConclaveOrigin())
                .addDefaultHeader(X_API_KEY, getConclaveUserApiKey());
    }

    @Bean
    public ApiClient configApiClient() {
        return new ApiClient()
                .setBasePath(getConclaveOrigin())
                .addDefaultHeader(X_API_KEY, getConclaveConfigApiKey());
    }
}
