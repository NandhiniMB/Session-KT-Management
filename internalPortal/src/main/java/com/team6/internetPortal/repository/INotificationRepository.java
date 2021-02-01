package com.team6.internetPortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.team6.internetPortal.entity.Notification;

@Repository
public interface INotificationRepository extends JpaRepository<Notification, Integer> {
	
	
	 @Query(value= "select * from notification  where user_id= ?1 and isRead = ?2",  nativeQuery = true)
	 public List<Notification> findByUserIdAndIs_read(long user_id,boolean state);
	 
}
