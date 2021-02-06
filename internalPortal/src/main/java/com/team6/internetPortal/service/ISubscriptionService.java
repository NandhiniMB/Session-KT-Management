package com.team6.internetPortal.service;

import java.util.List;

import javax.mail.MessagingException;

import com.team6.internalPortal.RequestBody.MailRequest;
import com.team6.internetPortal.entity.Like;
import com.team6.internetPortal.entity.Subscription;

public interface ISubscriptionService {

	public void send_mail(MailRequest mailrequest) throws MessagingException;

	public Subscription saveSubscription(Subscription userSubscription);

	public List<Subscription> getAllSubscriptions(long id);

	public void deleteSubscription(int catId, long userId);

}
