package uk.gov.ccs.conclave.data.migration.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import static java.lang.Boolean.parseBoolean;
import static uk.gov.ccs.conclave.data.migration.config.MigrationProperties.*;

@Configuration
@Profile("cloud")
public class AWSConfig {
    private static final Logger log = LoggerFactory.getLogger(AWSConfig.class);
    public static final String X_API_KEY = "x-api-key";
    private static final Boolean AWS_SECRETS = getAWSSecrets();

    private static Boolean getAWSSecrets() {
        log.info("Configuring AWS SSM Credentials & Client.");

        try {
            log.info("Getting App Parameters.");

            String CII_API_KEY = System.getenv("CII_API_KEY");
            String CII_DELETE_TOKEN = System.getenv("CII_DELETE_TOKEN");
            String CII_ORIGIN = System.getenv("CII_ORIGIN");
            String CONCLAVE_ORIGIN = System.getenv("CONCLAVE_ORIGIN");
            String CONCLAVE_API_KEY = System.getenv("CONCLAVE_API_KEY");
            String CONCLAVE_CONFIG_KEY = System.getenv("CONCLAVE_CONFIG_KEY");
            String CONCLAVE_USER_KEY = System.getenv("CONCLAVE_USER_KEY");
            String SEND_USER_REGISTRATION_EMAIL = System.getenv("SEND_USER_REGISTRATION_EMAIL");
            String ACCOUNT_VERIFIED = System.getenv("ACCOUNT_VERIFIED");

            setCiiApiKey(CII_API_KEY);
            setCiiDeleteToken(CII_DELETE_TOKEN);
            setCiiOrigin(CII_ORIGIN);
            setConclaveOrigin(CONCLAVE_ORIGIN);
            setConclaveApiKey(CONCLAVE_API_KEY);
            setConclaveConfigApiKey(CONCLAVE_CONFIG_KEY);
            setConclaveUserApiKey(CONCLAVE_USER_KEY);
            setSendUserRegistrationEmail(parseBoolean(SEND_USER_REGISTRATION_EMAIL));
            setAccountVerified(parseBoolean(ACCOUNT_VERIFIED));

            log.info("Application Parameters Configured Successfully.");
            return true;

        } catch (Exception e) {
            log.error("AWS SSM Config Error: %s : %s".formatted(e.getMessage(), AWS_SECRETS));
            return false;
        }
    }
}