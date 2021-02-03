package com.team6.internetPortal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.team6.internetPortal.entity.Report;
import com.team6.internetPortal.entity.Video;

public interface IReportsRepository extends JpaRepository<Report, Long> {

	 
     	 public Report findByCommentId(Long vid);



	    public Optional<Report> findById(Long id);


	    public Report findByUserId(Long uid);



	    @Query(value = "SELECT * FROM report r join video v on r.video_id = v.id", nativeQuery = true)
		public List<Report> findReportedVideos();
	    
		public Optional<Report> findByVideoId(Long id);
}
