package com.geekster.Restaurant.management.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInOutputData {

    private String message;
    private String tokenUuid;

}
