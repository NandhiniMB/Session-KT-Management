package com.team6.internetPortal.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.team6.internetPortal.entity.User;
import com.team6.internetPortal.repository.IUserRepository;


@Repository
@Transactional
public abstract class UserRepositoryImpl implements IUserRepository {
//	 @PersistenceContext
//	    EntityManager entityManager;
//
//	    // Create
//	    public void addUser(User user){
//	        entityManager.persist(user);
//	    }
}
