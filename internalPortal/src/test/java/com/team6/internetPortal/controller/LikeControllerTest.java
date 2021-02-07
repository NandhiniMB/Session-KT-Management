package com.team6.internetPortal.controller;
import com.team6.internetPortal.entity.Comment;
import com.team6.internetPortal.entity.Like;
import com.team6.internetPortal.entity.User;
import com.team6.internetPortal.service.ICommentService;
import com.team6.internetPortal.service.ILikeService;
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

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class LikeControllerTest {

    public LikeControllerTest()
    {
        super();
    }

    private MockMvc mockMvc;

    @Mock
    private ILikeService iLikeService;

    @InjectMocks
    private  LikeController  likeController;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(likeController)
                .build();
    }

    @Test
    public void func() throws Exception {

        User user=new User();
        user.setUserName("raj");
        Like like=new Like();
        like.setLikedUser(user);
        like.setId(4);

        Mockito.when(iLikeService.saveLike(like)).thenReturn(like);

        //save
        Like ret_obj=iLikeService.saveLike(like);
        assertEquals(like.getLikedUser().getName(), ret_obj.getLikedUser().getName());

    }
}