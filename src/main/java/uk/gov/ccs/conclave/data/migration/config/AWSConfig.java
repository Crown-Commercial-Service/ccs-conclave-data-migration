package uk.gov.ccs.conclave.data.migration.config;

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

    private static final CfEnv cfEnv = new CfEnv();
    private static final CfCredentials awsCredentials = cfEnv.findCredentialsByTag("aws-ssm");
    private static final String awsId = awsCredentials.getString("aws_access_key_id");
    private static final String awsSecretId = awsCredentials.getString("aws_secret_access_key");
    private static final Boolean credsTest = getAWSSecrets();

    private static Boolean getAWSSecrets() {
        System.out.println("HERE-->00000!!! Key: "+awsId);
        AwsCredentials credentials = AwsBasicCredentials.create(awsId, awsSecretId);

        SsmClient ssmClient = SsmClient.builder()
                .region(Region.EU_WEST_2)
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .build();

        try {
            System.out.println("HERE-->00001!!!");
            String[] keys = {"ciiApiKey", "ciiDeleteToken", "ciiOrigin", "conclaveApiKey", "conclaveOrigin", "sendUserRegistrationEmail", "accountVerified"};

            for (String key : keys) {
                System.out.println("HERE-->00002!!!  "+key);

                GetParameterRequest awsParameter = GetParameterRequest.builder()
                        .name("/conclave-data-migration/"+key).withDecryption(true)
                        .build();

                GetParameterResponse parameterResponse = ssmClient.getParameter(awsParameter);
                System.out.println("HERE-->00003!!!  "+key+": "+parameterResponse.parameter().value());
                //MigrationProperties.setCiiOrigin(parameterResponse1.parameter().value());
            }

            return true;

        } catch (SsmException e) {
        System.out.println("HERE-->0000E!!!");
        System.err.println(e.getMessage());
        System.exit(1);
        System.out.println(credsTest);
        return false;
        }
   }
}
