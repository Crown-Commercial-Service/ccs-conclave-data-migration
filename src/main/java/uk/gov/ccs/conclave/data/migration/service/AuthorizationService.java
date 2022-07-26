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

    private static String randomAESKeyGen(final int keyLen) throws NoSuchAlgorithmException {

        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(keyLen);
        SecretKey secretKey = keyGen.generateKey();
        byte[] encoded = secretKey.getEncoded();
        return DatatypeConverter.printHexBinary(encoded);
    }

    public static String createNewApiKey() {
        String key = null;
            try {
                key = AuthorizationService.randomAESKeyGen(256);
                log.info("Successfully created new API key.");
            } catch (NoSuchAlgorithmException e) {
                log.error("Exception caught when creating new API key.");
                e.printStackTrace();
            }
            System.out.println(key);
            return key;
    }
}
