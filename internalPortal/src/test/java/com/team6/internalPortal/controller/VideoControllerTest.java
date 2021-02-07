package com.team6.internalPortal.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.team6.internetPortal.controller.VideoController;
import com.team6.internetPortal.entity.Category;
import com.team6.internetPortal.entity.User;
import com.team6.internetPortal.entity.Video;
import com.team6.internetPortal.service.IVideoService;

@RunWith(SpringJUnit4ClassRunner.class)
public class VideoControllerTest {

    public VideoControllerTest()
    {
        super();
    }

    @Mock
    private IVideoService iVideoService;

    @InjectMocks
    private  VideoController  videoController;

    @Before
    public void setUp() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(videoController)
                .build();
    }

    @Test
    public void func() throws Exception {

        Video video=new Video();
        Category c=new Category();
        c.setCategoryName("MVC");
        c.setId(3);
        User user=new User();
        user.setUserName("Ram");
        video.setId(3);
        video.setCategory(c);
        video.setCreator(user);


        List<Video> ls=new ArrayList<Video>();
        ls.add(video);

        when(videoController.getVideoByCategory(2)).thenReturn(ls);

        //get
        List<Video> v=videoController.getVideoByCategory(2);
        assertEquals(v.get(0).getCategory(), c);
    }
}