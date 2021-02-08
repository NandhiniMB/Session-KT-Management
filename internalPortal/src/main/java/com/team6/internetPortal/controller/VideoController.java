package com.team6.internetPortal.controller;

import java.net.MalformedURLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.team6.internetPortal.constants.Constants;
import com.team6.internetPortal.dto.VideoDTO;
import com.team6.internetPortal.entity.Video;
import com.team6.internetPortal.payload.UploadFileResponse;
import com.team6.internetPortal.service.IVideoService;

@RestController
@RequestMapping(value = "video")
public class VideoController {

	@Autowired
	private IVideoService videoService;
	
	Constants constants = new Constants();
	
	
	@GetMapping("/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public VideoDTO getVideo(@PathVariable long id) throws MalformedURLException {
		return videoService.getVideo(id);
	}

	
	@GetMapping("/getAll")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Video> getAll(){
		return videoService.findAll();
	}
	
	
	@GetMapping("/approved")
	public List<Video> getApprrovedVideos(){
		return videoService.getApprovedVideos();
	}

	@GetMapping("/pending")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Video> getPendingVideos(){
		return videoService.getPendingVideos();
	}
	
	@PostMapping("/{id}") 
	public Video updateVideo(@RequestBody Video video)
	{
		return videoService.updateVideo(video);
	}
	
	@DeleteMapping("/{id}")
	public void deleteVideo(@PathVariable long id)
	{
		videoService.deleteVideo(id);
		return ;
	}
	
	@GetMapping("/category/{category_id}") //find videos of given category
	public List<Video> getVideoByCategory(@PathVariable int category_id)
	{
		return videoService.getVideoByCategory(category_id);
	}
	
	@GetMapping("/user/{creator_id}") //find videos uploaded by user 
	public List<Video> getVideoByCreator(@PathVariable long creator_id)
	{
		return videoService.getVideoByCreator(creator_id);
	}
	
	@GetMapping("/subs/{subscriber_id}") //find videos of user subscribed categories
	public List<Video> getVideoBySubscription(@PathVariable int subscriber_id)
	{
		return videoService.getVideoBySubscription(subscriber_id);
	}
	
    @PostMapping("/saveVideoData")
    @CrossOrigin(origins="http://localhost:4200")
    public int UploadVideoData(@RequestBody Video dbfile) {
    	return videoService.savefile(dbfile);
    }
    
    @PostMapping("/uploadFile")
    @CrossOrigin(origins="http://localhost:4200")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
      Video dbFile = videoService.storeFile(file);
      return new UploadFileResponse(dbFile.getTitle(),dbFile.getDescription(),dbFile.getId());
  }
    
    @PutMapping("/updatestat")
    public Video UpdateStatus(@RequestBody Video video) {
    	
    	return videoService.updateStatus(video);
    }

    @PutMapping("/editDetails")
	@CrossOrigin(origins="http://localhost:4200")
	public Video EditDetails(@RequestBody Video video){
		return videoService.editDetails(video);
	}
    
    @PostMapping("/view")
    public long videoViewed(@RequestBody Video video) {
    	return videoService.videoViewed(video);
    }

    
    @GetMapping("/mostview")
    public List<Video> mostViewedVideo(){
    	
    	return videoService.mostViewedVideo();
    }
}
