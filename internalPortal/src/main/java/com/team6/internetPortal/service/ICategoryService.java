package com.team6.internetPortal.service;

import java.util.List;
import java.util.Optional;

import com.team6.internetPortal.entity.Category;
import com.team6.internetPortal.entity.Video;

public interface ICategoryService {

	public List<Category> getAllCategories();

	public Optional<Category> getCategory(int category_id);

	public Category addCategory(Category category);

	public Category updateCategory(Category category);

	public void deleteCategory(int id);

	

}
