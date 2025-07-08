package com.pkielbasa.pocketplan.api.rest;

import com.pkielbasa.pocketplan.api.dto.criteria.TransactionSearchCriteria;
import com.pkielbasa.pocketplan.api.dto.transaction.UpdateTransactionRequest;
import com.pkielbasa.pocketplan.api.mapper.TransactionMapper;
import com.pkielbasa.pocketplan.api.dto.transaction.CreateTransactionRequest;
import com.pkielbasa.pocketplan.api.dto.transaction.TransactionResponse;
import com.pkielbasa.pocketplan.application.service.TransactionService;
import com.pkielbasa.pocketplan.application.util.UriBuilder;
import com.pkielbasa.pocketplan.domain.model.Transaction;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;
    private final UriBuilder uriBuilder;

    @GetMapping("/{id}")
    ResponseEntity<TransactionResponse> getTransactionById(@PathVariable("id") long id) {
        return ResponseEntity.ok(transactionService.getTransaction(id));
    }

    @PostMapping
    ResponseEntity<TransactionResponse> createTransaction(@Valid @RequestBody CreateTransactionRequest request) {
        TransactionResponse transactionResponse = transactionService.createTransaction(request);
        URI location = uriBuilder.buildUri(transactionResponse.id());
        return ResponseEntity.created(location).body(transactionResponse);
    }

    @GetMapping()
    ResponseEntity<List<TransactionResponse>> getTransactions(TransactionSearchCriteria transactionSearchCriteria) {
        List<Transaction> transactions = transactionService.getTransactions(transactionSearchCriteria);
        List<TransactionResponse> responses = transactions.stream()
                .map(TransactionMapper::mapToResponse)
                .toList();
        return ResponseEntity.ok(responses);
    }

    @PutMapping("/{id}")
    ResponseEntity<TransactionResponse> updateTransaction(@PathVariable("id") long id,
                                                          @RequestBody UpdateTransactionRequest request) {
        return ResponseEntity.ok(TransactionMapper.mapToResponse(transactionService.updateTransaction(request, id)));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteTransaction(@PathVariable long id) {
        transactionService.deleteTransactionById(id);
        return ResponseEntity.noContent().build();
    }
}
