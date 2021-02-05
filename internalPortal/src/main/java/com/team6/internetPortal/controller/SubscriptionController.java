package com.team6.internetPortal.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.team6.internalPortal.RequestBody.MailRequest;
import com.team6.internetPortal.entity.Subscription;
import com.team6.internetPortal.service.ISubscriptionService;

@RestController
@RequestMapping("subs")
public class SubscriptionController {

	@Autowired
	private ISubscriptionService subscriptionService;
	
	@PostMapping("/sendmail")
	public void send_mail(@RequestBody MailRequest mailrequest) throws MessagingException
	{
		subscriptionService.send_mail(mailrequest);
		return ;
		
	}
	
	@PostMapping("/subscribe")
	@CrossOrigin(origins="http://localhost:4200")
	public Subscription saveSubscription(@RequestBody Subscription userSubscription) {
		return subscriptionService.saveSubscription(userSubscription);
	}
}
