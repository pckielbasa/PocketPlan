package com.pkielbasa.pocketplan.api.rest;

import com.pkielbasa.pocketplan.application.service.BudgetService;
import com.pkielbasa.pocketplan.domain.model.Budget;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/budget")
public class BudgetController {

    private final BudgetService budgetService;

    @PostMapping
    public ResponseEntity<Budget> createBudget(@RequestBody Budget budget,
                                               @RequestParam long userId) {
        Budget created = budgetService.createBudget(budget, userId);
        return ResponseEntity.ok(created);
    }
}
