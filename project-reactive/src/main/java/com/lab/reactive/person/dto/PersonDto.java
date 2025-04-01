package com.lab.reactive.person.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class PersonDto {

    private Long id;
    private String firstName;
    private String lastName;
    private int age;

}