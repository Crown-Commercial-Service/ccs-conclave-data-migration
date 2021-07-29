package uk.gov.ccs.conclave.data.migration.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("migration")
@Getter
@Setter
public class MigrationProperties {

    @Value("$ciiApiKey")
    private String ciiApiKey;

    @Value("$ciiOrigin")
    private String ciiOrigin;

    @Value("$conclaveApiKey")
    private String conclaveApiKey;

    @Value("$conclaveOrigin")
    private String conclaveOrigin;
}
