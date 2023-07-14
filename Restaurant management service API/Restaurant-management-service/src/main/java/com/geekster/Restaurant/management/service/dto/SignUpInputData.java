package com.geekster.Restaurant.management.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpInputData {
    private String userEmailId;
    private String userPassword;
    private  String userFirstName;
    private String userLastName;
    private String userAddress;
    private  String userMobileNumber;
}
