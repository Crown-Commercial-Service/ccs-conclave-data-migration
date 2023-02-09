package uk.gov.ccs.conclave.data.migration.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import static javax.xml.bind.DatatypeConverter.printHexBinary;
import java.security.NoSuchAlgorithmException;

@Service
@RequiredArgsConstructor
public class AuthorizationService {

    private final ErrorService errorService;

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
            System.out.println("Successfully generated new key.");
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error while generating new key: " + e.getMessage());
            e.printStackTrace();
            return;
        }

        errorService.saveNewApiKey(key, "CCS Dev & Test Team");
    }
}

