package com.pkielbasa.pocketplan.application.service;

import com.pkielbasa.pocketplan.api.mapper.UserMapper;
import com.pkielbasa.pocketplan.application.dto.user.CreateUserRequest;
import com.pkielbasa.pocketplan.domain.model.User;
import com.pkielbasa.pocketplan.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Long createUser(CreateUserRequest request) {
        User savedUser = userRepository.save(UserMapper.toEntity(request));
        return savedUser.getId();
    }
}
