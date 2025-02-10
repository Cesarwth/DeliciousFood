package com.deliciousfood.infrastructure.persistence;

import com.deliciousfood.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<User, Long> {
}
