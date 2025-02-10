package com.deliciousfood.infrastructure.persistence.impl;

import com.deliciousfood.application.port.out.UserRepository;
import com.deliciousfood.domain.exception.exception.ResourceNotFoundException;
import com.deliciousfood.domain.model.User;
import com.deliciousfood.infrastructure.persistence.JpaUserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JpaUserRepository jpaUserRepository;

    public UserRepositoryImpl(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public List<User> findAll() {
        return jpaUserRepository.findAll();
    }

    @Override
    public User save(User user) {
        return jpaUserRepository.save(user);
    }

    @Override
    public User findById(Long userId) {
        Optional<User> user = jpaUserRepository.findById(userId);
        return user.orElseThrow(() -> new ResourceNotFoundException("User not found not found with id:" + userId));
    }

    @Override
    public void deleteById(Long userId) {
        jpaUserRepository.deleteById(userId);
    }
}
