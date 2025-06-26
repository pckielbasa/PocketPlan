package com.pkielbasa.pocketplan.api.rest;

import com.pkielbasa.pocketplan.application.dto.CreateTransactionRequest;
import com.pkielbasa.pocketplan.application.service.TransactionService;
import com.pkielbasa.pocketplan.domain.model.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping
    ResponseEntity<String> createTransaction(@RequestBody CreateTransactionRequest request) {
        try{
            transactionService.createTransaction(request);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
