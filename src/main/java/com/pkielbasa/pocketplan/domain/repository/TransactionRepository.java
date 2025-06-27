package com.pkielbasa.pocketplan.domain.repository;

import com.pkielbasa.pocketplan.domain.model.Transaction;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepository {
    Transaction createTransaction(Transaction transaction);
    List<Transaction> getTransactionByName(String transactionName);
    List<Transaction> getAllTransactions();
    List<Transaction> getSortedTransactionByDate(Sort sort);
}
