package com.deliciousfood.infrastructure.persistence.impl;

import com.deliciousfood.application.port.out.FoodItemRepository;
import com.deliciousfood.domain.exception.exception.ResourceNotFoundException;
import com.deliciousfood.domain.model.FoodItem;
import com.deliciousfood.infrastructure.persistence.JpaFoodItemRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FoodItemRepositoryImpl implements FoodItemRepository {
    private final JpaFoodItemRepository jpaFoodItemRepository;

    public FoodItemRepositoryImpl(JpaFoodItemRepository jpaFoodItemRepository) {
        this.jpaFoodItemRepository = jpaFoodItemRepository;
    }

    @Override
    public List<FoodItem> findAll() {
        return jpaFoodItemRepository.findAll();
    }

    @Override
    public FoodItem save(FoodItem foodItem) {
        return jpaFoodItemRepository.save(foodItem);
    }

    @Override
    public FoodItem findById(Long foodItemId) {
        Optional<FoodItem> foodItem = jpaFoodItemRepository.findById(foodItemId);
        return foodItem.orElseThrow(() -> new ResourceNotFoundException("Food Item not found"));
    }

    @Override
    public void deleteById(Long foodItemId) {
        jpaFoodItemRepository.deleteById(foodItemId);
    }
}
