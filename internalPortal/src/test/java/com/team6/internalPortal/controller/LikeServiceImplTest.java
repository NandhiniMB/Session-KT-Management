package com.team6.internalPortal.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.team6.internetPortal.InternetPortalApplication;
import com.team6.internetPortal.entity.Like;
import com.team6.internetPortal.repository.ILikeRepository;
import com.team6.internetPortal.service.impl.LikeService;

@SpringBootTest(classes = InternetPortalApplication.class)
public class LikeServiceImplTest {

    @Autowired
    private LikeService iLikeService;
    
    @MockBean
    private ILikeRepository userLikesRepository;

    @Before
    public void setUp() throws Exception {	
    	
    }
    
    public static Like createLike() {
    	Like like = new Like();
    	like.setId(1);
    	return like;
    }
    
    public static List<Like> getAllLikes(){
    	List<Like> likes=new ArrayList<Like>();
    	Like like = new Like();
    	like.setId(1);
    	Like like2 = new Like();
    	like2.setId(2);
    	likes.add(like);
    	likes.add(like2);
    	return likes;
    }
    
//    public static 

    @Test
    public void saveLikeTest() throws Exception {
    	when(userLikesRepository.save(Mockito.any())).thenReturn(createLike());
    	assertEquals(createLike().getId(),iLikeService.saveLike(createLike()).getId());
    }
    
    @Test
    public void getAllLikesTest() throws Exception {
    	when(userLikesRepository.findAll()).thenReturn(getAllLikes());
    	assertEquals(getAllLikes().get(0).getId(),iLikeService.getAllLikes().get(0).getId());
    	assertEquals(getAllLikes().get(1).getId(),iLikeService.getAllLikes().get(1).getId());
    }    
}