package com.team6.internetPortal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team6.internetPortal.entity.Notification;
import com.team6.internetPortal.service.INotificationService;

@RestController
@RequestMapping("notify")
public class NotificationController {

	@Autowired
	private INotificationService notificationService;
	
	
//	@GetMapping("/") 
//	public List<Notification> getNotification() {
//		return notificationService.getNotification();
//	}
	
	@GetMapping("/{user_id}") 
	public List<Notification> getUserUnreadNotification(@PathVariable long user_id) {
		return notificationService.getUserUnreadNotification(user_id,false);
	}
	
}
