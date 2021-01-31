package com.team6.internetPortal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team6.internetPortal.entity.Video;
import com.team6.internetPortal.service.IVideoService;

@RestController
@RequestMapping("video")
public class VideoController {

	@Autowired
	private IVideoService videoService;
	
	@GetMapping("/category/{category_id}")
	public List<Video> getVideoByCategory(@PathVariable int category_id)
	{
		return videoService.getVideoByCategory(category_id);
	}
	
	@GetMapping("/user/{creator_id}")
	public List<Video> getVideoByCreator(@PathVariable int creator_id)
	{
		return videoService.getVideoByCreator(creator_id);
	}
	
	@GetMapping("/subs/{subscriber_id}")
	public List<Video> getVideoBySubscription(@PathVariable int subscriber_id)
	{
		return videoService.getVideoBySubscription(subscriber_id);
	}
}
