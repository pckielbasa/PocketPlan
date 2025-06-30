package com.pkielbasa.pocketplan.infrastructure.repository.impl;

import com.pkielbasa.pocketplan.domain.model.User;
import com.pkielbasa.pocketplan.domain.repository.UserRepository;
import com.pkielbasa.pocketplan.infrastructure.repository.jpa.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final JpaUserRepository jpaUserRepository;

    @Override
    public Optional<User> getUserById(long id) {
        return jpaUserRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return jpaUserRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return jpaUserRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        return jpaUserRepository.save(user);
    }

    @Override
    public void deleteUserById(long id) {
        jpaUserRepository.deleteById(id);
    }
}
