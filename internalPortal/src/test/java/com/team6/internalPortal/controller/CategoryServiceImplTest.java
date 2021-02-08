package com.team6.internalPortal.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.team6.internetPortal.InternetPortalApplication;
import com.team6.internetPortal.entity.Category;
import com.team6.internetPortal.entity.Like;
import com.team6.internetPortal.repository.ICategoryRepository;
import com.team6.internetPortal.service.ICategoryService;


@SpringBootTest(classes = InternetPortalApplication.class)
public class CategoryServiceImplTest {

    @Autowired
    private ICategoryService iCategoryService;

    @MockBean
    private ICategoryRepository iCategoryRepository;

    @Before
    public void setUp() throws Exception {

    }
    
    public static Category createCategory() {
    	Category category = new Category();
    	category.setId(1);
    	return category;
    }
    
    public static List<Category> getAllCategory(){
    	List<Category> categories=new ArrayList<Category>();
    	Category category = new Category();
    	category.setId(1);
    	Category category2 = new Category();
    	category2.setId(2);
    	categories.add(category);
    	categories.add(category2);
    	return categories;
    }

    public static Optional<Category> getCategory() {
    	Category category = new Category();
    	category.setId(1);
    	return Optional.of(category);
    }
    
    @Test
    public void addCategoryTest() throws Exception {
        when(iCategoryRepository.save(Mockito.any())).thenReturn(createCategory());
        assertEquals(createCategory().getId(),iCategoryService.addCategory(createCategory()).getId());
    }
    
    @Test
    public void getAllCategoriesTest() throws Exception {
    	when(iCategoryRepository.findAll()).thenReturn(getAllCategory());
    	assertEquals(getAllCategory().get(0).getId(),iCategoryService.getAllCategories().get(0).getId());
    	
    }
    
    @Test
    public void getCategoryTest() {
    	when(iCategoryRepository.findById(Mockito.any())).thenReturn(getCategory());
    	assertEquals(getCategory().get().getId(),iCategoryService.getCategory(1).get().getId());
    }
}