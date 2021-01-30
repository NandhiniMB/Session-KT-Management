package com.team6.internalPortal.repository;

import com.team6.internalPortal.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserRepository {

    @PersistenceContext
    EntityManager entityManager;

    // Create
    public void addUser(User user){
        entityManager.persist(user);
    }
}
