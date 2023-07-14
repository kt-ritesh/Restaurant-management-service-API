package com.geekster.Restaurant.management.service.controller;

import com.geekster.Restaurant.management.service.model.Foods;
import com.geekster.Restaurant.management.service.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FoodController {
    @Autowired
    private FoodService foodService;

    @PostMapping("/addFood")
    public String addFood(@RequestBody Foods food){
        return foodService.addFood(food);
    }

    @DeleteMapping("/deleteFood/{id}")
    public String deleteFood(@PathVariable Long id){
        return foodService.deleteFood(id);
    }

    @PutMapping("updateFood/{id}/{price}")
    public String updateFood(@PathVariable Long id , @PathVariable Double price){
        return foodService.updateFoodById(id , price);
    }

}
