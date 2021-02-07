package com.team6.internetPortal.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import com.team6.internetPortal.entity.Comment;
import com.team6.internetPortal.entity.Notification;
import com.team6.internetPortal.entity.User;
import com.team6.internetPortal.repository.ICommentRepository;
import com.team6.internetPortal.repository.INotificationRepository;
import com.team6.internetPortal.repository.IUserRepository;
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
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserServiceTest {

    public UserServiceTest()
    {
        super();
    }

    @Qualifier("IUserRepository")
    @Autowired
    private IUserRepository iUserRepository;

    @Test
    public void func()
    {
        //find by id
        Optional<User> found = iUserRepository.findById(new Long(9));
        assertThat(found.get().getName())
                .isEqualTo("rohan");

        //find by email
        User found1 = iUserRepository.findByEmail("a@a.com");
        assertThat(found1.getName())
                .isEqualTo("yash");

    }
}