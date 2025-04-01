package com.lab.jpa.person.mapper;

import com.lab.jpa.person.dto.PersonDto;
import com.lab.jpa.person.model.Person;
import com.lab.jpa.person.dto.PersonDto;
import com.lab.jpa.person.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    Person personDtoToPerson(PersonDto personDto);
    PersonDto personToPersonDto(Person person);

    List<PersonDto> personsToPersonDtos(List<Person> person);



}
