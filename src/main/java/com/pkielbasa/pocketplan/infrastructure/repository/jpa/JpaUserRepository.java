package com.pkielbasa.pocketplan.infrastructure.repository.jpa;

import com.pkielbasa.pocketplan.domain.model.User;
import com.pkielbasa.pocketplan.infrastructure.projection.UserSummaryProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaUserRepository extends JpaRepository<User, Long> {
    @Query("""
    SELECT new com.pkielbasa.pocketplan.infrastructure.projection.UserSummaryProjection(
        u.id,
        u.username,
        u.email,
        u.firstName,
        u.surname
    )
    FROM User u
""")
    List<UserSummaryProjection> findAllUserSummaries();
}