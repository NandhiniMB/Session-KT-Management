package com.team6.internetPortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.team6.internetPortal.entity.Subscription;
import com.team6.internetPortal.entity.User;

public interface ISubscriptionRepository  extends JpaRepository<Subscription, Long> {

	@Query(value = "SELECT u.email FROM subscription s join user u on s.category_id = :id and s.subscriber_id=u.id", nativeQuery = true)
	String[] findAllEmailByCategory(@Param("id") int id);

	@Query(value = "SELECT u.id FROM subscription s join user u on s.category_id = :id and s.subscriber_id=u.id ", nativeQuery = true)
	int[] findAllUserByCategory(@Param("id") int id);
	
	@Query(value="SELECT * FROM subscription s WHERE s.subscriber_id=:id", nativeQuery = true)
	List<Subscription> findAllByUserId(@Param("id") long id);

	@Modifying
	@Query(value="DELETE FROM subscription s WHERE s.category_id = :catId AND s.subscriber_id = :userId",nativeQuery=true)
	@Transactional
	void deleteByCatUser(@Param("catId") int catId,@Param("userId") long userId);
}
