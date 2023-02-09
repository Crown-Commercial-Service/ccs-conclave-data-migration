package uk.gov.ccs.conclave.data.migration.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.KeyGenerator;
import static javax.xml.bind.DatatypeConverter.printHexBinary;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthorizationService {

    private final ErrorService errorService;
    private static final Logger log = LoggerFactory.getLogger(ContactService.class);

    private String generateRandomAESKey() throws NoSuchAlgorithmException {

        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256);
        byte[] encoded = keyGenerator.generateKey().getEncoded();
        return printHexBinary(encoded);
    }

    public Boolean isClientApiKeyValid(String key) {
        if (key == null || key.trim().isEmpty()) {
            return Boolean.FALSE;
        }

        return errorService.findApiKey(key).isPresent() ? Boolean.TRUE : Boolean.FALSE;
    }

    public void createClientApiKey() {
        String key;
        try {
            key = generateRandomAESKey();
            log.info("Successfully generated new key.");
        } catch (NoSuchAlgorithmException e) {
            log.error("Error while generating new key: " + e.getMessage());
            e.printStackTrace();
            return;
        }

        errorService.saveNewApiKey(key, ("CCS Testing Team " + new SimpleDateFormat("dd-MM-yyyy").format(new Date())));
    }
}

