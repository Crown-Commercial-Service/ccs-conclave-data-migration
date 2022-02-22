package uk.gov.ccs.conclave.data.migration.exception;

public class DataMigrationException extends Exception {

    private final Integer code;

    public DataMigrationException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
