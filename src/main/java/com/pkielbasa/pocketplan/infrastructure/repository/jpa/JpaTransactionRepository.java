package com.pkielbasa.pocketplan.infrastructure.repository.jpa;

import com.pkielbasa.pocketplan.domain.model.Transaction;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface JpaTransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> getTransactionsByName(String name);
}
