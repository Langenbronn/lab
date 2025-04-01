package com.lab.reactive.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<com.lab.reactive.person.model.Person, Long> {
    Optional<com.lab.reactive.person.model.Person> findById(long id);

    void deleteById(long id);
}