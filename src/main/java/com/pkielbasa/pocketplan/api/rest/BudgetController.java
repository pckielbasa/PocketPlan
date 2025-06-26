package com.pkielbasa.pocketplan.api.rest;

import com.pkielbasa.pocketplan.application.service.BudgetService;
import com.pkielbasa.pocketplan.domain.model.Budget;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/budget")
public class BudgetController {

    private final BudgetService budgetService;

    @PostMapping
    public ResponseEntity<String> createBudget(@RequestBody Budget budget) {
        try {
            budgetService.createBudget(budget);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
