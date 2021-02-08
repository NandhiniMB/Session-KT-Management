package com.team6.internalPortal.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.team6.internetPortal.InternetPortalApplication;
import com.team6.internetPortal.entity.Comment;
import com.team6.internetPortal.entity.Report;
import com.team6.internetPortal.entity.User;
import com.team6.internetPortal.entity.Video;
import com.team6.internetPortal.repository.IReportsRepository;
import com.team6.internetPortal.service.IReportService;

@SpringBootTest(classes = InternetPortalApplication.class)
public class ReportsServiceImplTest {
    @Autowired
    private IReportService iReportService;
    
    @MockBean
    private IReportsRepository reportsRepository;

    @Before
    public void setUp() throws Exception {
    }
    
    public Report getByCommentId() {
    	Report report = new Report();
    	Comment comment = new Comment();
    	comment.setId(1);
    	report.setComment(comment);
    	return report;
    }
    
    public Report getByUserId() {
    	Report report = new Report();
    	User user = new User();
    	user.setId((long) 1);
    	report.setUser(user);
    	return report;
    }
    
    public Optional<Report> getByVid(){
    	Report report = new Report();
    	Video video = new Video();
    	video.setId(1);
    	report.setVideo(video);
    	return Optional.of(report);
    }
    
    @Test
    public void getByCommentIdTest() {
    	when(reportsRepository.findByCommentId(Mockito.any())).thenReturn(getByCommentId());
    	assertEquals(getByCommentId().getComment().getId(),iReportService.getByCommentId((long) 1).getComment().getId());
    }
    
    @Test
    public void getByUserIdTest() {
    	when(reportsRepository.findByUserId(Mockito.any())).thenReturn(getByUserId());
    	assertEquals(getByUserId().getUser().getId(),iReportService.getByUserId((long) 1).getUser().getId());
    }
    
    @Test
    public void getByVidTest() {
    	when(reportsRepository.findByVideoId(Mockito.any())).thenReturn(getByVid());
    	assertEquals(getByVid().get().getVideo().getId(),iReportService.getByVid((long) 1).get().getVideo().getId());
    }
}