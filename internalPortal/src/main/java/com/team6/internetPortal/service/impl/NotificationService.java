package com.team6.internetPortal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team6.internetPortal.entity.Notification;
import com.team6.internetPortal.repository.INotificationRepository;
import com.team6.internetPortal.service.INotificationService;

@Service
public class NotificationService implements INotificationService {

	
	@Autowired
	private INotificationRepository notificationRepository;
	
	@Override
	public List<Notification> getUserUnreadNotification(long user_id,boolean state) {
		return notificationRepository.findByUserIdAndIs_read(user_id,state);
	}

	@Override
	public Notification markNotificationRead(Notification notificationRead) {
		notificationRead.setRead(true);
		return notificationRepository.save(notificationRead);
	}

}
