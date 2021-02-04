package com.team6.internetPortal.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class SendMailService {

	
	@Autowired
    private JavaMailSender javaMailSender;
    
    void sendEmail(String[] email, String categoryName,String videoTitle) {

        SimpleMailMessage msg = new SimpleMailMessage();
//        msg.setFrom("nandhinimb.cit@gmail.com");
       // msg.setbcc(email);
        msg.setBcc(email);
        msg.setSubject("Internal Portal Subscription");
        msg.setText("Greetings of the day!, \n\nNew Video is published in the Category "+categoryName+" titled "+videoTitle+"!.\n\n Regards,\nInternal Portal Team");

        javaMailSender.send(msg);

    }
    
}
