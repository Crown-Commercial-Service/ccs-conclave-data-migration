package uk.gov.ccs.conclave.data.migration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.core.VaultOperations;

import java.util.List;
import java.util.Objects;

import static uk.gov.ccs.conclave.data.migration.config.VaultMigrationConfig.getBackendPath;
import static uk.gov.ccs.conclave.data.migration.config.AwsMigrationConfig.getAwsAccessKeyId;
import static uk.gov.ccs.conclave.data.migration.config.AwsMigrationConfig.getAwsSecretAccessKey;

@Configuration
public class PropertiesConfig {

    protected final VaultOperations operations;

    @Bean
    public void awsMigrationProperties() {
        System.out.println("\nTESTING1:\n");
        System.out.println("(getAwsAccessKeyId()): "+ getAwsAccessKeyId());
        System.out.println("(getAwsSecretAccessKey()): "+ getAwsSecretAccessKey());
        System.out.println("\nDONE1\n");
        List<String> getSecretsList = AwsSsmConfig.configAwsClient(getAwsAccessKeyId(), getAwsSecretAccessKey());
        System.out.println("\nTESTING2:\n");
        System.out.println("(getSecretsList): "+ getSecretsList);
        System.out.println("\nDONE2\n");
        // Will tidy the below up, once confirmed it's working.
        //MigrationProperties.detCiiApiKey(getSecretsList.get(0));
        //MigrationProperties.setCiiOrigin(getSecretsList.get(1));
        //MigrationProperties.setConclaveApiKey(getSecretsList.get(2));
        //MigrationProperties.setConclaveOrigin(getSecretsList.get(3));
        //MigrationProperties.setSendUserRegistrationEmail(getSecretsList.get(4));
        //MigrationProperties.setAccountVerified(getSecretsList.get(5));
    }

    @Bean
    public MigrationProperties migrationProperties() {
        var response = operations.read(getBackendPath(), MigrationProperties.class);
        return Objects.requireNonNull(response).getData();
    }

    public PropertiesConfig(VaultOperations operations) {
        this.operations = operations;
    }

}
