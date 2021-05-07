package edu.wsb.authdemo.auth;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {

    Person findByUsername(String username);
}
