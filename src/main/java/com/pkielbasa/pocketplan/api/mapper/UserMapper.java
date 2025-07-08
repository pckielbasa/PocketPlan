package com.pkielbasa.pocketplan.api.mapper;

import com.pkielbasa.pocketplan.api.dto.user.CreateUserRequest;
import com.pkielbasa.pocketplan.api.dto.user.UpdateUserRequest;
import com.pkielbasa.pocketplan.api.dto.user.UserResponse;
import com.pkielbasa.pocketplan.domain.model.User;

import java.util.Optional;

public class UserMapper {

    public static User toEntity(CreateUserRequest createUserRequest) {
            return User.builder()
                    .username(createUserRequest.username())
                    .password(createUserRequest.password())
                    .email(createUserRequest.email())
                    .firstName(createUserRequest.firstName())
                    .surname(createUserRequest.surname())
                    .build();
    }

    public static UserResponse mapToResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getFirstName(),
                user.getSurname()
        );
    }

    public static void updateEntity(User existingUser, UpdateUserRequest request) {
        Optional.ofNullable(request.username()).ifPresent(existingUser::setUsername);
        Optional.ofNullable(request.email()).ifPresent(existingUser::setEmail);
        Optional.ofNullable(request.firstName()).ifPresent(existingUser::setFirstName);
        Optional.ofNullable(request.surname()).ifPresent(existingUser::setSurname);
    }
}
