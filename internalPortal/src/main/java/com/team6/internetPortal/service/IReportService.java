package com.team6.internetPortal.service;

import java.util.Optional;

import com.team6.internetPortal.entity.Report;

public interface IReportService {

	 public Report saveReport(Report report);

	    //get by report id
	    public Optional<Report> getReport(Long id);

	    //get by cmnt id
	    public Report getByCommentId(Long id);

	    //get by user id
	    public Report getByUserId(Long id);
	    //get by vid id
	    public Optional<Report> getByVid(Long id);
}
