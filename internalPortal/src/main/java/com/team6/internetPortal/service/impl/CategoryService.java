package com.team6.internetPortal.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team6.internetPortal.entity.Category;
import com.team6.internetPortal.repository.ICategoryRepository;
import com.team6.internetPortal.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	ICategoryRepository categoryRepository;

	@Override
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public Optional<Category> getCategory(int category_id) {
		return categoryRepository.findById(category_id);
	}

	@Override
	public Category addCategory(Category category) {
		category.setCreatedOn( new Date(System.currentTimeMillis()));
		return categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryRepository.save(category);
	}

	@Override
	public void deleteCategory(int id) {
		// TODO Auto-generated method stub
		categoryRepository.deleteById(id);		
	}
	
}
