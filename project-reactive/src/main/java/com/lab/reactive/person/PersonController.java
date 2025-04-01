package com.lab.reactive.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public List<com.lab.reactive.person.dto.PersonDto> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    public com.lab.reactive.person.dto.PersonDto getPersonById(@PathVariable long id) {
        return personService.getPersonById(id);
    }

    @PostMapping
    public com.lab.reactive.person.dto.PersonDto createPerson(@RequestBody com.lab.reactive.person.dto.PersonDto personDto) {
        return personService.savePerson(personDto);
    }

    @PutMapping("/{id}")
    public com.lab.reactive.person.dto.PersonDto updatePerson(@PathVariable long id, @RequestBody com.lab.reactive.person.dto.PersonDto personDto) {
        return personService.updatePerson(id, personDto);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable long id) {
        personService.deletePerson(id);
    }
}