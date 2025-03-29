package com.la.lab.contract;

import com.la.lab.contract.dto.ContractDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contracts")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @GetMapping
    public List<ContractDto> getAllContracts() {
        return contractService.getAllContracts();
    }

    @GetMapping("/{id}")
    public ContractDto getContractById(@PathVariable long id) {
        return contractService.getContractById(id);
    }

    @PostMapping
    public ContractDto createContract(@RequestBody ContractDto contractDto) {
        return contractService.saveContract(contractDto);
    }

    @PutMapping("/{id}")
    public ContractDto updateContract(@PathVariable long id, @RequestBody ContractDto contractDto) {
        return contractService.updateContract(id, contractDto);
    }

    @DeleteMapping("/{id}")
    public void deleteContract(@PathVariable long id) {
        contractService.deleteContract(id);
    }
}