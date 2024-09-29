package com.la.lab.person;

import com.la.lab.person.dto.PersonDto;
import com.la.lab.person.mapper.PersonMapper;
import com.la.lab.person.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;
    private final  PersonMapper personMapper = PersonMapper.INSTANCE;

    public List<PersonDto> getAllPersons() {
        return personMapper.personsToPersonDtos(personRepository.findAll());
    }

    public PersonDto getPersonById(final long id) {
        return personRepository.findById(id)
                .map(person -> personMapper.personToPersonDto(person))
                .orElseThrow();
    }

    public PersonDto updatePerson(long id, PersonDto personDto) {
        personRepository.findById(id).orElseThrow();
        Person person = personMapper.personDtoToPerson(personDto);
        person.setId(id);
        return personMapper.personToPersonDto(personRepository.save(person));
    }

    public PersonDto savePerson(PersonDto personDto) {
//        TODO check if already exist
        Person person = personMapper.personDtoToPerson(personDto);
        return personMapper.personToPersonDto(personRepository.save(person));
    }

    public void deletePerson(long id) {
        personRepository.findById(id).orElseThrow();
        personRepository.deleteById(id);
    }
}