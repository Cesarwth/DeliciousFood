package com.deliciousfood.application.port.out;

import com.deliciousfood.domain.model.Restaurant;

import java.util.List;

public interface RestaurantRepository {
    List<Restaurant> findAll();

    Restaurant save(Restaurant restaurant);

    Restaurant findById(Long restaurantId);

    void deleteById(Long restaurantId);
}
