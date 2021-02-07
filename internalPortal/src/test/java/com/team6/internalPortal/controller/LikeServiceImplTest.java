package com.team6.internalPortal.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

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

    @Test
    public void saveLikeTest() throws Exception {
    	when(userLikesRepository.save(Mockito.any())).thenReturn(createLike());
    	assertEquals(createLike().getId(),iLikeService.saveLike(null).getId());
    }
}