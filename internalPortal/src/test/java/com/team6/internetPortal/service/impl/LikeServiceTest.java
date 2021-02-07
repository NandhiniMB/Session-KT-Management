package com.team6.internetPortal.service.impl;

import com.team6.internetPortal.entity.Like;
import com.team6.internetPortal.entity.Notification;
import com.team6.internetPortal.repository.ICommentRepository;
import com.team6.internetPortal.repository.ILikeRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.team6.internetPortal.entity.Comment;
import com.team6.internetPortal.repository.ICommentRepository;
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
public class LikeServiceTest {

    public LikeServiceTest()
    {
        super();
    }

    @Autowired
    private ILikeRepository iLikeRepository;

    @Test
    public void func() throws Exception
    {
        Optional<Like> found = iLikeRepository.findById(new Long(2));
        System.out.println(found.get().getLikedUser());

        assertThat(found.get().getLikedUser().getName())
                .isEqualTo("yash");
    }
}