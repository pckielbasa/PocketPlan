package com.pkielbasa.pocketplan.infrastructure.specification;

import com.pkielbasa.pocketplan.api.dto.criteria.TransactionSearchCriteria;
import com.pkielbasa.pocketplan.domain.model.Transaction;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

public class TransactionSpecification {

    public static Specification<Transaction> byCriteria(TransactionSearchCriteria criteria) {
        return (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();

            if (criteria.name() != null) {
                predicate = criteriaBuilder.and(predicate,
                        criteriaBuilder.equal(
                                criteriaBuilder.lower(root.get("name")),
                                criteria.name().toLowerCase()
                        )
                );
            }

            if (criteria.type() != null) {
                predicate = criteriaBuilder.and(predicate,
                        criteriaBuilder.equal(
                                criteriaBuilder.lower(root.get("type")),
                                criteria.type().toLowerCase()
                        )
                );
            }

            if (criteria.budgetId() != null) {
                predicate = criteriaBuilder.and(predicate,
                        criteriaBuilder.equal(
                                root.get("budget").get("id"),
                                criteria.budgetId()
                        ));
            }

            return predicate;
        };
    }
}
