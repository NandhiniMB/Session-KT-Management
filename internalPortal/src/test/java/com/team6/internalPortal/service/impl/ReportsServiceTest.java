package com.team6.internalPortal.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import com.team6.internetPortal.entity.Comment;
import com.team6.internetPortal.entity.Report;
import com.team6.internetPortal.entity.Video;
import com.team6.internetPortal.repository.ICommentRepository;
import com.team6.internetPortal.repository.IReportsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ReportsServiceTest {

    public ReportsServiceTest()
    {
        super();
    }

    @Autowired
    private IReportsRepository iReportsRepository;

    @Test
    public void func() throws Exception
    {
        List<Report> found = iReportsRepository.findReportedVideos();
        assertThat(found.get(0).getId())
                .isEqualTo(1);

        Report found1 = iReportsRepository.findByCommentId(new Long(2));
        assertThat(found1.getComment())
                .isEqualTo("ok");


        Report found2 = iReportsRepository.findByUserId(new Long(2));
        assertThat(found2.getComment())
                .isEqualTo("well");
    }
}