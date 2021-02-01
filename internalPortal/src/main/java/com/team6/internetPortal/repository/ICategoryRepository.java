package com.team6.internetPortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team6.internetPortal.entity.Category;
import com.team6.internetPortal.entity.Video;


public interface ICategoryRepository extends JpaRepository<Category, Integer>{



	
}
