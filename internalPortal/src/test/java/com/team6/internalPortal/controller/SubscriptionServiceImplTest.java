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

import com.team6.internetPortal.InternetPortalApplication;
import com.team6.internetPortal.entity.Subscription;
import com.team6.internetPortal.entity.User;
import com.team6.internetPortal.repository.ISubscriptionRepository;
import com.team6.internetPortal.service.ISubscriptionService;

@SpringBootTest(classes = InternetPortalApplication.class)
public class SubscriptionServiceImplTest {

    @Autowired
    private ISubscriptionService iSubscriptionService;

    @MockBean
    private ISubscriptionRepository iSubscriptionRepository;

    @Before
    public void setUp() throws Exception {

    }
    
    public static Subscription createSubscription() {
    	Subscription subs = new Subscription();
    	subs.setId(1);
    	return subs;
    }
    
    public static List<Subscription> getAllSubscription(){
    	List<Subscription> subscriptions = new ArrayList<Subscription>();
    	Subscription subscription = new Subscription();
    	User user = new User();
    	user.setId((long) 1);
    	subscription.setSubscriber(user);
    	subscriptions.add(subscription);
    	return subscriptions;
    }
    
    @Test
    public void saveSubscriptionTest() {
    	when(iSubscriptionRepository.save(Mockito.any())).thenReturn(createSubscription());
    	assertEquals(createSubscription().getId(),iSubscriptionService.saveSubscription(createSubscription()).getId());
    }
    
    @Test
    public void getAllSubscriptionsTest() {
    	when(iSubscriptionRepository.findAllByUserId(new Long(1))).thenReturn(getAllSubscription());
    	assertEquals(getAllSubscription().get(0).getSubscriber().getId(),iSubscriptionService.getAllSubscriptions(1).get(0).getSubscriber().getId());
    }

//    @Test
//    public void func() throws Exception {
//
//        Subscription sc=new Subscription();
//        User u=new User();
//        u.setUserName("rahul");
//        sc.setId(3);
//        sc.setSubscriber(u);
//
//        when(iSubscriptionService.saveSubscription(sc)).thenReturn(sc);
//
//        //post
//        Subscription sc2=iSubscriptionService.saveSubscription(sc);
//        assertEquals(sc, sc2);
//    }
}