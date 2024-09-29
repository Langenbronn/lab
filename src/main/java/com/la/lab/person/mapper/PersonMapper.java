package com.la.lab.person.mapper;

import com.la.lab.person.dto.PersonDto;
import com.la.lab.person.model.Person;
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
