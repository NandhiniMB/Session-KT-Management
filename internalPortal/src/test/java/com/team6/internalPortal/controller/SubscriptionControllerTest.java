package com.team6.internalPortal.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.team6.internetPortal.controller.CommentController;
import com.team6.internetPortal.entity.Subscription;
import com.team6.internetPortal.entity.User;
import com.team6.internetPortal.service.ISubscriptionService;

@RunWith(SpringJUnit4ClassRunner.class)
public class SubscriptionControllerTest {

    public SubscriptionControllerTest()
    {
        super();
    }

    private MockMvc mockMvc;

    @Mock
    private ISubscriptionService iSubscriptionService;

    @InjectMocks
    private  CommentController  commentController;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(commentController)
                .build();
    }

    @Test
    public void func() throws Exception {

        Subscription sc=new Subscription();
        User u=new User();
        u.setUserName("rahul");
        sc.setId(3);
        sc.setSubscriber(u);

        when(iSubscriptionService.saveSubscription(sc)).thenReturn(sc);

        //post
        Subscription sc2=iSubscriptionService.saveSubscription(sc);
        assertEquals(sc, sc2);
    }
}