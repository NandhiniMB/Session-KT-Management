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
    
    void sendEmail(String[] email, String content) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setBcc(email);
        msg.setSubject("Internal Portal Subscription");
        msg.setText(content);
        javaMailSender.send(msg);

    }
    
}
