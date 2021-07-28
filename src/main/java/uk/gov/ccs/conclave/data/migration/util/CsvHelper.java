package uk.gov.ccs.conclave.data.migration.util;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.gov.ccs.conclave.data.migration.domain.User;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Objects;

public class CsvHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(CsvHelper.class);

    public static List<User> readCsvFile(final String filename) {

        CsvToBean<User> csvToBean;
        List<User> users = null;
        try {
            csvToBean = new CsvToBeanBuilder<User>(new FileReader(filename))
                    .withType(User.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            users = Objects.requireNonNull(csvToBean).parse();

        } catch (FileNotFoundException e) {
            LOGGER.error("CSV file was not found at specified location. " + e.getMessage());

        } catch (Exception e) {
            LOGGER.error("Error while parsing CSV file. " + e.getMessage());
        }

        return users;
    }


}
