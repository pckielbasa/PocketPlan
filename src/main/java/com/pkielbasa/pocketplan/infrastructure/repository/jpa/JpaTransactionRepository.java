package com.pkielbasa.pocketplan.infrastructure.repository.jpa;

import com.pkielbasa.pocketplan.domain.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaTransactionRepository extends JpaRepository<Transaction, Long> {
    }
