package com.pkielbasa.pocketplan.infrastructure.repository.impl;

import com.pkielbasa.pocketplan.domain.model.Budget;
import com.pkielbasa.pocketplan.domain.repository.BudgetRepository;
import com.pkielbasa.pocketplan.infrastructure.repository.jpa.JpaBudgetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BudgetRepositoryImpl implements BudgetRepository {

    private final JpaBudgetRepository jpaBudgetRepository;

    @Override
    public Budget createBudget(Budget budget) {
        return jpaBudgetRepository.save(budget);
    }

    @Override
    public Optional<Budget> getBudgetById(long id) {
        return jpaBudgetRepository.findById(id);
    }
}
