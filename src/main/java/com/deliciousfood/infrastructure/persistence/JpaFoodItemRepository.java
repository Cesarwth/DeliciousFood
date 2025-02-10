package com.deliciousfood.infrastructure.persistence;

import com.deliciousfood.domain.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaFoodItemRepository extends JpaRepository<FoodItem, Long> {
}
