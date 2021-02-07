package com.team6.internalPortal.controller;

import com.team6.internetPortal.InternetPortalApplication;
import com.team6.internetPortal.controller.AdminController;
import com.team6.internetPortal.controller.CommentController;
import com.team6.internetPortal.entity.Comment;
import com.team6.internetPortal.service.IAdminService;
import com.team6.internetPortal.service.ICommentService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes= InternetPortalApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminControllerTest {
    public AdminControllerTest()
    {
        super();
    }

    private MockMvc mockMvc;

    @Mock
    private IAdminService iAdminService;

    @InjectMocks
    private AdminController adminController;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(adminController)
                .build();
    }

    @Test
    public void func() throws Exception {

        Set<String> hash_Set
                = new HashSet<String>();
        hash_Set.add("Aman");
        hash_Set.add("Vansh");
        hash_Set.add("vatsal");


        when(iAdminService.getAllAdmin()).thenReturn(hash_Set);


        //get
        Set<String> st2=iAdminService.getAllAdmin();
        assertEquals(hash_Set, st2);
        System.out.println(st2);

    }
}