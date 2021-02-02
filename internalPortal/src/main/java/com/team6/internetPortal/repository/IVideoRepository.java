package com.team6.internetPortal.repository;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.team6.internetPortal.entity.Category;
import com.team6.internetPortal.entity.Video;

@Repository
public interface IVideoRepository extends JpaRepository<Video,Long> {

//	public List<Video> findAllVideoByCategory(int id);

	//@Query(value = "SELECT * FROM video v WHERE v.category_id  = ?1 ", nativeQuery = true)
	public List<Video> findByCategoryId(int id);
	
	//@Query(value = "SELECT * FROM video v WHERE v.creator_id  = :id ", nativeQuery = true)
	public List<Video> findByCreatorId(long id);

	@Query(value = "SELECT * FROM video v join subscription s on v.category_id  = s.category_id where s.subscriber_id=:id ", nativeQuery = true)
	public List<Video> findBySubscription(long id);

	@Modifying
	@Transactional
	@Query("update Video db set db.title=:title,db.description=:description, db.createdOn=:created_on, db.lastModifiedOn=:last_modified_on where db.id=:id")
	public int update(@Param("id") Long id,@Param("title") String title,@Param("description") String description, 
			 @Param("created_on") Date created_on,@Param("last_modified_on") Date last_modified_on);
	
	


}
