package com.la.lab.person.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
public class PersonDto {

    private Long id;
    private String firstName;
    private String lastName;
    private int age;

    public PersonDto() {
    }
}