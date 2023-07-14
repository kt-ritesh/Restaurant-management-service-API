package com.geekster.Restaurant.management.service.controller;

import com.geekster.Restaurant.management.service.model.OrderFood;
import com.geekster.Restaurant.management.service.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/getAllOrder")
    public Iterable<OrderFood> getAllOrder(){
        return orderService.getAllOrderdFood();
    }

}
