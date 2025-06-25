package com.pkielbasa.pocketplan.domain.repository;

import com.pkielbasa.pocketplan.domain.model.User;

public interface UserRepository {
    User save(User user);
}
