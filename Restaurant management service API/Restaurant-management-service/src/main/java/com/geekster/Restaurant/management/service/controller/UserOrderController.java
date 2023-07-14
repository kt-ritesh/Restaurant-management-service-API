package com.geekster.Restaurant.management.service.controller;

import com.geekster.Restaurant.management.service.model.OrderFood;
import com.geekster.Restaurant.management.service.model.Restaurant;
import com.geekster.Restaurant.management.service.services.OrderService;
import com.geekster.Restaurant.management.service.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserOrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    RestaurantService restaurantServiceObj;

    @PostMapping("/OrderFood/{emailId}/{token}")
    public ResponseEntity<String> OrderFood(@RequestBody OrderFood orderFood, @PathVariable String emailId , @PathVariable String token){
      //return  orderService.addOrder(orderFood);
        HttpStatus status;
        String message = "";


        if(orderService.check(emailId , token)){
           message = orderService.addOrder(orderFood);
            status = HttpStatus.OK;
        }else {
            status = HttpStatus.NO_CONTENT;
            message = "Worng Id And Password";
        }
        return new ResponseEntity<String>(message , status);
    }
    @GetMapping("getAllRestaurant/{emailId}/{token}")
    public ResponseEntity<Iterable<Restaurant>> getAllRestaurant(@PathVariable String emailId , @PathVariable String token){
        //return restaurantServiceObj.getAllRestaurant();
        Iterable<Restaurant> iterableObj = null;

        HttpStatus status;
        try {

            if (orderService.check(emailId , token)) {
                iterableObj = restaurantServiceObj.getAllRestaurant();
                status = HttpStatus.OK;
            } else {
                status = HttpStatus.NO_CONTENT;
            }
        }catch (Exception e){
            System.out.println(e);
            status = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<Iterable<Restaurant>>(iterableObj , status);
    }
}
