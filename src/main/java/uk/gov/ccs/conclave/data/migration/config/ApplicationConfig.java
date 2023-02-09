package uk.gov.ccs.conclave.data.migration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uk.gov.ccs.conclave.data.migration.service.AuthorizationService;

@Configuration
public class ApplicationConfig {
    @Bean
    public AuthorizationService authorizationService() {
        return new AuthorizationService();
    }
}