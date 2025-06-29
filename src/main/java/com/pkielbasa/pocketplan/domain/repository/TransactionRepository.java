package com.pkielbasa.pocketplan.domain.repository;

import com.pkielbasa.pocketplan.domain.model.Transaction;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository {
    Optional<Transaction> getTransactionById(long id);
    Transaction createTransaction(Transaction transaction);
    List<Transaction> getTransactions(Specification<Transaction> specification, Sort sort);
    Transaction updateTransaction(Transaction transaction);
    void deleteTransactionById(long id);
}
