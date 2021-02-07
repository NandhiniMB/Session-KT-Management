package com.team6.internetPortal.service.impl;

import com.team6.internetPortal.entity.Category;
import com.team6.internetPortal.entity.Comment;
import com.team6.internetPortal.repository.ICategoryRepository;
import com.team6.internetPortal.repository.ICommentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CategoryServiceTest {

    public CategoryServiceTest()
    {
        super();
    }

    @Qualifier("ICategoryRepository")
    @Autowired
    private ICategoryRepository iCategoryRepository;


    @Test
    public void func() throws Exception
    {
        Optional<Category> found = iCategoryRepository.findById(2);
        System.out.println(found.get().getCategoryName());


        assertThat(found.get().getCategoryName())
                .isEqualTo("spring");
    }
}