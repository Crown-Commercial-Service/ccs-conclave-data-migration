package uk.gov.ccs.conclave.data.migration.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.gov.ccs.conclave.data.migration.domain.Client;
import uk.gov.ccs.conclave.data.migration.repository.ClientRepository;

import javax.crypto.KeyGenerator;
import static javax.xml.bind.DatatypeConverter.printHexBinary;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorizationService {

    private static final Logger log = LoggerFactory.getLogger(ContactService.class);
    private final ClientRepository clientRepository;

    private String generateRandomAESKey() throws NoSuchAlgorithmException {

        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256);
        byte[] encoded = keyGenerator.generateKey().getEncoded();
        return printHexBinary(encoded);
    }

    private Client saveNewApiKey(String key, String description) {
        log.info("Key and details can be found in database.");
        Client client = new Client();
        client.setApiKey(key);
        client.setClientKeyDescription(description);
        return clientRepository.save(client);
    }

    private Optional<Client> findApiKey(String key) {
        log.info("Checking for x-api-key in the database.");
        return clientRepository.findByApiKey(key);
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

        saveNewApiKey(key, ("CCS Testing Team " + new SimpleDateFormat("dd-MM-yyyy").format(new Date())));
    }

    public Boolean isClientApiKeyValid(String key) {
        if (key == null || key.trim().isEmpty()) {
            return Boolean.FALSE;
        }

        return findApiKey(key).isPresent() ? Boolean.TRUE : Boolean.FALSE;
    }
}

