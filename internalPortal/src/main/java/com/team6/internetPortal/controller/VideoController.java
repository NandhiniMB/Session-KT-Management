package com.team6.internetPortal.controller;

import java.net.MalformedURLException;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import com.team6.internetPortal.constants.Constants.status;
import com.team6.internetPortal.dto.VideoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.*;
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

import com.team6.internetPortal.payload.UploadFileResponse;
import com.team6.internetPortal.entity.Video;
import com.team6.internetPortal.service.IVideoService;

import javax.swing.text.html.Option;

@RestController
@RequestMapping(value = "video")
public class VideoController {

	@Autowired
	private IVideoService videoService;
	
	
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
    	dbfile.setStatus(status.PENDING.toString());
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
