package com.team6.internalPortal.RequestBody;

import com.team6.internetPortal.entity.Category;
import com.team6.internetPortal.entity.Video;

public class MailRequest {

	
	private Video video;
	private Category category;
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public MailRequest() {
		
	}
	
	
}
