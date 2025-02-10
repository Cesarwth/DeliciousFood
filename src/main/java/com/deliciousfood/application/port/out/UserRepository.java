package com.deliciousfood.application.port.out;

import com.deliciousfood.domain.model.User;

import java.util.List;

public interface UserRepository {

    List<User> findAll();

    User save(User user);

    User findById(Long userId);

    void deleteById(Long userId);
}
