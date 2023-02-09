package uk.gov.ccs.conclave.data.migration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uk.gov.ccs.conclave.data.migration.service.AuthorizationService;
import uk.gov.ccs.conclave.data.migration.repository.ClientRepository;

@Configuration
public class ApplicationConfig {

    private final ClientRepository clientRepository;

    public ApplicationConfig(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Bean
    public AuthorizationService authorizationService() {
        return new AuthorizationService(clientRepository);
    }
}
