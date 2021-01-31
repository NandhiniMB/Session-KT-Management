package com.team6.internalPortal.registration.repository;

import com.team6.internalPortal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<User, Long> {
    public User findByEmail(String email);
}
