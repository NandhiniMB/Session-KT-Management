package com.team6.internetPortal.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team6.internetPortal.entity.Video;
import com.team6.internetPortal.repository.IVideoRepository;
import com.team6.internetPortal.service.IVideoService;

@Service
public class VideoService implements IVideoService{
	
	@Autowired
	private IVideoRepository videoRepository;
	public List<Video> getVideoByCategory(int id){
		//return videoRepository.findbyCategoryId(id);
		return videoRepository.findByCategoryId(id);
	}
	@Override
	public List<Video> getVideoByCreator(long id) {
		// TODO Auto-generated method stub
		return videoRepository.findByCreatorId(id);
	}
	@Override
	public List<Video> getVideoBySubscription(long id) {
		return videoRepository.findBySubscription(id);
	}
	@Override
	public Video updateVideo(Video video) 
	{
//	  Optional<Video> v = videoRepository.findById(video.getId());
//	  Video new_video = new Video();
//      new_video.setTitle(video.getTitle());
//      new_video.setDescription(video.getDescription());
//      new_video.setCreator(video.getCreator());
//      new_video.setCategory(video.getCategory());
//      new_video.setCreated_on(video.getCreated_on());
//      new_video.setIs_archived(video.isIs_archived());
//      new_video.setLast_modified_on(new Date(System.currentTimeMillis()));
      return videoRepository.save(video);
	}
	@Override
	public void deleteVideo(long id) {
		
		videoRepository.deleteById(id);
	}
	@Override
	public Optional<Video> getVideo(long id) {

		return videoRepository.findById(id);
	};
}
