package com.pkielbasa.pocketplan.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user_budget")
public class UserBudget {

    @EmbeddedId
    private UserBudgetId id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("budgetId")
    @JoinColumn(name = "budget_id")
    private Budget budget;

    @Embeddable
    @EqualsAndHashCode(onlyExplicitlyIncluded = true)
    public static class UserBudgetId implements Serializable {
        private Long userId;
        private Long budgetId;
    }
}
