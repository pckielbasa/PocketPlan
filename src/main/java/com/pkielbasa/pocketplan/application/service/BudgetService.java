package com.pkielbasa.pocketplan.application.service;

import com.pkielbasa.pocketplan.domain.model.Budget;
import com.pkielbasa.pocketplan.domain.repository.BudgetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BudgetService {

    private final BudgetRepository budgetRepository;

    public void createBudget(Budget budget) {
        budgetRepository.createBudget(budget);
    }
}
