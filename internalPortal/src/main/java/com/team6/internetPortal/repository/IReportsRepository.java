package com.team6.internetPortal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team6.internetPortal.entity.Report;

public interface IReportsRepository extends JpaRepository<Report, Long> {

	 
     	 public Report findByCommentId(Long vid);



	    public Optional<Report> findById(Long id);


	    public Report findByUserId(Long uid);



		public Optional<Report> findByVideoId(Long id);
}
