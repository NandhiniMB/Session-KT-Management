package com.team6.internetPortal.repository;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.team6.internetPortal.constants.Constants.status;
import com.team6.internetPortal.entity.Category;
import com.team6.internetPortal.entity.User;
import com.team6.internetPortal.entity.Video;

@Repository
public interface IVideoRepository extends JpaRepository<Video,Long> {

//	public List<Video> findAllVideoByCategory(int id);

	//@Query(value = "SELECT * FROM video v WHERE v.category_id  = ?1 ", nativeQuery = true)
	public List<Video> findByCategoryId(int id);
	
	//@Query(value = "SELECT * FROM video v WHERE v.creator_id  = :id ", nativeQuery = true)
	public List<Video> findByCreatorId(long id);

	@Query(value = "SELECT * FROM video v join subscription s on v.category_id  = s.category_id where s.subscriber_id=:id and v.status='APPROVED'", nativeQuery = true)
	public List<Video> findBySubscription(long id);

	@Modifying
	@Transactional
	@Query("update Video db set db.title=:title,db.description=:description,db.creator=:creator, db.createdOn=:created_on, db.lastModifiedOn=:last_modified_on, db.category=:category, db.status=:status where db.id=:id")
	public int update(@Param("id") Long id,@Param("title") String title,@Param("description") String description, 
			@Param("creator") User creator, @Param("created_on") Date created_on,@Param("last_modified_on") Date last_modified_on, @Param("category") Category category, @Param("status") status status);

	
	
	@Query(value = "SELECT * FROM video v  join report r on r.video_id = v.id", nativeQuery = true)
	public List<Video> findReportedVideos();

	
	@Query(value = "SELECT * FROM video v  where v.status = 'PENDING'" ,nativeQuery = true)
	public List<Video> findPendingVideos(@Param("pending") status pending);

	@Query(value = "SELECT * FROM video v  where v.status = 'APPROVED'" ,nativeQuery = true)
	public List<Video> findApprovedVideos(@Param("approved") status approved);

	
	@Query(value = "SELECT v.views FROM video v  where v.status = 'APPROVED' and v.id=:id" ,nativeQuery = true)
	public long getViewCount(@Param("id") long id);


	
	


}
