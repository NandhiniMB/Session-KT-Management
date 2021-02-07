package com.team6.internetPortal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.team6.internetPortal.entity.Report;

public interface IReportsRepository extends JpaRepository<Report, Long> {

	 
     	 public Report findByCommentId(Long vid);



	    public Optional<Report> findById(Long id);


	    public Report findByUserId(Long uid);



	    @Query(value = "SELECT * FROM report r join video v on r.video_id = v.id", nativeQuery = true)
		public List<Report> findReportedVideos();
	    
		public Optional<Report> findByVideoId(Long id);


		 @Modifying
		@Query(value = "insert into report(user_id,video_id) values(:user_id,:video_id) ", nativeQuery = true)
		public void saveReport(@Param("video_id")long video_id, @Param("user_id") long user_id);



		 @Modifying
		@Query(value = "insert into report(user_id,comment_id) values(:user_id,:comment_id) ", nativeQuery = true)
		public void saveCommentReport(@Param("comment_id")long comment_id, @Param("user_id")long user_id);



		 @Query(value = "SELECT * FROM report r join comment c on r.comment_id = c.id", nativeQuery = true)
		public List<Report> getReportedComments();
}
