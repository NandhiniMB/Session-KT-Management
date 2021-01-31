package com.team6.internetPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team6.internetPortal.entity.Category;


public interface ICategoryRepository extends JpaRepository<Category, Integer>{

	
}
