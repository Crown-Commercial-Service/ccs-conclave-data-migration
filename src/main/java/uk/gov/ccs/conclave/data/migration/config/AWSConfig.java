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

    public static void main(String[] args) {
        System.out.println("\nHERE-->0001!!\n");
        System.out.println(awsId);
        System.out.println(awsSecretId);
        System.out.println("\nHERE-->0002!!\n");
        AwsCredentials credentials = AwsBasicCredentials.create("client_id_string", "client_secret_string");

        SsmClient ssmClient = SsmClient.builder()
                .region(Region.EU_WEST_2)
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .build();

        try {
            GetParameterRequest parameterRequest = GetParameterRequest.builder()
                .name("/conclave-cii/SALESFORCE_AUTH_URL").withDecryption(true)
                .build();

            GetParameterResponse parameterResponse = ssmClient.getParameter(parameterRequest);
            System.out.println("HERE-->3!!  The parameter value is: "+parameterResponse.parameter().value());

        } catch (SsmException e) {
        System.err.println(e.getMessage());
        System.exit(1);
        }
   }

    /*private static CfCredentials getVaultCredentials() {
        //CfEnv cfEnv = new CfEnv();
        //System.out.println("\nHERE-->0001!!\n");
        //System.out.println(cfEnv.findCredentialsByName("conclave-data-migration-integration-ssm-service"));
        //System.out.println(cfEnv.findCredentialsByLabel("user-provided"));
        //System.out.println(cfEnv.findCredentialsByTag("aws-ssm"));
        //CfCredentials awsCredentials = cfEnv.findCredentialsByTag("aws-ssm");
        //String awsId = awsCredentials.getString("aws_access_key_id");
        //String awsSecretId = awsCredentials.getString("aws_access_key_id");
        //System.out.println(cfEnv.findAllServices());
        System.out.println("\nHERE-->0002!!\n");
        return cfEnv.findCredentialsByLabel("hashicorp-vault");
    }*/
}
