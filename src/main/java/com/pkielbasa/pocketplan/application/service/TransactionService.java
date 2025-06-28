package com.pkielbasa.pocketplan.application.service;

import com.pkielbasa.pocketplan.api.mapper.TransactionMapper;
import com.pkielbasa.pocketplan.application.dto.transaction.CreateTransactionRequest;
import com.pkielbasa.pocketplan.application.exception.ResourceNotFoundException;
import com.pkielbasa.pocketplan.domain.model.Budget;
import com.pkielbasa.pocketplan.domain.model.Transaction;
import com.pkielbasa.pocketplan.domain.repository.BudgetRepository;
import com.pkielbasa.pocketplan.domain.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final BudgetRepository budgetRepository;

    public Optional<Transaction> getTransaction(long id) {
        return transactionRepository.getTransactionById(id);
    }

    public Transaction createTransaction(CreateTransactionRequest request) {
        Budget budget = budgetRepository.findBudgetById(request.budgetId())
                .orElseThrow(() -> new ResourceNotFoundException("Budget by id: "+ request.budgetId() +" not found"));
        return transactionRepository.createTransaction(TransactionMapper.mapToEntity(request, budget));
    }

    public List<Transaction> getTransactionByName(String name) {
        return transactionRepository.getTransactionByName(name);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.getAllTransactions();
    }

    public List<Transaction> getSortedTransaction(String sortBy, String direction) {
        Sort.Direction dir = Sort.Direction.fromString(direction);
        return transactionRepository.getSortedTransaction(Sort.by(dir, sortBy));
    }

    public Transaction updateTransaction(CreateTransactionRequest request, long id) {
        Transaction oldTransaction = transactionRepository.getTransactionById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction by id: "+ id +" not found"));
        Budget budget = budgetRepository.findBudgetById(request.budgetId())
                .orElseThrow(() -> new ResourceNotFoundException("Budget by id: "+ request.budgetId() +" not found"));
        TransactionMapper.updateEntity(oldTransaction, request, budget);
        return transactionRepository.updateTransaction(oldTransaction);
    }

    public void deleteTransactionById(long id) {
        transactionRepository.deleteTransactionById(id);
    }

}
