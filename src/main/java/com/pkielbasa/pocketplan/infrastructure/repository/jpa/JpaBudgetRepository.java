package com.pkielbasa.pocketplan.infrastructure.repository.jpa;

import com.pkielbasa.pocketplan.domain.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaBudgetRepository extends JpaRepository<Budget, Long> {
}
