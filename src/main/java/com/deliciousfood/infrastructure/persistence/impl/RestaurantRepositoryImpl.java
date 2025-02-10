package com.deliciousfood.infrastructure.persistence.impl;

import com.deliciousfood.application.port.out.RestaurantRepository;
import com.deliciousfood.domain.exception.exception.ResourceNotFoundException;
import com.deliciousfood.domain.model.Restaurant;
import com.deliciousfood.infrastructure.persistence.JpaRestaurantRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RestaurantRepositoryImpl implements RestaurantRepository {

    private final JpaRestaurantRepository jpaRestaurantRepository;

    public RestaurantRepositoryImpl(JpaRestaurantRepository jpaRestaurantRepository) {
        this.jpaRestaurantRepository = jpaRestaurantRepository;
    }

    @Override
    public List<Restaurant> findAll() {
        return jpaRestaurantRepository.findAll();
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        return jpaRestaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant findById(Long restaurantId) {
        Optional<Restaurant> restaurant = jpaRestaurantRepository.findById(restaurantId);
        return restaurant.orElseThrow(() -> new ResourceNotFoundException("Restaurant not found"));
    }

    @Override
    public void deleteById(Long restaurantId) {
        jpaRestaurantRepository.deleteById(restaurantId);
    }
}
