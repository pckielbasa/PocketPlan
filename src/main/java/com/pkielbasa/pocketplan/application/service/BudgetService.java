package com.pkielbasa.pocketplan.application.service;

import com.pkielbasa.pocketplan.application.util.EntityFetcherService;
import com.pkielbasa.pocketplan.domain.model.Budget;
import com.pkielbasa.pocketplan.domain.model.User;
import com.pkielbasa.pocketplan.domain.repository.BudgetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BudgetService {

    private final BudgetRepository budgetRepository;
    private final EntityFetcherService entityFetcherService;

    public Budget createBudget(Budget budget, long userId) {
        User user = entityFetcherService.fetchUserOrThrow(userId);
        user.getBudgets().add(budget);
        budget.getUsers().add(user);

       return budgetRepository.createBudget(budget);
    }
}
