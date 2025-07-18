package com.pkielbasa.pocketplan.api.rest;

import com.pkielbasa.pocketplan.api.dto.criteria.UserSearchCriteria;
import com.pkielbasa.pocketplan.api.dto.user.*;
import com.pkielbasa.pocketplan.api.mapper.UserMapper;
import com.pkielbasa.pocketplan.application.service.UserService;
import com.pkielbasa.pocketplan.application.util.UriBuilder;
import com.pkielbasa.pocketplan.domain.model.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final UriBuilder uriBuilder;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable long id) {
        return ResponseEntity.ok(UserMapper.mapToResponse(userService.getUserById(id)));
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody CreateUserRequest request) {
        User user = userService.createUser(UserMapper.toEntity(request));
        URI location = uriBuilder.buildUri(user.getId());
        return ResponseEntity.created(location).body(UserMapper.mapToResponse(user));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getUsers(@ModelAttribute UserSearchCriteria criteria) {
        return ResponseEntity.ok(UserMapper.mapToResponseList(userService.getUsers(criteria)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable long id,
                                                   @Valid @RequestBody UpdateUserRequest request) {
        User existingUser = userService.getUserById(id);
        User updateUser = UserMapper.updateEntity(existingUser, request);
        return ResponseEntity.ok(UserMapper.mapToResponse(userService.updateUser(updateUser)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
