package com.lab.jpa.person;

import com.lab.jpa.person.dto.PersonDto;
import com.lab.jpa.person.mapper.PersonMapper;
import com.lab.jpa.person.model.Person;
import com.lab.jpa.person.dto.PersonDto;
import com.lab.jpa.person.mapper.PersonMapper;
import com.lab.jpa.person.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<PersonDto> getAllPersons() {
        return personMapper.personsToPersonDtos(personRepository.findAll());
    }

    public PersonDto getPersonById(final Long id) {
        return personRepository.findById(id)
                .map(personMapper::personToPersonDto)
                .orElseThrow();
    }

    public PersonDto updatePerson(final Long id, PersonDto personDto) {
        personRepository.findById(id).orElseThrow();
        Person person = personMapper.personDtoToPerson(personDto);
        person.setId(id);
        return personMapper.personToPersonDto(personRepository.save(person));
    }

    public PersonDto savePerson(final PersonDto personDto) {
        Person person = personMapper.personDtoToPerson(personDto);
        return personMapper.personToPersonDto(personRepository.save(person));
    }

    public void deletePerson(final Long id) {
        personRepository.findById(id).orElseThrow();
        personRepository.deleteById(id);
    }
}