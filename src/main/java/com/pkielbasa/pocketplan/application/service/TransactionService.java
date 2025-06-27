package com.pkielbasa.pocketplan.application.service;

import com.pkielbasa.pocketplan.api.mapper.TransactionMapper;
import com.pkielbasa.pocketplan.application.dto.transaction.CreateTransactionRequest;
import com.pkielbasa.pocketplan.domain.model.Budget;
import com.pkielbasa.pocketplan.domain.model.Transaction;
import com.pkielbasa.pocketplan.domain.repository.BudgetRepository;
import com.pkielbasa.pocketplan.domain.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final BudgetRepository budgetRepository;

    public Transaction createTransaction(CreateTransactionRequest request) {
        Budget budget = budgetRepository.findBudgetById(request.budgetId())
                .orElseThrow(() -> new IllegalArgumentException("Budget by id: "+ request.budgetId() +" not found"));
        return transactionRepository.createTransaction(TransactionMapper.mapToEntity(request, budget));
    }

    public List<Transaction> getTransactionByName(String name) {
        return transactionRepository.getTransactionByName(name);
    }
}
