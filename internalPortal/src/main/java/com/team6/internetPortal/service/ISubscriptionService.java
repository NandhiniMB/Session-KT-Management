package com.team6.internetPortal.service;

import javax.mail.MessagingException;

import com.team6.internalPortal.RequestBody.MailRequest;

public interface ISubscriptionService {

	public void send_mail(MailRequest mailrequest) throws MessagingException;

}
