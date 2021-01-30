package com.team6.internalPortal;

import com.team6.internalPortal.entity.User;
import com.team6.internalPortal.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import java.util.Date;

@SpringBootApplication
public class InternalPortalApplication implements CommandLineRunner {

	@Resource
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(InternalPortalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();

		user.setUserName("VirusUndetected");
		user.setEmail("gaurangathavale@gmail.com");
		user.setName("Gaurang");
		user.setPassword("Password123");
		user.setCreatedOn(new Date(System.currentTimeMillis()));

//		userRepository.addUser(user);
	}
}
