package com.lab.reactive.contract.mapper;

import com.lab.reactive.contract.dto.ContractDto;
import com.lab.reactive.contract.model.Contract;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContractMapper {
    ContractMapper INSTANCE = Mappers.getMapper(ContractMapper.class);

//    @Mapping(source = "personne.id", target = "personneId")
    Contract contratDtoToContrat(ContractDto contractDto);
//    @Mapping(source = "personne.id", target = "personneId")
    ContractDto contratToContratDto(Contract contract);

    List<ContractDto> contratsToContratDtos(List<Contract> contracts);



}
