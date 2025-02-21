package com.school.security.controllers.api;

import com.school.security.dtos.requests.TransactionReqDto;
import com.school.security.dtos.responses.TransactionResDto;
import com.school.security.services.contracts.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<TransactionResDto> findAll() {
        return this.transactionService.findAll();
    }

    @GetMapping("/{id}")
    public TransactionResDto findById(@PathVariable Long id) {
        return this.transactionService.findById(id);
    }

    @PostMapping("/register")
    public TransactionResDto save(@RequestBody TransactionReqDto toSave) {
        return this.transactionService.createOrUpdate(toSave);
    }

    @DeleteMapping("/{id}")
    public TransactionResDto delete(@PathVariable Long id) {
        return this.transactionService.deleteById(id);
    }
}
