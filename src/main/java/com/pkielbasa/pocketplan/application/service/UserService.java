package com.pkielbasa.pocketplan.application.service;

import com.pkielbasa.pocketplan.api.dto.criteria.UserSearchCriteria;
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

    public User getUserById(long userId) {
        return entityFetcherService.fetchUserOrThrow(userId);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getUsers(UserSearchCriteria criteria) {
        Specification<User> spec = UserSpecification.byCriteria(criteria);
        Sort sort = SortUtils.buildSort(criteria.sort(), criteria.destination());
        return userRepository.findAllUsers(spec, sort);
    }

    public User updateUser(User user) {
        return userRepository.updateUser(user);
    }

    public void deleteUser(long userId) {
        entityFetcherService.fetchUserOrThrow(userId);
        userRepository.deleteUserById(userId);
    }
}
