package com.la.lab.contract;

import com.la.lab.contract.dto.ContractDto;
import com.la.lab.contract.mapper.ContractMapper;
import com.la.lab.contract.model.Contract;
import com.la.lab.person.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {

    @Autowired
    private ContractRepository contractRepository;
    private final ContractMapper contractMapper = ContractMapper.INSTANCE;

    public ContractService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    public List<ContractDto> getAllContracts() {
        return contractMapper.contratsToContratDtos(contractRepository.findAll());
    }

    public ContractDto getContractById(final Long id) {
        return contractRepository.findById(id)
                .map(contractMapper::contratToContratDto)
                .orElseThrow();
    }

    public ContractDto updateContract(final Long id, ContractDto ContractDto) {
        contractRepository.findById(id).orElseThrow();
        Contract contract = contractMapper.contratDtoToContrat(ContractDto);
        contract.setId(id);
        return contractMapper.contratToContratDto(contractRepository.save(contract));
    }

    public ContractDto saveContract(final ContractDto ContractDto) {
        Contract contract = contractMapper.contratDtoToContrat(ContractDto);
        return contractMapper.contratToContratDto(contractRepository.save(contract));
    }

    public void deleteContract(final Long id) {
        contractRepository.findById(id).orElseThrow();
        contractRepository.deleteById(id);
    }
}