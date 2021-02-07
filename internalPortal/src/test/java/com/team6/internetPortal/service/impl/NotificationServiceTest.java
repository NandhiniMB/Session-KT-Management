package com.team6.internetPortal.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import com.team6.internetPortal.entity.Comment;
import com.team6.internetPortal.entity.Notification;
import com.team6.internetPortal.repository.ICommentRepository;
import com.team6.internetPortal.repository.INotificationRepository;
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
public class NotificationServiceTest {

    public NotificationServiceTest()
    {
        super();
    }


    @Qualifier("INotificationRepository")
    @Autowired
    private INotificationRepository iNotificationRepository;

    @Test
    public void func()
    {
        List<Notification> found = iNotificationRepository.findByUserIdAndIs_read(3,true);
        assertThat(found.get(0).getDescription())
                .isEqualTo("gg");


        Long x=new Long(4);
        Long y=new Long(0);
        Optional<Notification> found1 = iNotificationRepository.findById(x);
        assertThat(found1.get().getDescription())
                .isEqualTo("yes good");

        System.out.println(found.size());
    }



}