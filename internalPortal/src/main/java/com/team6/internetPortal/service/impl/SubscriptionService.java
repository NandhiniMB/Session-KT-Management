package com.team6.internetPortal.service.impl;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team6.internalPortal.RequestBody.MailRequest;
import com.team6.internetPortal.entity.Subscription;
import com.team6.internetPortal.repository.ISubscriptionRepository;
import com.team6.internetPortal.service.ISubscriptionService;

@Service
public class SubscriptionService implements ISubscriptionService{
	
	
	@Autowired
	private ISubscriptionRepository subscriptionRepository;
	
	@Autowired
	private SendMailService  sendmailService;
	
	@Override
	public void send_mail(MailRequest mailrequest) throws MessagingException {
		String[] email =subscriptionRepository.findAllEmailByCategory(mailrequest.getCategory().getId());
		System.out.println(email);
		String content = "Greetings of the day!, \n\nNew Video is published in the Category "+mailrequest.getCategory().getCategoryName() +" titled "+mailrequest.getVideo().getTitle()+"!.\n\n Regards,\nInternal Portal Team";
		sendmailService.sendEmail(email,content );
            //sendEmailWithAttachment();

        System.out.println("Done");
	}
	
	@Override
	public Subscription saveSubscription(Subscription userSubscription) {
		return subscriptionRepository.save(userSubscription);
	}
	

}
