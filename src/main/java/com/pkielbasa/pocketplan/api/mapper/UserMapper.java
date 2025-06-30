package com.pkielbasa.pocketplan.api.mapper;

import com.pkielbasa.pocketplan.api.dto.user.CreateUserRequest;
import com.pkielbasa.pocketplan.api.dto.user.UserResponse;
import com.pkielbasa.pocketplan.domain.model.User;

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
}
