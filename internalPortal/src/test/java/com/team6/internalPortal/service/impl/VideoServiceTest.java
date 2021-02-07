package com.team6.internalPortal.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import com.team6.internetPortal.entity.Comment;
import com.team6.internetPortal.entity.Video;
import com.team6.internetPortal.repository.ICommentRepository;
import com.team6.internetPortal.repository.IVideoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
public class VideoServiceTest {

    public VideoServiceTest()
    {
        super();
    }

    @Qualifier("IVideoRepository")
    @Autowired
    private IVideoRepository iVideoRepository;


    @Test
    public void func() throws Exception
    {
        List<Video> found = iVideoRepository.findByCreatorId(3);
        assertThat(found.get(0).getTitle())
                .isEqualTo("xyz");

        List<Video> found1 = iVideoRepository.findBySubscription(1);
        assertThat(found.get(0).getId())
                .isEqualTo(3);

        List<Video> found2 = iVideoRepository.findByCategoryId(2);
        assertThat(found.get(0).getTitle())
                .isEqualTo("xyz");
    }
}