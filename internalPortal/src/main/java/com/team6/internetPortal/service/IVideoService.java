package com.team6.internetPortal.service;

import java.util.List;
import java.util.Optional;

import com.team6.internetPortal.entity.Video;

public interface IVideoService {

	public List<Video> getVideoByCategory(int id);

	public List<Video> getVideoByCreator(long id);

	public List<Video> getVideoBySubscription(long id);

	public Video updateVideo(Video video);

	public void deleteVideo(long id);

	public Optional<Video> getVideo(long id);

}
