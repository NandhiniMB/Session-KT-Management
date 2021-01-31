package com.team6.internetPortal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team6.internetPortal.entity.Category;
import com.team6.internetPortal.service.ICategoryService;

@RestController
@RequestMapping("category")
public class CategoryController {


@Autowired
private ICategoryService categoryService;
@GetMapping("/{category_id}")
public Optional<Category> getCategory(@PathVariable int category_id) {
	
	return categoryService.getCategory(category_id);
}

@GetMapping("/")
public List<Category> getAllCategories(){
	return categoryService.getAllCategories();
}

@PostMapping("/")
public Category addCategory(@RequestBody Category category) {
	return categoryService.addCategory(category);
}



}
