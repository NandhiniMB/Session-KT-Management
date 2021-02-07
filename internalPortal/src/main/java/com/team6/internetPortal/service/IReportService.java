package com.team6.internetPortal.service;

import java.util.List;
import java.util.Optional;

import com.team6.internetPortal.entity.Report;
import com.team6.internetPortal.entity.Video;

public interface IReportService {

	 public void saveReport(long video_id,long user_id);

	    //get by report id
	    public Optional<Report> getReport(Long id);

	    //get by cmnt id
	    public Report getByCommentId(Long id);

	    //get by user id
	    public Report getByUserId(Long id);
	    //get by vid id
	    public Optional<Report> getByVid(Long id);
	    
	    public List<Report> getReportedVideo();

		public void deleteVideo(long id);

		public void saveCommentReport(long comment_id, long user_id);

		public List<Report> getReportedComments();
}
