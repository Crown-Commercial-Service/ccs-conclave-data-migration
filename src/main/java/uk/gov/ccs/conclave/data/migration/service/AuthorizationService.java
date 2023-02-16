package uk.gov.ccs.conclave.data.migration.service;

import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.gov.ccs.conclave.data.migration.domain.Client;

import javax.crypto.KeyGenerator;
import static javax.xml.bind.DatatypeConverter.printHexBinary;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@Primary
@RequiredArgsConstructor
public class AuthorizationService implements JpaRepository<Client, Long> {

    private static final Logger log = LoggerFactory.getLogger(ContactService.class);

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
        return this.save(client);
    }

    private Optional<Client> findApiKey(String key) {
        log.info("Checking for x-api-key in the database.");
        return this.findByApiKey(key);
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

    @Override
    public List<Client> findAll() {
        return null;
    }

    @Override
    public List<Client> findAll(Sort sort) {
        return null;
    }

    Optional<Client> findByApiKey(String apiKey) {
        return Optional.empty();
    }

    @Override
    public Page<Client> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Client> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Client entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Client> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Client> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Client> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Client> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Client> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Client> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Client> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Client getOne(Long aLong) {
        return null;
    }

    @Override
    public Client getById(Long aLong) {
        return null;
    }

    @Override
    public Client getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Client> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Client> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Client> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Client> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Client> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Client> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Client, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}

