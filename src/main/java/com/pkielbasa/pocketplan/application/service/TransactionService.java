package com.pkielbasa.pocketplan.application.service;

import com.pkielbasa.pocketplan.api.mapper.TransactionMapper;
import com.pkielbasa.pocketplan.application.dto.CreateTransactionRequest;
import com.pkielbasa.pocketplan.domain.model.Budget;
import com.pkielbasa.pocketplan.domain.model.Transaction;
import com.pkielbasa.pocketplan.domain.repository.BudgetRepository;
import com.pkielbasa.pocketplan.domain.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final BudgetRepository budgetRepository;

    public Long createTransaction(CreateTransactionRequest request) {
        Budget budget = budgetRepository.findBudgetById(request.budgetId())
                .orElseThrow(() -> new IllegalArgumentException("Budget by id: "+ request.budgetId() +" not found"));

        Transaction savedTransaction = transactionRepository.createTransaction(TransactionMapper.mapToEntity(request, budget));
        return savedTransaction.getId();
    }
}
