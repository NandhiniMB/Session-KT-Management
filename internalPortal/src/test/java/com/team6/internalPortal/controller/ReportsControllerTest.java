package com.team6.internalPortal.controller;

import com.team6.internetPortal.entity.Report;
import com.team6.internetPortal.entity.User;
import com.team6.internetPortal.service.IReportService;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;

import com.team6.internetPortal.controller.ReportsController;
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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class ReportsControllerTest {

    public ReportsControllerTest()
    {
        super();
    }

    private MockMvc mockMvc;

    @Mock
    private IReportService iReportService;

    @InjectMocks
    private  ReportsController  reportsController;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(reportsController)
                .build();
    }


    @Test
    public void func() throws Exception {

        Report r=new Report();
        Comment c=new Comment();
        c.setComment("hi");
        User u=new User();
        u.setUserName("rohan");
        r.setComment(c);

        when(iReportService.getReport(new Long(3))).thenReturn(Optional.of(r));

        //get
        Optional<Report> r1=iReportService.getReport(new Long(3));
        assertEquals(r1.get().getComment().getComment(), "hi");

    }
}