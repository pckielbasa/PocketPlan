package com.pkielbasa.pocketplan.domain.repository;

import com.pkielbasa.pocketplan.domain.model.Budget;

import java.util.Optional;

public interface BudgetRepository {
    Budget createBudget(Budget budget);
    Optional<Budget> getBudgetById(long id);
}
