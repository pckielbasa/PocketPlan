package com.pkielbasa.pocketplan.infrastructure.repository.impl;

import com.pkielbasa.pocketplan.domain.model.User;
import com.pkielbasa.pocketplan.domain.repository.UserRepository;
import com.pkielbasa.pocketplan.infrastructure.repository.jpa.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final JpaUserRepository jpaUserRepository;

    @Override
    public User save(User user) {
        return jpaUserRepository.save(user);
    }
}
