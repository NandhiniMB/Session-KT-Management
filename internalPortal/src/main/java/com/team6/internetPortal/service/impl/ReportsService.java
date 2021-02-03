package com.team6.internetPortal.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team6.internetPortal.entity.Report;
import com.team6.internetPortal.entity.Video;
import com.team6.internetPortal.repository.IReportsRepository;
import com.team6.internetPortal.service.IReportService;


@Service
public class ReportsService implements IReportService
{

    @Autowired
    private IReportsRepository reportsRepository;

    //save
    public Report saveReport(Report report){
        return reportsRepository.save(report);
    }

    //get by report id
    public Optional<Report> getReport(Long id){
        return reportsRepository.findById(id);
    }

    //get by cmnt id
    public Report getByCommentId(Long id){
        return reportsRepository.findByCommentId(id);
    }

    //get by user id
    public Report getByUserId(Long id){
        return reportsRepository.findByUserId(id);
    }

    //get by vid id
    public Optional<Report> getByVid(Long id){
        return reportsRepository.findByVideoId(id);
    }

    @Override
	public List<Report> getReportedVideo() {
		
		return reportsRepository.findReportedVideos();
	}

	@Override
	public void deleteVideo(long id) {
		this.reportsRepository.deleteById(id);
		
	}




}
