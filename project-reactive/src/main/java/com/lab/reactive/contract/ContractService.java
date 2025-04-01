package com.lab.reactive.contract;

import com.lab.reactive.contract.dto.ContractDto;
import com.lab.reactive.contract.mapper.ContractMapper;
import com.lab.reactive.contract.model.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ContractService {

    @Autowired
    private com.lab.reactive.contract.ContractRepository contractRepository;
    private final ContractMapper contractMapper = ContractMapper.INSTANCE;

    public ContractService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    public Flux<ContractDto> getAllContracts() {
        return Flux.fromIterable(contractMapper.contratsToContratDtos(contractRepository.findAll()));
    }

    public Mono<ContractDto> getContractById(final Long id) {
        return Mono.just(contractRepository.findById(id)
                .map(contractMapper::contratToContratDto)
                .orElseThrow());
    }

    public Mono<ContractDto> updateContract(final Long id, ContractDto ContractDto) {
        contractRepository.findById(id).orElseThrow();
        Contract contract = contractMapper.contratDtoToContrat(ContractDto);
        contract.setId(id);
        return Mono.just(contractMapper.contratToContratDto(contractRepository.save(contract)));
    }

    public Mono<ContractDto> saveContract(final ContractDto ContractDto) {
        Contract contract = contractMapper.contratDtoToContrat(ContractDto);
        return Mono.just(contractMapper.contratToContratDto(contractRepository.save(contract)));
    }

    public void deleteContract(final Long id) {
        contractRepository.findById(id).orElseThrow();
        contractRepository.deleteById(id);
    }
}