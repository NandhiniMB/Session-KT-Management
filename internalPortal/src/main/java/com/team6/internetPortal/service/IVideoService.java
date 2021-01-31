package com.team6.internetPortal.service;

import java.util.List;

import com.team6.internetPortal.entity.Video;

public interface IVideoService {

	public List<Video> getVideoByCategory(int id);

	public List<Video> getVideoByCreator(int id);

	public List<Video> getVideoBySubscription(int id);

}
