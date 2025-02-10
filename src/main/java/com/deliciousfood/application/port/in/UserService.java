package com.deliciousfood.application.port.in;

import com.deliciousfood.domain.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User createUser(User user);

    User getUserById(Long userId);

    void deleteUser(Long userId);
}
