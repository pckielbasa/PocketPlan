package com.pkielbasa.pocketplan.api.rest;

import com.pkielbasa.pocketplan.api.mapper.TransactionMapper;
import com.pkielbasa.pocketplan.api.dto.transaction.CreateTransactionRequest;
import com.pkielbasa.pocketplan.api.dto.transaction.TransactionResponse;
import com.pkielbasa.pocketplan.application.exception.ResourceNotFoundException;
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

    @GetMapping("/{id}")
    ResponseEntity<Transaction> getTransactionById(@PathVariable("id") long id) {
        Transaction transaction = transactionService.getTransaction(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction with id " + id + " not found"));
        return ResponseEntity.ok(transaction);
    }

    @PostMapping
    ResponseEntity<TransactionResponse> createTransaction(@RequestBody CreateTransactionRequest request) {
        try {
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

    @GetMapping("/search")
    ResponseEntity<List<TransactionResponse>> getAllTransactions() {
        return ResponseEntity.ok(transactionService.getAllTransactions().stream()
                .map(TransactionMapper::mapToResponse).collect(Collectors.toList()));
    }

    @GetMapping("/search/sort")
    ResponseEntity<List<TransactionResponse>> getSortTransactionsAsc(@RequestParam String sortBy,
                                                                     @RequestParam String direction) {
        List<Transaction> transactions = transactionService.getSortedTransaction(sortBy, direction);
        List<TransactionResponse> responses = transactions.stream()
                .map(TransactionMapper::mapToResponse)
                .toList();

        return ResponseEntity.ok(responses);
    }

    @PutMapping("/{id}")
    ResponseEntity<TransactionResponse> updateTransaction(@PathVariable("id") long id,
                                                          @RequestBody CreateTransactionRequest request) {
        return ResponseEntity.ok(TransactionMapper.mapToResponse(transactionService.updateTransaction(request, id)));
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Void> deleteTransaction(@PathVariable long id) {
        transactionService.deleteTransactionById(id);
        return ResponseEntity.noContent().build();
    }
}
