package uk.gov.ccs.conclave.data.migration.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;
import java.security.NoSuchAlgorithmException;

@Service
@RequiredArgsConstructor
public class AuthorizationService {
    
    private static final Logger log = LoggerFactory.getLogger(ContactService.class);

    private static String randomAESKeyGen() throws NoSuchAlgorithmException {

        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        SecretKey secretKey = keyGen.generateKey();
        byte[] encoded = secretKey.getEncoded();
        return DatatypeConverter.printHexBinary(encoded);
    }

    public static String createNewApiKey() {
        String key = null;
            try {
                key = AuthorizationService.randomAESKeyGen();
                log.info("Successfully generated new key.");
            } catch (NoSuchAlgorithmException e) {
                log.error("Exception caught when creating new key.");
                e.printStackTrace();
            }
            return key;
    }
}
