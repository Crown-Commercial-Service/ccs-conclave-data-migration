package uk.gov.ccs.conclave.data;

import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

public class DataMigrationApp {
    private final static Logger log = Logger.getLogger(DataMigrationApp.class.getName());

    public static void main(String[] args) {
        log.log(INFO, "Initialised Conclave Data Migration service.");
    }
}
