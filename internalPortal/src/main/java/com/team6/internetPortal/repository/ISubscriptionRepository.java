package com.team6.internetPortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.team6.internetPortal.entity.Subscription;
import com.team6.internetPortal.entity.User;

public interface ISubscriptionRepository  extends JpaRepository<Subscription, Long> {

	@Query(value = "SELECT u.email FROM subscription s join user u on s.category_id = :id and s.subscriber_id=u.id", nativeQuery = true)
	String[] findAllEmailByCategory(@Param("id") int id);

	@Query(value = "SELECT u.id FROM subscription s join user u on s.category_id = :id and s.subscriber_id=u.id ", nativeQuery = true)
	int[] findAllUserByCategory(@Param("id") int id);
	
}
