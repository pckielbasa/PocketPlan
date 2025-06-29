package com.pkielbasa.pocketplan.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString(exclude = {"users"})
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "budget")
public class Budget {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "initial_budget", nullable = false)
    @NotNull
    private BigDecimal initialBudget;

    @Column(name = "current_budget", nullable = false)
    @NotNull
    private BigDecimal currentBudget;

    @Column(name = "budget_day", nullable = false)
    @NotNull
    private String budgetDay ;

    @Column(name = "budget_type", nullable = false)
    @NotBlank
    private String budgetType;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "budgets")
    private Set<User> users = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Budget budget = (Budget) o;
        if (id == null || budget.id == null) {
            return false;
        }
        return id.equals(budget.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
