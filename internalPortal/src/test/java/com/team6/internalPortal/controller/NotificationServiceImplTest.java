package com.team6.internalPortal.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.team6.internetPortal.InternetPortalApplication;
import com.team6.internetPortal.entity.Notification;
import com.team6.internetPortal.repository.INotificationRepository;
import com.team6.internetPortal.service.INotificationService;


@SpringBootTest(classes = InternetPortalApplication.class)
public class NotificationServiceImplTest {

    @Autowired
    private INotificationService iNotificationService;

    @MockBean
    private INotificationRepository iNotificationRepository;

    @Before
    public void setUp() throws Exception {
    	
    }
    
    static Notification notification = new Notification();
    
    public static Notification createNotification() {
    	notification.setId(1);
    	return notification;
    }
    
    @Test
    public void markNotificationReadTest() {
    	when(iNotificationRepository.save(Mockito.any())).thenReturn(createNotification());
    	assertEquals(createNotification(),iNotificationService.markNotificationRead(createNotification()));
    }

//    @Test
//    public void func() throws Exception {
//
//        Notification noti=new Notification();
//        noti.setDescription("wow");
//        noti.setId(2);
//        noti.setRead(true);
//
//        List<Notification> ls=new ArrayList<Notification>();
//        ls.add(noti);
//
//        Long x=new Long(2);
//
//        when(iNotificationService.getUserUnreadNotification(x,false)).thenReturn(ls);
//
//        //get
//        List<Notification> l2=iNotificationService.getUserUnreadNotification(x,false);
//        assertEquals("wow", l2.get(0).getDescription());
//
//    }

}