package uk.gov.ccs.conclave.data.migration.config;

import java.util.ArrayList;
import java.util.List;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ssm.SsmClient;
import software.amazon.awssdk.services.ssm.model.GetParameterRequest;
import software.amazon.awssdk.services.ssm.model.GetParameterResponse;
import software.amazon.awssdk.services.ssm.model.SsmException;

public class AwsSsmConfig {
 
    private final static String[] varsList = {"ciiApiKey","ciiOrigin","conclaveApiKey","conclaveOrigin","sendUserRegistrationEmail","accountVerified"};

    /*public static void main(String[] args) {
        final String id = "";
        final String secret = "/fmKld";

        AwsCredentials credentials = AwsBasicCredentials.create(id, secret);

        SsmClient ssmClient = SsmClient.builder()
            .region(Region.EU_WEST_2)
            .credentialsProvider(StaticCredentialsProvider.create(credentials))
            .build();

        List<String> secrets = new ArrayList<String>();
        for (String var : varsList) {
            secrets.add(getSsmParameter(ssmClient, var));
        }

        ssmClient.close();
        System.out.println(secrets);
    }*/

    public static List<String> configAwsClient(String awsAccessKey, String awsSecretAccessKey) {
        AwsCredentials credentials = AwsBasicCredentials.create(awsAccessKey, awsSecretAccessKey);

        SsmClient ssmClient = SsmClient.builder()
            .region(Region.EU_WEST_2)
            .credentialsProvider(StaticCredentialsProvider.create(credentials))
            .build();

        List<String> secrets = new ArrayList<String>();
        for (String var : varsList) {
            secrets.add(getSsmParameter(ssmClient, var));
        }

        ssmClient.close();
        return secrets;
    }

    private static String getSsmParameter(SsmClient ssmClient, String parameterName) {
        String parameterPath = String.format("/conclave-data-migration/%s", parameterName);

        try {
            GetParameterRequest parameterRequest = GetParameterRequest.builder()
                .name(parameterPath).withDecryption(true)
                .build();

            GetParameterResponse parameterResponse = ssmClient.getParameter(parameterRequest);
            System.out.println(String.format("\nThe paramter  '%s'  value is  '%s';\n", parameterName, parameterResponse.parameter().value()));
            return parameterResponse.parameter().value();

        } catch (SsmException e) {
            System.err.println(e.getMessage());
            return "ERROR_GETTING_VALUE_FROM_AWS";
        }
    }
}
