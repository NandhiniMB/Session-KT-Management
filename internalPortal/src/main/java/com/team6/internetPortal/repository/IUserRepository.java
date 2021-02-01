package com.team6.internetPortal.repository;

import com.team6.internetPortal.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;


public interface IUserRepository extends JpaRepository<User, Long> {
   
	public User findByEmail(String email);


	

   
}
