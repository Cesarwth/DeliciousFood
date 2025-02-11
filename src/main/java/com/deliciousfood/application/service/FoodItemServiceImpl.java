package com.deliciousfood.application.service;

import com.deliciousfood.application.port.in.FoodItemService;
import com.deliciousfood.application.port.out.FoodItemRepository;
import com.deliciousfood.domain.model.FoodItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodItemServiceImpl implements FoodItemService {

    private final FoodItemRepository foodItemRepository;

    public List<FoodItem> getAllFoodItems() {
        return foodItemRepository.findAll();
    }

    public FoodItem createFoodItem(FoodItem foodItem) {
        return foodItemRepository.save(foodItem);
    }

    public FoodItem getFoodItemById(Long foodItemId) {
        return foodItemRepository.findById(foodItemId);
    }

    public void deleteFoodItem(Long foodItemId) {
        foodItemRepository.deleteById(foodItemId);
    }
}
