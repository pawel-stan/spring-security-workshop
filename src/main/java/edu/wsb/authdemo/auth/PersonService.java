package edu.wsb.authdemo.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final AuthorityRepository authorityRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Value("${my.admin.username}")
    private String myAdminUsername;

    @Value("${my.admin.password}")
    private String myAdminPassword;

    public PersonService(PersonRepository personRepository, AuthorityRepository authorityRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.personRepository = personRepository;
        this.authorityRepository = authorityRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void prepareAdmin() {
        if (personRepository.findByUsername(myAdminUsername) != null) {
            return;
        }

        String hashedPassword = bCryptPasswordEncoder.encode(myAdminPassword);
        Person person = new Person(myAdminUsername, hashedPassword, "Admin Admin");

        List<Authority> authorities = (List<Authority>) authorityRepository.findAll();
        person.setAuthorities(new HashSet<>(authorities));

        personRepository.save(person);
    }
}
