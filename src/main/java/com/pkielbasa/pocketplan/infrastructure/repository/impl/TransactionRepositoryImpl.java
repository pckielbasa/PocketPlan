package com.pkielbasa.pocketplan.infrastructure.repository.impl;

import com.pkielbasa.pocketplan.domain.model.Transaction;
import com.pkielbasa.pocketplan.domain.repository.TransactionRepository;
import com.pkielbasa.pocketplan.infrastructure.repository.jpa.JpaTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TransactionRepositoryImpl implements TransactionRepository {

    private final JpaTransactionRepository jpaTransactionRepository;

    @Override
    public Optional<Transaction> getTransactionById(long id) {
        return jpaTransactionRepository.findById(id);
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {
        return jpaTransactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> getTransactions(Specification<Transaction> specification, Sort sort) {
        return jpaTransactionRepository.findAll(specification, sort);
    }

    @Override
    public Transaction updateTransaction(Transaction transaction) {
        return jpaTransactionRepository.save(transaction);
    }

    @Override
    public void deleteTransactionById(long id) {
        jpaTransactionRepository.deleteById(id);
    }
}
