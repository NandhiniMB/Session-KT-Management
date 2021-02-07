package com.team6.internetPortal.service;

import com.team6.internetPortal.entity.User;

public interface IUserService {

  
	public User saveUser(User user);
	public User fetchUserByEmailId(String email);


    User forgotPassword(String email);
}
