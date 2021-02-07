package com.team6.internalPortal.service.impl;

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
public class CommentServiceTest {


    public CommentServiceTest()
    {
        super();
    }

    @Autowired
    private ICommentRepository iCommentRepository;


    @Test
    public void func() throws Exception
    {

        Long x=new Long(3);

        List<Comment> found = iCommentRepository.findByVideoId(x);
        assertThat(found.get(0).getComment())
                .isEqualTo("great");


        Optional<Comment> found1 = iCommentRepository.findById(new Long(7));
        assertThat(found1.get().getComment())
                .isEqualTo("very good");


        Comment found2 = iCommentRepository.findByCommentorId(new Long(4));
        assertThat(found1.get().getComment())
                .isEqualTo("very good");
    }
}