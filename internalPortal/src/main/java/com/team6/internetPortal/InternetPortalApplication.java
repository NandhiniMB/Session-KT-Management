package com.team6.internetPortal;

import com.team6.internetPortal.entity.Category;
import com.team6.internetPortal.entity.User;
import com.team6.internetPortal.entity.Video;
import com.team6.internetPortal.repository.ICategoryRepository;
import com.team6.internetPortal.repository.IUserRepository;
import com.team6.internetPortal.repository.IVideoRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import javax.annotation.Resource;
import javax.persistence.EntityManager;

import java.util.Date;

@SpringBootApplication
public class InternetPortalApplication implements CommandLineRunner {

	@Resource
	IUserRepository userRepository;
	@Resource
	IVideoRepository videoRepository;
    @Resource
    ICategoryRepository categoryRepository;
	public static void main(String[] args) {
		SpringApplication.run(InternetPortalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();

		user.setUserName("VirusUndetected");
		user.setEmail("gaurangathavale@gmail.com");
		user.setName("Gaurang");
		user.setPassword("Password123");
		user.setCreatedOn(new Date(System.currentTimeMillis()));
	}
}
