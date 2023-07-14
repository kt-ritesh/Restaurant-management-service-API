package com.geekster.Restaurant.management.service.services;

import com.geekster.Restaurant.management.service.model.Foods;
import com.geekster.Restaurant.management.service.model.Restaurant;
import com.geekster.Restaurant.management.service.repository.IFoodRepository;
import com.geekster.Restaurant.management.service.repository.IRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    private IRestaurantRepository iRestaurantRepository;

    @Autowired
    private IFoodRepository iFood;

    public String addRestaurant(Restaurant restaurant) {


        List<Foods> foodList =restaurant.getFoods();
        for(Foods foodObj : foodList){
            foodObj.setRestaurant(restaurant);
        }
        iRestaurantRepository.save(restaurant);
        return "Restuarent added Successfully!!";
    }

    public Iterable<Restaurant> getAllRestaurant() {
        return iRestaurantRepository.findAll();
    }
}
