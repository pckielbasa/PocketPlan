package com.pkielbasa.pocketplan.infrastructure.repository.impl;

import com.pkielbasa.pocketplan.domain.model.Transaction;
import com.pkielbasa.pocketplan.domain.repository.TransactionRepository;
import com.pkielbasa.pocketplan.infrastructure.repository.jpa.JpaTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TransactionRepositoryImpl implements TransactionRepository {

    private final JpaTransactionRepository jpaTransactionRepository;

    @Override
    public Transaction createTransaction(Transaction transaction) {
        return jpaTransactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> getTransactionByName(String transactionName) {
        return jpaTransactionRepository.getTransactionsByName(transactionName);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return jpaTransactionRepository.findAll();
    }

    @Override
    public List<Transaction> getSortedTransactionByDate(Sort sort) {
        return jpaTransactionRepository.findAll(sort);
    }

}
