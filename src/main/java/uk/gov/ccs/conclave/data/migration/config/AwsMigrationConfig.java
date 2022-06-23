package uk.gov.ccs.conclave.data.migration.config;

import io.pivotal.cfenv.core.CfCredentials;
import io.pivotal.cfenv.core.CfEnv;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Map;

@Configuration
@Profile("cloud")
public class AwsMigrationConfig {

    private static final CfCredentials cfCredentials = getAwsCredentials();

    private static CfCredentials getAwsCredentials() {
        CfEnv cfEnv = new CfEnv();
        return cfEnv.findCredentialsByLabel("user-provided");
    }

    public static String getAwsAccessKeyId() {
        var awsAccessKeyId = (Map<String, String>) cfCredentials.getMap().get("aws_access_key_id");
        return awsAccessKeyId.toString();
    }

    public static String getAwsSecretAccessKey() {
        var awsSecretAccessKey = (Map<String, String>) cfCredentials.getMap().get("aws_secret_access_key");
        return awsSecretAccessKey.toString();
    }
}
