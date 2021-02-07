package com.team6.internalPortal.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import com.team6.internetPortal.entity.Comment;
import com.team6.internetPortal.entity.Subscription;
import com.team6.internetPortal.repository.ICommentRepository;
import com.team6.internetPortal.repository.ISubscriptionRepository;
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
public class SubscriptionServiceTest {

    public SubscriptionServiceTest()
    {
        super();
    }

    @Autowired
    private ISubscriptionRepository iSubscriptionRepository;

    @Test
    public void func() throws Exception
    {
        String found[] = iSubscriptionRepository.findAllEmailByCategory(2);
        assertThat(found[0])
                .isEqualTo("a@a.com");

        iSubscriptionRepository.findAllUserByCategory(2);
    }
}