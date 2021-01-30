package com.team6.internalPortal.registration.service;

import com.team6.internalPortal.entity.User;
import com.team6.internalPortal.registration.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    public User saveUser(User user){
        return registrationRepository.save(user);
    }

    public User fetchUserByEmailId(String email){
        return registrationRepository.findByEmail(email);
    }

}
