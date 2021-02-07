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

import com.team6.internetPortal.controller.NotificationController;
import com.team6.internetPortal.entity.Notification;
import com.team6.internetPortal.service.INotificationService;


@RunWith(SpringJUnit4ClassRunner.class)
public class NotificationControllerTest {

    public NotificationControllerTest() {
        super();
    }

    private MockMvc mockMvc;

    @Mock
    private INotificationService iNotificationService;

    @InjectMocks
    private  NotificationController  notificationController;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(notificationController)
                .build();
    }

    @Test
    public void func() throws Exception {

        Notification noti=new Notification();
        noti.setDescription("wow");
        noti.setId(2);
        noti.setRead(true);

        List<Notification> ls=new ArrayList<Notification>();
        ls.add(noti);

        Long x=new Long(2);

        when(iNotificationService.getUserUnreadNotification(x,false)).thenReturn(ls);

        //get
        List<Notification> l2=iNotificationService.getUserUnreadNotification(x,false);
        assertEquals("wow", l2.get(0).getDescription());

    }

}