package com.pkielbasa.pocketplan.application.util;

import com.pkielbasa.pocketplan.application.exception.ResourceNotFoundException;
import com.pkielbasa.pocketplan.domain.model.Budget;
import com.pkielbasa.pocketplan.domain.model.Transaction;
import com.pkielbasa.pocketplan.domain.repository.BudgetRepository;
import com.pkielbasa.pocketplan.domain.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EntityFetcherService {

    private final TransactionRepository transactionRepository;
    private final BudgetRepository budgetRepository;

    public Transaction fetchTransactionOrThrow(Long id) {
        return transactionRepository.getTransactionById(id).orElseThrow(()-> new ResourceNotFoundException("Transaction by id: " + id + " not found"));
    }

    public Budget fetchBudgetOrThrow(Long id) {
        return budgetRepository.getBudgetById(id).orElseThrow(()-> new ResourceNotFoundException("Budget by id: " + id + " not found"));
    }
}
