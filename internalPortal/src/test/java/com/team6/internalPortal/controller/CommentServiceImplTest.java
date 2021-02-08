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
import com.team6.internetPortal.entity.Comment;
import com.team6.internetPortal.entity.User;
import com.team6.internetPortal.entity.Video;
import com.team6.internetPortal.repository.ICommentRepository;
import com.team6.internetPortal.service.ICommentService;


@SpringBootTest(classes = InternetPortalApplication.class)
public class CommentServiceImplTest {

    @Autowired
    private ICommentService iCommentService;

    @MockBean
    private ICommentRepository iCommentRepository;

    @Before
    public void setUp() throws Exception {

    }
    
    public static Comment createComment() {
    	Comment comment = new Comment();
    	comment.setId(1);
    	return comment;
    }
    
    public static Optional<Comment> getComment() {
    	Comment comment = new Comment();
    	comment.setId(1);
    	return Optional.of(comment);
    }
    
    public static List<Comment> getCommentByVidId() {
    	List<Comment> comments = new ArrayList<Comment>();
    	Comment comment = new Comment();
    	Video video = new Video();
    	video.setId(1);
    	comment.setVideo(video);
    	Comment comment2 = new Comment();
    	Video video2 = new Video();
    	video2.setId(2);
    	comment2.setVideo(video);
    	comments.add(comment);
    	comments.add(comment2);
    	return comments;
    }
    
    public static Comment getCommentByCommenterId() {
    	Comment comment = new Comment();
    	User user = new User();
    	user.setId((long) 1);
    	comment.setCommentor(user);
    	return comment;
    }
    
    @Test
    public void addCategoryTest() throws Exception {
        when(iCommentRepository.save(Mockito.any())).thenReturn(createComment());
        assertEquals(createComment().getId(),iCommentService.saveComment(createComment()).getId());
    }
    
    @Test
    public void findByCommentIdTest() {
    	when(iCommentRepository.findById(Mockito.any())).thenReturn(getComment());
    	assertEquals(getComment().get().getId(),iCommentService.findByCommentId((long) 1).get().getId());
    }
    
    @Test
    public void getCommentTest() {
    	when(iCommentRepository.findByVideoId(Mockito.any())).thenReturn(getCommentByVidId());
    	assertEquals(getCommentByVidId().get(0).getVideo().getId(),iCommentService.getComment((long) 1).get(0).getVideo().getId());
    }
    
    @Test
    public void findwithCommentrIdTest() {
    	when(iCommentRepository.findByCommentorId(Mockito.any())).thenReturn(getCommentByCommenterId());
    	assertEquals(getCommentByCommenterId().getCommentor().getId(),iCommentService.findwithCommentrId((long) 1).getCommentor().getId());
    }

//    @Test
//    public void func() throws Exception {
//
//        Long vid=new Long(3);
//        Comment c=new Comment();
//        c.setComment("hi");
//
//        List<Comment> l1=new ArrayList<Comment>();
//        l1.add(c);
//
//        Comment c_post=new Comment();
//        c_post.setComment("very good");
//        c_post.setId(4);
//
//
//        when(iCommentService.getComment(vid)).thenReturn(l1);
//        Mockito.when(iCommentService.saveComment(c_post)).thenReturn(c_post);
//
//        //get
//        List<Comment> l2=iCommentService.getComment(vid);
//        assertEquals(l1, l2);
//
//        //post
//        Comment check=iCommentService.saveComment(c_post);
//        assertEquals(check.getComment(),c_post.getComment());
//        assertEquals(check.getId(),c_post.getId());
//
//
//        //to check Rest Controller
////        mockMvc.perform(get("/comments/3")
////                .accept(MediaType.APPLICATION_JSON))
////                .andExpect(status().isOk())
////                .andExpect(jsonPath("$[0].comment", Matchers.is("great")));
//
//    }
}