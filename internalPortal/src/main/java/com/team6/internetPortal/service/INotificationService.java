package com.team6.internetPortal.service;

import java.util.List;

import com.team6.internetPortal.entity.Notification;

public interface INotificationService {

	public List<Notification> getUserUnreadNotification(long user_id,boolean state);

	public Object markNotificationRead(Notification notificationRead);


}
