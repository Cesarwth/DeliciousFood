package com.deliciousfood.infrastructure.persistence;

import com.deliciousfood.domain.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaRestaurantRepository extends JpaRepository<Restaurant, Long> {
}
