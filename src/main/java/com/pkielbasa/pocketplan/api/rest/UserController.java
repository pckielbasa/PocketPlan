package com.pkielbasa.pocketplan.api.rest;

import com.pkielbasa.pocketplan.application.dto.user.CreateUserRequest;
import com.pkielbasa.pocketplan.application.dto.user.UserResponse;
import com.pkielbasa.pocketplan.application.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest request) {
        try {
            Long userId = userService.createUser(request);
            URI location = URI.create("/api/users/" + userId);
            UserResponse response = new UserResponse(userId, request.username(), request.email());
            return ResponseEntity.created(location).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
