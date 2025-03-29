package com.la.lab.contract.mapper;

import com.la.lab.contract.dto.ContractDto;
import com.la.lab.contract.model.Contract;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContractMapper {
    ContractMapper INSTANCE = Mappers.getMapper(ContractMapper.class);

    Contract contratDtoToContrat(ContractDto contractDto);
    ContractDto contratToContratDto(Contract contract);

    List<ContractDto> contratsToContratDtos(List<Contract> contracts);



}
