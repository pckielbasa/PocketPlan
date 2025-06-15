package com.pkielbasa.pocketplan.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Budget")
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "initial_budget", nullable = false)
    @NotNull
    private BigDecimal initial_budget;

    @Column(name = "current_budget", nullable = false)
    @NotNull
    private BigDecimal current_budget;

    @Column(name = "budget_day", nullable = false)
    @NotNull
    private LocalDate budgetDay ;

    @Column(name = "budget_type", nullable = false)
    @NotBlank
    private String budgetType;
}
