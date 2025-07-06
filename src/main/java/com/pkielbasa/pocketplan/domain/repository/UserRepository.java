package com.pkielbasa.pocketplan.domain.repository;

import com.pkielbasa.pocketplan.domain.model.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User> getUserById(long id);
    User save(User user);
    List<User> findAllUsers(Specification<User> spec, Sort sort);
    User updateUser(User user);
    void deleteUserById(long id);
}
