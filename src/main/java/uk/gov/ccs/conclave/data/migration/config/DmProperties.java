package uk.gov.ccs.conclave.data.migration.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("dm")
@Getter
@Setter
public class DmProperties {

    @Value("$CII_API_KEY")
    private String ciiApiKey;

    @Value("$CII_ORIGIN")
    private String ciiOrigin;

    @Value("$CONCLAVE_API_KEY")
    private String conclaveApiKey;

    @Value("$CONCLAVE_ORIGIN")
    private String conclaveOrigin;
}
