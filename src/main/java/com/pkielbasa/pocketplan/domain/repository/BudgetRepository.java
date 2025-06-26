package com.pkielbasa.pocketplan.domain.repository;

import com.pkielbasa.pocketplan.domain.model.Budget;

public interface BudgetRepository {
    Budget createBudget(Budget budget);
}
