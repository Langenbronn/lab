package com.lab.reactive.contract.model;

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
    private com.lab.reactive.person.model.Person person;

}