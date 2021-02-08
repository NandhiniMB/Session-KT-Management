package com.team6.internetPortal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team6.internetPortal.entity.Category;
import com.team6.internetPortal.service.ICategoryService;

@RestController
@RequestMapping("category")
public class CategoryController {

	@Autowired
	private ICategoryService categoryService;
	
	@GetMapping("/")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Category> getAllCategories() {
		return categoryService.getAllCategories();
	}

	@GetMapping("/{category_id}")
	public Optional<Category> getCategory(@PathVariable int category_id) {
		return categoryService.getCategory(category_id);
	}


	@PostMapping("/")
	public Category addCategory(@RequestBody Category category) {
		
		return categoryService.addCategory(category);
	}
	
	@PutMapping("/")
     public Category updateCategory(@RequestBody Category category) {
		
		return categoryService.updateCategory(category);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable int  id) {
		categoryService.deleteCategory(id);
	}

}
