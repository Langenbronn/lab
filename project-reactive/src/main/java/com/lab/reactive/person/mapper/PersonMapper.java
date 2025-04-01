package com.lab.reactive.person.mapper;

import com.lab.reactive.person.dto.PersonDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    com.lab.reactive.person.model.Person personDtoToPerson(PersonDto personDto);
    PersonDto personToPersonDto(com.lab.reactive.person.model.Person person);

    List<PersonDto> personsToPersonDtos(List<com.lab.reactive.person.model.Person> person);



}
