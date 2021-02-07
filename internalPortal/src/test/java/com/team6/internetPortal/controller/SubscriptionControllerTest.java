package com.team6.internetPortal.controller;

import static org.junit.jupiter.api.Assertions.*;
import com.team6.internetPortal.entity.Comment;
import com.team6.internetPortal.entity.Subscription;
import com.team6.internetPortal.entity.User;
import com.team6.internetPortal.service.ICommentService;
import com.team6.internetPortal.service.ISubscriptionService;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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