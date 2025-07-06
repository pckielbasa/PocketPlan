package com.pkielbasa.pocketplan.api.rest;

import com.pkielbasa.pocketplan.api.dto.user.*;
import com.pkielbasa.pocketplan.application.service.UserService;
import com.pkielbasa.pocketplan.application.util.UriBuilder;
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
        UserResponse userResponse = userService.getUserById(id);
        return ResponseEntity.ok(userResponse);
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody CreateUserRequest request) {
        UserResponse user = userService.createUser(request);
        URI location = uriBuilder.buildUri(user.id());
        return ResponseEntity.created(location).body(user);
    }

    @GetMapping()
    public ResponseEntity<List<UserResponse>> getUsers(@ModelAttribute UserSearchCriteria criteria) {
        return ResponseEntity.ok(userService.getUsers(criteria));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable long id,
                                                   @RequestBody UpdateUserRequest request) {
        return ResponseEntity.ok(userService.updateUser(request, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
