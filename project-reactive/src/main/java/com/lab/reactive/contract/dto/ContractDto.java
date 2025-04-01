package com.lab.reactive.contract.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
public class ContractDto {
    private Long id;
    private String type;
    private Long personneId;
    private LocalDate createDate;
    private LocalDate updateDate;
}