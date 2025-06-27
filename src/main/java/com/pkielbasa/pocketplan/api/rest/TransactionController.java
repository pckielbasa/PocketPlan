package com.pkielbasa.pocketplan.api.rest;

import com.pkielbasa.pocketplan.api.mapper.TransactionMapper;
import com.pkielbasa.pocketplan.application.dto.transaction.CreateTransactionRequest;
import com.pkielbasa.pocketplan.application.dto.transaction.TransactionResponse;
import com.pkielbasa.pocketplan.application.service.TransactionService;
import com.pkielbasa.pocketplan.domain.model.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping
    ResponseEntity<TransactionResponse> createTransaction(@RequestBody CreateTransactionRequest request) {
        try{
            Transaction transaction = transactionService.createTransaction(request);
            URI location = new URI("/api/transactions/" + transaction.getId());
            TransactionResponse response = TransactionMapper.mapToResponse(transaction);
            return ResponseEntity.created(location).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping()
    ResponseEntity<List<TransactionResponse>> getTransactionByName(@RequestParam String name) {
            List<Transaction> transactions = transactionService.getTransactionByName(name);
            List<TransactionResponse> responses = transactions.stream().map(TransactionMapper::mapToResponse).collect(Collectors.toList());
            if (responses.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        return ResponseEntity.ok(responses);
    }
}
