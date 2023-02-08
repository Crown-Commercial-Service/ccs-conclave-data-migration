package uk.gov.ccs.conclave.data.migration.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import uk.gov.ccs.conclave.data.migration.domain.Client;
import static uk.gov.ccs.conclave.data.migration.service.ErrorService.*;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorizationService {
    
    private static final Logger log = LoggerFactory.getLogger(ContactService.class);

    private final ErrorService errorService;

    private static String randomAESKeyGen(final int keyLen) throws NoSuchAlgorithmException {

        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(keyLen);
        SecretKey secretKey = keyGen.generateKey();
        byte[] encoded = secretKey.getEncoded();
        return DatatypeConverter.printHexBinary(encoded);
    }

    public boolean invalidClientApiKey(String key) {
        // The following null or empty check is not needed, but saves time/resources if we don't need to check the database.
        if (key == null || key.trim().isEmpty()) {
            return true;
        }

        Optional<Client> record = errorService.findApiKey(key);
        if (record.isPresent()) {
            return false;
        }

        return true;
    }

    public void createClientApiKey() {
        String key = null;
        try {
            key = AuthorizationService.randomAESKeyGen(256);
            log.info("Successfully generated new key.");

        } catch (NoSuchAlgorithmException e) {
            log.error("Exception caught when creating new key.");
            e.printStackTrace();
            return;
        }

        String description = "CCS Testing Team " + new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        errorService.saveNewApiKey(key, description);
    }
}
