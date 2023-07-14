package com.geekster.Restaurant.management.service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Costumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long costumberId;
    private String costumberEmailId;
    private String costumberPassword;
    private  String costumberFirstName;
    private String costumberLastName;
    private String costumberAddress;
    private  String costumberMobileNumber;

    public Costumber(String costumberEmailId, String costumberPassword, String costumberFirstName, String costumberLastName, String costumberAddress, String costumberMobileNumber) {
        this.costumberEmailId = costumberEmailId;
        this.costumberPassword = costumberPassword;
        this.costumberFirstName = costumberFirstName;
        this.costumberLastName = costumberLastName;
        this.costumberAddress = costumberAddress;
        this.costumberMobileNumber = costumberMobileNumber;
    }
}
