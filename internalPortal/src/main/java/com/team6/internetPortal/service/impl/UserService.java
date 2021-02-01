package com.team6.internetPortal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team6.internetPortal.entity.User;
import com.team6.internetPortal.repository.IUserRepository;
import com.team6.internetPortal.service.IUserService;



@Service
public class UserService implements IUserService{
	
	@Autowired
    private IUserRepository userRepository;

	public User saveUser(User user){
	        return userRepository.save(user);
	    }

	    public User fetchUserByEmailId(String email){
	        return userRepository.findByEmail(email);
	    }
}
