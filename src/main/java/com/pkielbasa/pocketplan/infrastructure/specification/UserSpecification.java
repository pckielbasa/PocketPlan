package com.pkielbasa.pocketplan.infrastructure.specification;

import com.pkielbasa.pocketplan.api.dto.criteria.UserSearchCriteria;
import com.pkielbasa.pocketplan.domain.model.User;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {
    public static Specification<User> byCriteria(UserSearchCriteria criteria) {
        return (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();

            if (criteria.username() != null) {
                predicate = criteriaBuilder.and(predicate,
                        criteriaBuilder.equal(
                                criteriaBuilder.lower(root.get("username")),
                                criteria.username().toLowerCase()
                        )
                );
            }

            if (criteria.email() != null) {
                predicate = criteriaBuilder.and(predicate,
                        criteriaBuilder.equal(
                                criteriaBuilder.lower(root.get("email")),
                                criteria.email().toLowerCase()
                        )
                );
            }

            if (criteria.firstName() != null) {
                predicate = criteriaBuilder.and(predicate,
                        criteriaBuilder.equal(
                                criteriaBuilder.lower(root.get("firstName")),
                                criteria.firstName().toLowerCase()
                        )
                );
            }

            if (criteria.surname() != null) {
                predicate = criteriaBuilder.and(predicate,
                        criteriaBuilder.equal(
                                criteriaBuilder.lower(root.get("surname")),
                                criteria.surname().toLowerCase()
                        )
                );
            }

        return predicate;
        };
    }
}
