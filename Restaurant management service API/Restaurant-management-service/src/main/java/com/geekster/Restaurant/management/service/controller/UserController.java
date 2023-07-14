package com.geekster.Restaurant.management.service.controller;

import com.geekster.Restaurant.management.service.dto.SignInInputData;
import com.geekster.Restaurant.management.service.dto.SignInOutputData;
import com.geekster.Restaurant.management.service.dto.SignUpInputData;
import com.geekster.Restaurant.management.service.dto.SignUpOutputData;
import com.geekster.Restaurant.management.service.services.CostumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    CostumberService costumberService;
    //SignUp user:
    @PostMapping("/signup")
    public SignUpOutputData signup(@RequestBody SignUpInputData signUpInputData){
        return costumberService.signup(signUpInputData);
    }
    //SignIn user:
    @PostMapping("/signin")
    public SignInOutputData signin(@RequestBody SignInInputData signInInputData){
        return costumberService.signin(signInInputData);
    }

}
