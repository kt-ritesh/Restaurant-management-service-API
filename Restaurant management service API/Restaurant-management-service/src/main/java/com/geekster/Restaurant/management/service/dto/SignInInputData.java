package com.geekster.Restaurant.management.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SignInInputData {
    private String userEmailId;
    private String password;

}
