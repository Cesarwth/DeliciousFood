package com.deliciousfood.application.port.out;

import com.deliciousfood.domain.model.FoodItem;

import java.util.List;

public interface FoodItemRepository {
    List<FoodItem> findAll();

    FoodItem save(FoodItem foodItem);

    FoodItem findById(Long foodItemId);

    void deleteById(Long foodItemId);
}
