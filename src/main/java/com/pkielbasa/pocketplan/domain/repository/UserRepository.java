package com.pkielbasa.pocketplan.domain.repository;

import com.pkielbasa.pocketplan.domain.model.User;

import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> getUserById(long id);
}
