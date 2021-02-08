package com.team6.internetPortal.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team6.internetPortal.entity.Report;
import com.team6.internetPortal.repository.IReportsRepository;
import com.team6.internetPortal.service.IReportService;


@Service
@Transactional
public class ReportsService implements IReportService
{

    @Autowired
    private IReportsRepository reportsRepository;

    //save
    public void saveReport(long video_id,long user_id){
        reportsRepository.saveReport(video_id,user_id);
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
		List<Report> reports = reportsRepository.findReportedVideos();
		Set<Long> video_set = new HashSet<>();
		List<Report> unique_report  =reports.stream()
        .filter(r -> video_set.add(r.getVideo().getId()))
        .collect(Collectors.toList());
		return unique_report;
	}

	@Override
	public void deleteVideo(long id) {
		this.reportsRepository.deleteById(id);
		
	}

	@Override
	public void saveCommentReport(long comment_id, long user_id) {
		reportsRepository.saveCommentReport(comment_id,user_id);
		
	}

	@Override
	public List<Report> getReportedComments() {
		List<Report> reports =  reportsRepository.getReportedComments();
		Set<Long> comment_set = new HashSet<>();
		List<Report> unique_report  =reports.stream()
        .filter(r -> comment_set.add(r.getComment().getId()))
        .collect(Collectors.toList());
		return unique_report;
	
	}




}
