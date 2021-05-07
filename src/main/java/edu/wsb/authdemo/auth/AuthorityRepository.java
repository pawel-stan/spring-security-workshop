package edu.wsb.authdemo.auth;

import org.springframework.data.repository.CrudRepository;

public interface AuthorityRepository extends CrudRepository<Authority, Long> {

    Authority findByName(AuthorityName name);
}
