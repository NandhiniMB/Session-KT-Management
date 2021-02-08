package com.team6.internetPortal.controller;


import com.team6.internetPortal.entity.User;
import com.team6.internetPortal.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
public class UserController {

	@Autowired
    private IUserService userService;

	    @PostMapping("/register")
	    @CrossOrigin(origins = "http://localhost:4200")
	    public User registerUser(@RequestBody User user) throws Exception{
	    	return userService.saveUser(user);
	    }

	    @PostMapping("/login")
	    @CrossOrigin(origins = "http://localhost:4200")
	    public User loginUser(@RequestBody User user) throws Exception{
	        String tempEmail = user.getEmail();
	        String tempPassword = user.getPassword();
	        User userCheck = null;

	        // Check if null or empty
	        if(tempEmail != null && !"".equals(tempEmail)){
	            userCheck = userService.fetchUserByEmailId(tempEmail);

	            // Check if no user found with entered emailId
	            if(userCheck != null){
//	                System.out.println(userCheck.getEmail()+" "+ userCheck.getPassword()+ " "+ tempPassword);

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



		@GetMapping("/restricted")
	    public String restricted() {
	        return "if you see this you are logged in";
	    }

		@PutMapping("/forgotPassword")
		@CrossOrigin(origins = "http://localhost:4200")
		public User updateForForgotPassword(@RequestBody String email){
			return userService.forgotPassword(email);
		}

}
