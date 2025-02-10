package com.deliciousfood.application.port.in;

import com.deliciousfood.domain.model.Restaurant;

import java.util.List;

public interface RestaurantService {

    List<Restaurant> getAllRestaurants();

    Restaurant createRestaurant(Restaurant restaurant);

    Restaurant getRestaurantById(Long restaurantId);

    void deleteRestaurant(Long restaurantId);
}
