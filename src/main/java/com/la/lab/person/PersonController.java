package com.la.lab.person;

import com.la.lab.person.dto.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public List<PersonDto> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    public PersonDto getPersonById(@PathVariable long id) {
        return personService.getPersonById(id);
    }

    @PostMapping
    public PersonDto createPerson(@RequestBody PersonDto personDto) {
        return personService.savePerson(personDto);
    }

    @PutMapping("/{id}")
    public PersonDto updatePerson(@PathVariable long id, @RequestBody PersonDto personDto) {
        return personService.updatePerson(id, personDto);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable long id) {
        personService.deletePerson(id);
    }
}