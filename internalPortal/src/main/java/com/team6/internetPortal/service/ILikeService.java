package com.team6.internetPortal.service;

import com.team6.internetPortal.entity.Like;

import java.util.List;

public interface ILikeService {
	 public Like saveLike(Like like);

	 public List<Like> getAllLikes();

	 public void deleteLike(long id);
}
