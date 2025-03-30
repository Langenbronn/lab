package com.la.lab.contract;

import com.la.lab.contract.dto.ContractDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/contracts")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @GetMapping
    public Flux<ContractDto> getAllContracts() {
        return contractService.getAllContracts();
    }

    @GetMapping("/{id}")
    public Mono<ContractDto> getContractById(@PathVariable long id) {
        return contractService.getContractById(id);
    }

    @PostMapping
    public Mono<ContractDto> createContract(@RequestBody ContractDto contractDto) {
        return contractService.saveContract(contractDto);
    }

    @PutMapping("/{id}")
    public Mono<ContractDto> updateContract(@PathVariable long id, @RequestBody ContractDto contractDto) {
        return contractService.updateContract(id, contractDto);
    }

    @DeleteMapping("/{id}")
    public void deleteContract(@PathVariable long id) {
        contractService.deleteContract(id);
    }
}