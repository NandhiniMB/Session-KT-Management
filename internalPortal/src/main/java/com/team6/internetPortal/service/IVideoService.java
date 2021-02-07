package com.team6.internetPortal.service;

import java.util.List;
import java.util.Optional;

import com.team6.internetPortal.dto.VideoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;

import com.team6.internetPortal.entity.Video;

public interface IVideoService{

	public List<Video> findAll();

	public List<Video> getVideoByCategory(int id);

	public List<Video> getVideoByCreator(long id);

	public List<Video> getVideoBySubscription(long id);

	public Video updateVideo(Video video);

	public void deleteVideo(long id);

	public VideoDTO getVideo(long id);

//	public Video getVideo(long id);


	public int savefile(Video video);
	
	public Video storeFile(MultipartFile file);
	
	public Video getFile(long fileId);

	public List<Video> getReportedVideo();

	public List<Video> getApprovedVideos();

	public Video updateStatus(Video video);

	public Video editDetails(Video video);

	public long videoViewed(Video video);

	public List<Video> mostViewedVideo();

}
