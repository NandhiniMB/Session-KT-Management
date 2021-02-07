package com.team6.internalPortal.controller;

import com.team6.internetPortal.controller.CategoryController;
import com.team6.internetPortal.entity.Category;
import com.team6.internetPortal.service.ICategoryService;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;
import com.team6.internetPortal.entity.Comment;
import com.team6.internetPortal.service.ICommentService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@RunWith(SpringJUnit4ClassRunner.class)
public class CategoryControllerTest {

    public CategoryControllerTest()
    {
        super();
    }

    private MockMvc mockMvc;

    @Mock
    private ICategoryService iCategoryService;

    @InjectMocks
    private  CategoryController  categoryController;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(categoryController)
                .build();
    }

    @Test
    public void func() throws Exception {

        Integer cid=3;
        Category c=new Category();
        c.setCategoryName("boot");
        c.setId(cid);

        Category l1=new Category();

        when(categoryController.getCategory(cid)).thenReturn(Optional.of(l1));

        //get
        Optional l2=categoryController.getCategory(cid);

    }
}