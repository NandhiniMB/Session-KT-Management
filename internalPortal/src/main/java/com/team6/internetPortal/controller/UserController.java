package com.team6.internalPortal.registration.controller;

import com.sun.xml.bind.v2.runtime.output.SAXOutput;
import com.team6.internalPortal.entity.User;
import com.team6.internalPortal.registration.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

//    "/video"

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) throws Exception{
        String tempEmail = user.getEmail();

        // Check if null or empty
        if(tempEmail != null && !"".equals(tempEmail)){

            // Check if no user found with entered emailId
            if(registrationService.fetchUserByEmailId(tempEmail) != null){
                throw new Exception("User with "+ tempEmail +" already exists!");
            }
        }
        user.setCreatedOn(new Date(System.currentTimeMillis()));

        User userObj;
        userObj = registrationService.saveUser(user);
        return userObj;
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody User user) throws Exception{
        String tempEmail = user.getEmail();
        String tempPassword = user.getPassword();
        User userCheck = null;

        // Check if null or empty
        if(tempEmail != null && !"".equals(tempEmail)){
            userCheck = registrationService.fetchUserByEmailId(tempEmail);

            // Check if no user found with entered emailId
            if(userCheck != null){
                System.out.println(userCheck.getEmail()+" "+ userCheck.getPassword()+ " "+ tempPassword);

                // Check Email-Password Match
                if(!(userCheck.getPassword()).equals(tempPassword)){
                    throw new Exception("Username and Passwords do not match");
                }
            }
            else{
                throw new Exception("Your Email Id is not registered :(");
            }
        }
        return userCheck;
    }

}
