package com.team6.internetPortal.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.team6.internetPortal.entity.Like;
import com.team6.internetPortal.service.ILikeService;

public class LikeController {
	  @Autowired
	    private ILikeService userLikesService;


	    //save
	    @PostMapping("/likes")
	    public Like saveLike(@RequestBody Like user_likes){

	        //System.out.println(user_likes.getUid());
	        //System.out.println(user_likes.getLikedAt());
	        //System.out.println(user_likes.getVId());

	        user_likes.setLikedAt(new Date(System.currentTimeMillis()));
	        return userLikesService.saveLike(user_likes);
	    }
}
