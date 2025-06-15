package com.pkielbasa.pocketplan.domain.repository;

import com.pkielbasa.pocketplan.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
