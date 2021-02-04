package com.team6.internetPortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.team6.internetPortal.entity.Notification;

@Repository
public interface INotificationRepository extends JpaRepository<Notification, Long> {
	
	
	 @Query(value= "select * from notification  where user_id= ?1 and is_read = ?2",  nativeQuery = true)
	 public List<Notification> findByUserIdAndIs_read(long user_id,boolean state);

	 @Modifying
	@Query(value = "insert into notification (user_id, description,is_read) values (:subscribed_user_id, :description, 0)",nativeQuery = true)
	public void postNotifications(@Param("subscribed_user_id") long subscribed_user_id, @Param("description") String description);
	 
}
