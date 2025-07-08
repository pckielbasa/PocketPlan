package com.pkielbasa.pocketplan.application.service;

import com.pkielbasa.pocketplan.api.dto.criteria.TransactionSearchCriteria;
import com.pkielbasa.pocketplan.api.dto.transaction.TransactionResponse;
import com.pkielbasa.pocketplan.api.dto.transaction.UpdateTransactionRequest;
import com.pkielbasa.pocketplan.api.mapper.TransactionMapper;
import com.pkielbasa.pocketplan.api.dto.transaction.CreateTransactionRequest;
import com.pkielbasa.pocketplan.application.util.EntityFetcherService;
import com.pkielbasa.pocketplan.application.util.SortUtils;
import com.pkielbasa.pocketplan.domain.model.Budget;
import com.pkielbasa.pocketplan.domain.model.Transaction;
import com.pkielbasa.pocketplan.domain.repository.TransactionRepository;
import com.pkielbasa.pocketplan.infrastructure.specification.TransactionSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final EntityFetcherService entityFetcherService;

    public TransactionResponse getTransaction(Long transactionId) {
        return TransactionMapper.mapToResponse(entityFetcherService.fetchTransactionOrThrow(transactionId));
    }

    public TransactionResponse createTransaction(CreateTransactionRequest request) {
        Budget budget = entityFetcherService.fetchBudgetOrThrow(request.budgetId());
        Transaction transaction = transactionRepository.createTransaction(TransactionMapper.mapToEntity(request, budget));
        return TransactionMapper.mapToResponse(transaction);
    }

    public List<Transaction> getTransactions(TransactionSearchCriteria criteria) {
        Specification<Transaction> spec = TransactionSpecification.byCriteria(criteria);
        Sort sort = SortUtils.buildSort(criteria.sort(), criteria.direction());
        return transactionRepository.getTransactions(spec, sort);
    }

    public Transaction updateTransaction(UpdateTransactionRequest request, long id) {
        Transaction oldTransaction = entityFetcherService.fetchTransactionOrThrow(id);
        TransactionMapper.updateEntity(oldTransaction, request);
        return transactionRepository.updateTransaction(oldTransaction);
    }

    public void deleteTransactionById(long id) {
        entityFetcherService.fetchTransactionOrThrow(id);
        transactionRepository.deleteTransactionById(id);
    }

}
