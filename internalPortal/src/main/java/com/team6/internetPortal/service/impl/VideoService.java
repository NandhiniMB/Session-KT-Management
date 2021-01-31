package com.team6.internetPortal.service.impl;

import java.util.List;

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
		return videoRepository.findbyCategory_Id(id);
	}
	@Override
	public List<Video> getVideoByCreator(int id) {
		// TODO Auto-generated method stub
		return videoRepository.findbyCreator_Id(id);
	}
	@Override
	public List<Video> getVideoBySubscription(int id) {
		return videoRepository.findbySubscription(id);
	}
}
