package edu.wsb.authdemo;

import edu.wsb.authdemo.auth.Authority;
import edu.wsb.authdemo.auth.AuthorityName;
import edu.wsb.authdemo.auth.AuthorityRepository;
import edu.wsb.authdemo.auth.PersonService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service
public class Bootstrap implements InitializingBean {

    private final AuthorityRepository authorityRepository;
    private final PersonService personService;

    public Bootstrap(AuthorityRepository authorityRepository, PersonService personService) {
        this.authorityRepository = authorityRepository;
        this.personService = personService;
    }

    @Override
    public void afterPropertiesSet() {
        prepareAuthorities();

        personService.prepareAdmin();
    }

    private void prepareAuthorities() {
        for (AuthorityName authorityName : AuthorityName.values()) {
            Authority existingAuthority = authorityRepository.findByName(authorityName);

            if (existingAuthority != null) {
                System.out.println("Uprawnienie " + authorityName.name() + " już istnieje.");
                continue;
            }

            System.out.println("Zapisujemy nowe uprawnienie " + authorityName.name() + "...");

            Authority newAuthority = new Authority(authorityName);
            authorityRepository.save(newAuthority);
        }
    }
}
