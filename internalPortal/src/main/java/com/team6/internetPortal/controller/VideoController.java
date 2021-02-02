package com.team6.internetPortal.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.team6.internalPortal.payload.UploadFileResponse;
import com.team6.internetPortal.entity.Video;
import com.team6.internetPortal.service.IVideoService;

@RestController
@RequestMapping("video")
public class VideoController {

	@Autowired
	private IVideoService videoService;
	
	
	@GetMapping("/{id}") 
	public Optional<Video> getVideo(@PathVariable long id)
	{
		return videoService.getVideo(id);
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
    	dbfile.setCreatedOn(new Date(System.currentTimeMillis()));
    	dbfile.setLastModifiedOn(new Date(System.currentTimeMillis()));
    	System.out.println(dbfile);
    	int rows=videoService.savefile(dbfile);
    	return rows;
    }
    
    @PostMapping("/uploadFile")
    @CrossOrigin(origins="http://localhost:4200")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
      Video dbFile = videoService.storeFile(file);
      System.out.println("========================="+file.getSize()+"=======================");
//      String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//              .path("/downloadFile/")
//              .path(""+dbFile.getId())
//              .toUriString();        
//      return new UploadFileResponse(dbFile.getFileName(), fileDownloadUri,
//              file.getContentType(), file.getSize());        
      return new UploadFileResponse(dbFile.getTitle(),dbFile.getDescription(),dbFile.getId());
//      return dbFile.getTitle()+" "+dbFile.getDescription();
  }
}
