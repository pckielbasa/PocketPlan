package com.pkielbasa.pocketplan.application.service;

import com.pkielbasa.pocketplan.api.dto.transaction.TransactionSearchCriteria;
import com.pkielbasa.pocketplan.api.mapper.TransactionMapper;
import com.pkielbasa.pocketplan.api.dto.transaction.CreateTransactionRequest;
import com.pkielbasa.pocketplan.application.exception.ResourceNotFoundException;
import com.pkielbasa.pocketplan.application.util.EntityFetcherService;
import com.pkielbasa.pocketplan.application.util.SortUtils;
import com.pkielbasa.pocketplan.domain.model.Budget;
import com.pkielbasa.pocketplan.domain.model.Transaction;
import com.pkielbasa.pocketplan.domain.repository.BudgetRepository;
import com.pkielbasa.pocketplan.domain.repository.TransactionRepository;
import com.pkielbasa.pocketplan.infrastructure.repository.specification.TransactionSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final BudgetRepository budgetRepository;
    private final EntityFetcherService entityFetcherService;


    public Optional<Transaction> getTransactions(long id) {
        return transactionRepository.getTransactionById(id);
    }

    public Transaction createTransaction(CreateTransactionRequest request) {
        Budget budget = budgetRepository.getBudgetById(request.budgetId())
                .orElseThrow(() -> new ResourceNotFoundException("Budget by id: "+ request.budgetId() +" not found"));
        return transactionRepository.createTransaction(TransactionMapper.mapToEntity(request, budget));
    }

    public List<Transaction> getTransactions(TransactionSearchCriteria criteria) {
        Specification<Transaction> spec = TransactionSpecification.byCriteria(criteria);
        Sort sort = SortUtils.buildSort(criteria.sort(), criteria.direction());
        return transactionRepository.getTransactions(spec, sort);
    }

    public Transaction updateTransaction(CreateTransactionRequest request, long id) {
        Transaction oldTransaction = entityFetcherService.fetchTransactionOrThrow(id);
        Budget budget = entityFetcherService.fetchBudgetOrThrow(request.budgetId());
        TransactionMapper.updateEntity(oldTransaction, request, budget);
        return transactionRepository.updateTransaction(oldTransaction);
    }

    public void deleteTransactionById(long id) {
        transactionRepository.deleteTransactionById(id);
    }

}
