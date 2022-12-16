package uk.gov.ccs.conclave.data.migration.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MigrationProperties {

    private static String ciiApiKey;

    private static String ciiDeleteToken;

    private static String ciiOrigin;

    private static String conclaveApiKey;

    private static String conclaveOrigin;

    private static boolean sendUserRegistrationEmail;

    private static boolean accountVerified;

    public static String getCiiApiKey() {
        return ciiApiKey;
    }

    public static void setCiiApiKey(String ciiApiKey) {
        MigrationProperties.ciiApiKey = ciiApiKey;
    }

    public static String getCiiDeleteToken() {
        return ciiDeleteToken;
    }

    public static void setCiiDeleteToken(String ciiDeleteToken) {
        MigrationProperties.ciiDeleteToken = ciiDeleteToken;
    }

    public static String getCiiOrigin() {
        return ciiOrigin;
    }

    public static void setCiiOrigin(String ciiOrigin) {
        MigrationProperties.ciiOrigin = ciiOrigin;
    }

    public static String getConclaveApiKey() {
        return conclaveApiKey;
    }

    public static void setConclaveApiKey(String conclaveApiKey) {
        MigrationProperties.conclaveApiKey = conclaveApiKey;
    }

    public static String getConclaveOrigin() {
        return conclaveOrigin;
    }

    public static void setConclaveOrigin(String conclaveOrigin) {
        MigrationProperties.conclaveOrigin = conclaveOrigin;
    }

    public static boolean isSendUserRegistrationEmail() {
        return sendUserRegistrationEmail;
    }

    public static void setSendUserRegistrationEmail(boolean sendUserRegistrationEmail) {
        MigrationProperties.sendUserRegistrationEmail = sendUserRegistrationEmail;
    }

    public static boolean isAccountVerified() {
        return accountVerified;
    }

    public static void setAccountVerified(boolean accountVerified) {
        MigrationProperties.accountVerified = accountVerified;
    }
}
