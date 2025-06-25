package com.pkielbasa.pocketplan.domain.repository;

import com.pkielbasa.pocketplan.domain.model.Transaction;

public interface TransactionRepository {
    Transaction createTransaction(Transaction transaction);
}
