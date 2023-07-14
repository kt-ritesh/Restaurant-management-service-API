package com.geekster.Restaurant.management.service.services;

import com.geekster.Restaurant.management.service.dto.SignInInputData;
import com.geekster.Restaurant.management.service.dto.SignInOutputData;
import com.geekster.Restaurant.management.service.dto.SignUpInputData;
import com.geekster.Restaurant.management.service.dto.SignUpOutputData;
import com.geekster.Restaurant.management.service.model.Authentication;
import com.geekster.Restaurant.management.service.model.Costumber;
import com.geekster.Restaurant.management.service.repository.IAuthenticationRepository;
import com.geekster.Restaurant.management.service.repository.ICostumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class CostumberService {
    @Autowired
    ICostumberRepository iCostumberRepository;
    @Autowired
    IAuthenticationRepository iAuthenticationRepository;

    public SignUpOutputData signup(SignUpInputData signUpInputData) {

        Costumber costumberObj = iCostumberRepository.findFirstByCostumberEmailId(signUpInputData.getUserEmailId());

        if(costumberObj !=null){
            throw new IllegalStateException("Email allready Exist!!");
        }
        String encryptedPassword;
        try {
            encryptedPassword = encryptPassword(signUpInputData.getUserPassword());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        Costumber costumber = new Costumber(signUpInputData.getUserEmailId() , encryptedPassword , signUpInputData.getUserFirstName() , signUpInputData.getUserLastName() , signUpInputData.getUserAddress() , signUpInputData.getUserMobileNumber());
        iCostumberRepository.save(costumber);

        Authentication authentication = new Authentication(costumber);
        iAuthenticationRepository.save(authentication);
       // iCostumberRepository.save(costumber);
        return new SignUpOutputData("SignUp Successfully Created" ,"Now You can SignIn");

    }

    private String encryptPassword(String userPassword) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(userPassword.getBytes());
            byte[] password = md5.digest();
            String stPassword = new String(password);
            return stPassword;

    }

    public SignInOutputData signin(SignInInputData signInInputData) {
        Costumber costumberObj = iCostumberRepository.findFirstByCostumberEmailId(signInInputData.getUserEmailId());
        if(costumberObj ==null){
            throw new IllegalStateException("Sorry!! Email Not  Found!!");
        }
        String encryptedPassword;
        try {
            encryptedPassword = encryptPassword(signInInputData.getPassword());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        if(!encryptedPassword.equals(costumberObj.getCostumberPassword())){
            throw new IllegalStateException("Sorry!! Wrong password!!");
        }
       // Authentication authentication = new Authentication(costumberObj);
//        Authentication authentication = new Authentication(costumberObj);
//        iAuthenticationRepository.save(authentication);

        Authentication authenticationObj = iAuthenticationRepository.findByCostumber(costumberObj);

        return new SignInOutputData("Congratulation SignIn Successfull!!",authenticationObj.getAuthenticationToken());
    }
}
