package com.pkielbasa.pocketplan.application.util;

import com.pkielbasa.pocketplan.domain.model.Budget;
import com.pkielbasa.pocketplan.domain.model.Transaction;
import com.pkielbasa.pocketplan.domain.model.User;
import com.pkielbasa.pocketplan.domain.repository.BudgetRepository;
import com.pkielbasa.pocketplan.domain.repository.TransactionRepository;
import com.pkielbasa.pocketplan.domain.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EntityFetcherService {

    private final TransactionRepository transactionRepository;
    private final BudgetRepository budgetRepository;
    private final UserRepository userRepository;

    public Transaction fetchTransactionOrThrow(Long transactionId) {
        return transactionRepository.getTransactionById(transactionId).orElseThrow(()-> new EntityNotFoundException("Transaction by id: " + transactionId + " not found"));
    }

    public Budget fetchBudgetOrThrow(Long budgetId) {
        return budgetRepository.getBudgetById(budgetId).orElseThrow(()-> new EntityNotFoundException("Budget by id: " + budgetId + " not found"));
    }

    public User fetchUserOrThrow(Long userId) {
        return userRepository.getUserById(userId).orElseThrow(()-> new EntityNotFoundException("User by id: " + userId + " not found"));
    }
}
