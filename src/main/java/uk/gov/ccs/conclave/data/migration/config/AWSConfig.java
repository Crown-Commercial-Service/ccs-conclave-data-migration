package uk.gov.ccs.conclave.data.migration.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.pivotal.cfenv.core.CfCredentials;
import io.pivotal.cfenv.core.CfEnv;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ssm.SsmClient;
import software.amazon.awssdk.services.ssm.model.GetParameterRequest;
import software.amazon.awssdk.services.ssm.model.GetParameterResponse;
import software.amazon.awssdk.services.ssm.model.SsmException;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("cloud")
public class AWSConfig {
    private static final Logger log = LoggerFactory.getLogger(AWSConfig.class);
    private static final CfEnv cfEnv = new CfEnv();
    private static final CfCredentials awsCredentials = cfEnv.findCredentialsByTag("aws-ssm");
    private static final String awsId = awsCredentials.getString("aws_access_key_id");
    private static final String awsSecretId = awsCredentials.getString("aws_secret_access_key");
    private static final Boolean credsTest = getAWSSecrets();

    private static Boolean getAWSSecrets() {
        System.out.println("HERE-->00000!!! Key: "+awsId);
        log.info("Configuring AWS SSM Credentials & Client.");
        AwsCredentials credentials = AwsBasicCredentials.create(awsId, awsSecretId);

        SsmClient ssmClient = SsmClient.builder()
                .region(Region.EU_WEST_2)
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .build();

        try {
            System.out.println("HERE-->00001!!!");
            log.info("Getting App Parameters.");
            String[] keys = {"ciiApiKey", "ciiDeleteToken", "ciiOrigin", "conclaveApiKey", "conclaveOrigin", "sendUserRegistrationEmail", "accountVerified"};

            for (String key : keys) {
                System.out.println("HERE-->00002!!!  "+key);

                GetParameterRequest awsParameter = GetParameterRequest.builder()
                        .name("/conclave-data-migration/"+key).withDecryption(true)
                        .build();

                GetParameterResponse parameterResponse = ssmClient.getParameter(awsParameter);
                System.out.println("HERE-->00003!!!  "+key+": "+parameterResponse.parameter().value());

                switch(key) {
                    case "ciiApiKey":
                        System.out.println("HERE-->0000A!!!");
                        MigrationProperties.setCiiApiKey(parameterResponse.parameter().value());
                        break;
                    case "ciiDeleteToken":
                        System.out.println("HERE-->0000B!!!");
                        MigrationProperties.setCiiDeleteToken(parameterResponse.parameter().value());
                        break;
                    case "ciiOrigin":
                        System.out.println("HERE-->0000C!!!");
                        MigrationProperties.setCiiOrigin(parameterResponse.parameter().value());
                        break;
                    case "conclaveApiKey":
                        System.out.println("HERE-->0000D!!!");
                        MigrationProperties.setConclaveApiKey(parameterResponse.parameter().value());
                        break;
                    case "conclaveOrigin":
                        System.out.println("HERE-->0000E!!!");
                        MigrationProperties.setConclaveOrigin(parameterResponse.parameter().value());
                        break;
                    case "sendUserRegistrationEmail":
                        System.out.println("HERE-->0000F!!!");
                        MigrationProperties.setSendUserRegistrationEmail(Boolean.parseBoolean(parameterResponse.parameter().value()));
                        break;
                    case "accountVerified":
                        System.out.println("HERE-->0000G!!!");
                        MigrationProperties.setAccountVerified(Boolean.parseBoolean(parameterResponse.parameter().value()));
                        break;
                }
            }
            log.info("Application Parameters Configured Successfully.");
            return true;

        } catch (SsmException e) {
            System.out.println("HERE-->0000ERROR!!!");
            log.error("AWS SSM Config Error: "+e.getMessage()+" : "+credsTest);
            return false;
        }
   }
}
