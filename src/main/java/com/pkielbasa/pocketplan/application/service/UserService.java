package com.pkielbasa.pocketplan.application.service;

import com.pkielbasa.pocketplan.api.dto.user.UserResponse;
import com.pkielbasa.pocketplan.api.mapper.UserMapper;
import com.pkielbasa.pocketplan.api.dto.user.CreateUserRequest;
import com.pkielbasa.pocketplan.application.util.EntityFetcherService;
import com.pkielbasa.pocketplan.domain.model.User;
import com.pkielbasa.pocketplan.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final EntityFetcherService entityFetcherService;

    public UserResponse getUserById(long userId) {
        return UserMapper.mapToResponse(entityFetcherService.fetchUserOrThrow(userId));
    }

    public User createUser(CreateUserRequest request) {
        return userRepository.save(UserMapper.toEntity(request));
    }
}
