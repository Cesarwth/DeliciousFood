package com.deliciousfood.application.port.in;

import com.deliciousfood.domain.model.FoodItem;

import java.util.List;

public interface FoodItemService {

    List<FoodItem> getAllFoodItems();

    FoodItem createFoodItem(FoodItem foodItem);

    FoodItem getFoodItemById(Long foodItemId);

    void deleteFoodItem(Long foodItemId);
}
