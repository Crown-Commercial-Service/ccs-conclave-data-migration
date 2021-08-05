package uk.gov.ccs.conclave.data.migration.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class MigrationProperties {

    private String ciiApiKey;

    private String ciiOrigin;

    private String conclaveApiKey;

    private String conclaveOrigin;
}
