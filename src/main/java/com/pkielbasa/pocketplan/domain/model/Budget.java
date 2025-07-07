package com.pkielbasa.pocketplan.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.*;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "budget")
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "initial_budget", nullable = false)
    private BigDecimal initialBudget;

    @NotNull
    @Column(name = "current_budget", nullable = false)
    private BigDecimal currentBudget;

    @NotNull
    @Column(name = "budget_day", nullable = false)
    private String budgetDay ;

    @NotBlank
    @Column(name = "budget_type", nullable = false)
    private String budgetType;

    @ElementCollection
    @CollectionTable(name = "user_budget", joinColumns = @JoinColumn(name = "budget_id"))
    @Column(name = "user_id")
    private List<Long> userIds = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Budget)) return false;
        Budget other = (Budget) o;
        return id != null && id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
