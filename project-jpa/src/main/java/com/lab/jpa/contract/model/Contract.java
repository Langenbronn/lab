package com.lab.jpa.contract.model;

import com.lab.jpa.person.model.Person;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity(name = "contract")
@NoArgsConstructor
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    private LocalDate createDate;
    private LocalDate updateDate;
    @OneToOne
    @JoinColumn(name = "personne_id")
    private Person person;

}