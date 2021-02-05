package com.team6.internetPortal.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.team6.internetPortal.entity.Like;
import com.team6.internetPortal.service.ILikeService;

@RestController
public class LikeController {
	  @Autowired
	    private ILikeService userLikesService;


	    //save
	    @PostMapping("/likes")
		@CrossOrigin(origins = "http://localhost:4200")
	    public Like saveLike(@RequestBody Like user_likes){

	        //System.out.println(user_likes.getUid());
	        //System.out.println(user_likes.getLikedAt());
	        //System.out.println(user_likes.getVId());

	        user_likes.setLikedAt(new Date(System.currentTimeMillis()));
	        return userLikesService.saveLike(user_likes);
	    }

		@GetMapping("/getLikes")
		@CrossOrigin(origins = "http://localhost:4200")
		public List<Like> getLikes(){
			return userLikesService.getAllLikes();
		}

		@DeleteMapping("/deleteLike/{id}")
		@CrossOrigin(origins = "http://localhost:4200")
		public void deleteLike(@PathVariable long id){
			userLikesService.deleteLike(id);
		}
}
