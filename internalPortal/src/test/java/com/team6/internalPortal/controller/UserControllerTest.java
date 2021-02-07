package com.team6.internalPortal.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.team6.internetPortal.controller.UserController;
import com.team6.internetPortal.entity.User;
import com.team6.internetPortal.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTest {

    public UserControllerTest(){
        super();
    }

    private MockMvc mockMvc;

    @Mock
    private IUserService iUserService;

    @InjectMocks
    private  UserController  userController;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(userController)
                .build();
    }

    @Test
    public void func() throws Exception {

        User user=new User();
        user.setUserName("raj");
        user.setEmail("sn@d.com");
        user.setId(new Long(3));
        user.setPassword("omg");

        Mockito.when(iUserService.fetchUserByEmailId("sn@d.com")).thenReturn(user);


        //get
        User returned=iUserService.fetchUserByEmailId("sn@d.com");
        assertEquals(returned.getUserName(), "raj");
        System.out.println(returned.getUserName());


        User user1=new User();
        user.setUserName("mohit");
        user.setEmail("goa@panjim.com");
        user.setId(new Long(5));
        user.setPassword("omg");
        Mockito.when(iUserService.saveUser(user)).thenReturn(user);

        //post
        User check=iUserService.saveUser(user);
        assertEquals(check.getEmail(),"goa@panjim.com");
        System.out.println(check.getEmail());

    }
}