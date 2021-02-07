package com.team6.internetPortal.controller;

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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringJUnit4ClassRunner.class)
public class CommentControllerTest {

    public CommentControllerTest()
    {
        super();
    }

    private MockMvc mockMvc;

    @Mock
    private ICommentService iCommentService;

    @InjectMocks
    private  CommentController  commentController;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(commentController)
                .build();
    }

    @Test
    public void func() throws Exception {

        Long vid=new Long(3);
        Comment c=new Comment();
        c.setComment("hi");

        List<Comment> l1=new ArrayList<Comment>();
        l1.add(c);

        Comment c_post=new Comment();
        c_post.setComment("very good");
        c_post.setId(4);


        when(iCommentService.getComment(vid)).thenReturn(l1);
        Mockito.when(iCommentService.saveComment(c_post)).thenReturn(c_post);

        //get
        List<Comment> l2=iCommentService.getComment(vid);
        assertEquals(l1, l2);

        //post
        Comment check=iCommentService.saveComment(c_post);
        assertEquals(check.getComment(),c_post.getComment());
        assertEquals(check.getId(),c_post.getId());


        //to check Rest Controller
//        mockMvc.perform(get("/comments/3")
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].comment", Matchers.is("great")));

    }
}