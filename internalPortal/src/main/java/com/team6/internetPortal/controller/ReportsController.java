package com.team6.internetPortal.controller;


import java.net.MalformedURLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team6.internetPortal.entity.Report;
import com.team6.internetPortal.service.IReportService;

@RestController
@RequestMapping(value = "report")
public class ReportsController
{
    @Autowired
    IReportService reportsService;

    
    @DeleteMapping("/{id}")
	public void deleteVideo(@PathVariable long id)
	{
    	reportsService.deleteVideo(id);
		return ;
	}

    @GetMapping("/video")
	public List<Report> getReportedVideos() throws MalformedURLException {
		return reportsService.getReportedVideo();
	}
    
    @GetMapping("/getcomment")
	public List<Report> getReportedComments() throws MalformedURLException {
		return reportsService.getReportedComments();
	}

    @GetMapping("/{video_id}/{user_id}")
    public void saveReport(@PathVariable Long video_id,@PathVariable Long user_id){

        reportsService.saveReport(video_id,user_id);
    }
    
    @GetMapping("/comment/{comment_id}/{user_id}")
    public void saveCommentReport(@PathVariable long comment_id,@PathVariable long user_id){

        reportsService.saveCommentReport(comment_id,user_id);
    }

    @GetMapping("/reports/comment/{id}")
    public Report getByCommentId(@PathVariable Long id){

        return reportsService.getByCommentId(id);
    }

    @GetMapping("/reports/user/{id}")
    public Report getByUserId(@PathVariable Long id){

        return reportsService.getByUserId(id);
    }


    @GetMapping("/reports/video/{id}")
    public Optional<Report> getByVid(@PathVariable Long id){

        return reportsService.getByVid(id);
    }


}
