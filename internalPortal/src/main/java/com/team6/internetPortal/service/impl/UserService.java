package com.team6.internetPortal.service.impl;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team6.internetPortal.entity.User;
import com.team6.internetPortal.repository.IUserRepository;
import com.team6.internetPortal.service.IUserService;



@Service
public class UserService implements IUserService{
	
	@Autowired
    private IUserRepository userRepository;

	@Autowired
	private SendMailService  sendmailService;

	public User saveUser(User user) throws Exception{
		String tempEmail = user.getEmail();

        // Check if null or empty
        if(tempEmail != null && !"".equals(tempEmail)){

            // Check if no user found with entered emailId
            if(fetchUserByEmailId(tempEmail) != null){
                throw new Exception("User with "+ tempEmail +" already exists!");
            }
        }
        user.setCreatedOn(new Date(System.currentTimeMillis()));
	        return userRepository.save(user);
	    }

	public User fetchUserByEmailId(String email){
	        return userRepository.findByEmail(email);
	    }

	public User forgotPassword(String email){
		User user = userRepository.findByEmail(email);
		user.setPassword("Accolite");
		System.out.println(user.getPassword());
		String content = "Your new password is: \"Accolite\"";
		String userEmails[] = new String[1];
		userEmails[0] = email;
		sendmailService.sendEmail(userEmails, content);
		return userRepository.save(user);
	}
}
