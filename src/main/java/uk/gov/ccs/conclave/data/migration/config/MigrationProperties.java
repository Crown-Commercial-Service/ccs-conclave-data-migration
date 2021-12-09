package uk.gov.ccs.conclave.data.migration.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MigrationProperties {

    private String ciiApiKey;

    private String ciiOrigin;

    private String conclaveApiKey;

    private String conclaveOrigin;

    private boolean sendUserRegistrationEmail;

    private boolean accountVerified;

}
