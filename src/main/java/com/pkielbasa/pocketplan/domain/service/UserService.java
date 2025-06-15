package com.pkielbasa.pocketplan.domain.service;

import com.pkielbasa.pocketplan.domain.model.User;
import com.pkielbasa.pocketplan.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}
