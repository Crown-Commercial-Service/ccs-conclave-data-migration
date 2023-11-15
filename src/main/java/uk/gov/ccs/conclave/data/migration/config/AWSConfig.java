package uk.gov.ccs.conclave.data.migration.config;

import io.pivotal.cfenv.core.CfCredentials;
import io.pivotal.cfenv.core.CfEnv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ssm.SsmClient;
import software.amazon.awssdk.services.ssm.model.GetParameterRequest;
import software.amazon.awssdk.services.ssm.model.GetParameterResponse;
import software.amazon.awssdk.services.ssm.model.SsmException;

import static java.lang.Boolean.parseBoolean;
import static uk.gov.ccs.conclave.data.migration.config.MigrationProperties.*;

@Configuration
@Profile("cloud")
public class AWSConfig {
    private static final Logger log = LoggerFactory.getLogger(AWSConfig.class);
    private static final CfEnv cfEnv = new CfEnv();
    private static final CfCredentials awsCredentials = cfEnv.findCredentialsByTag("aws-ssm");
    private static final String AWS_ACCESS_KEY_ID = awsCredentials.getString("aws_access_key_id");
    private static final String AWS_SECRET_ACCESS_KEY = awsCredentials.getString("aws_secret_access_key");
    public static final String X_API_KEY = "x-api-key";
    public static final String CII_API_KEY = "ciiApiKey";
    public static final String CII_DELETE_TOKEN = "ciiDeleteToken";
    public static final String CII_ORIGIN = "ciiOrigin";
    public static final String CONCLAVE_API_KEY = "conclaveApiKey";
    public static final String CONCLAVE_ORIGIN = "conclaveOrigin";
    public static final String SEND_USER_REGISTRATION_EMAIL = "sendUserRegistrationEmail";
    public static final String ACCOUNT_VERIFIED = "accountVerified";
    public static final String CONCLAVE_CONFIG_KEY = "conclaveConfigKey";
    public static final String CONCLAVE_USER_KEY = "conclaveUserKey";
    private static final Boolean AWS_SECRETS = getAWSSecrets();

    private static Boolean getAWSSecrets() {
        log.info("Configuring AWS SSM Credentials & Client.");

        AwsCredentials credentials = AwsBasicCredentials.create(AWS_ACCESS_KEY_ID, AWS_SECRET_ACCESS_KEY);

        SsmClient ssmClient = SsmClient.builder()
                .region(Region.EU_WEST_2)
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .build();

        try {
            log.info("Getting App Parameters.");

            String[] keys = {CII_API_KEY, CII_DELETE_TOKEN, CII_ORIGIN, CONCLAVE_API_KEY, CONCLAVE_ORIGIN, SEND_USER_REGISTRATION_EMAIL, ACCOUNT_VERIFIED, CONCLAVE_CONFIG_KEY, CONCLAVE_USER_KEY};

            for (String key : keys) {
                GetParameterResponse parameterResponse = getGetParameterResponse(ssmClient, key);
                switch (key) {
                    case CII_API_KEY -> setCiiApiKey(parameterResponse.parameter().value());
                    case CII_DELETE_TOKEN -> setCiiDeleteToken(parameterResponse.parameter().value());
                    case CII_ORIGIN -> setCiiOrigin(parameterResponse.parameter().value());
                    case CONCLAVE_ORIGIN -> setConclaveOrigin(parameterResponse.parameter().value());
                    case CONCLAVE_API_KEY -> setConclaveApiKey(parameterResponse.parameter().value());
                    case CONCLAVE_CONFIG_KEY -> setConclaveConfigApiKey(parameterResponse.parameter().value());
                    case CONCLAVE_USER_KEY -> setConclaveUserApiKey(parameterResponse.parameter().value());
                    case SEND_USER_REGISTRATION_EMAIL -> setSendUserRegistrationEmail(parseBoolean(parameterResponse.parameter().value()));
                    case ACCOUNT_VERIFIED -> setAccountVerified(parseBoolean(parameterResponse.parameter().value()));
                    default -> throw new IllegalStateException("Unexpected value: " + key);
                }
            }
            log.info("Application Parameters Configured Successfully.");
            return true;

        } catch (SsmException e) {
            log.error("AWS SSM Config Error: %s : %s".formatted(e.getMessage(), AWS_SECRETS));
            return false;
        }
    }

    private static GetParameterResponse getGetParameterResponse(SsmClient ssmClient, String key) {
        GetParameterRequest awsParameter = GetParameterRequest.builder()
                .name("/conclave-data-migration/" + key).withDecryption(true)
                .build();

        return ssmClient.getParameter(awsParameter);
    }
}
