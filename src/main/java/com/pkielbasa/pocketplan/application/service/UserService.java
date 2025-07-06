package com.pkielbasa.pocketplan.application.service;

import com.pkielbasa.pocketplan.api.dto.user.*;
import com.pkielbasa.pocketplan.api.mapper.UserMapper;
import com.pkielbasa.pocketplan.application.util.EntityFetcherService;
import com.pkielbasa.pocketplan.application.util.SortUtils;
import com.pkielbasa.pocketplan.domain.model.User;
import com.pkielbasa.pocketplan.domain.repository.UserRepository;
import com.pkielbasa.pocketplan.infrastructure.specification.UserSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final EntityFetcherService entityFetcherService;

    public UserResponse getUserById(long userId) {
        return UserMapper.mapToResponse(entityFetcherService.fetchUserOrThrow(userId));
    }

    public UserResponse createUser(CreateUserRequest request) {
        User user = userRepository.save(UserMapper.toEntity(request));
        return UserMapper.mapToResponse(user);
    }

    public List<UserResponse> getUsers(UserSearchCriteria criteria) {
        Specification<User> spec = UserSpecification.byCriteria(criteria);
        Sort sort = SortUtils.buildSort(criteria.sort(), criteria.destination());
        return userRepository.findAllUsers(spec, sort).stream()
                .map(projection -> new UserResponse(
                        projection.getId(),
                        projection.getUsername(),
                        projection.getEmail(),
                        projection.getFirstName(),
                        projection.getSurname()
                ))
                .toList();
    }

    public UserResponse updateUser(UpdateUserRequest request, long userId) {
        User oldUser = entityFetcherService.fetchUserOrThrow(userId);
        UserMapper.updateEntity(oldUser, request);
        return UserMapper.mapToResponse(userRepository.updateUser(oldUser));
    }

    public void deleteUser(long userId) {
        entityFetcherService.fetchUserOrThrow(userId);
        userRepository.deleteUserById(userId);
    }
}
