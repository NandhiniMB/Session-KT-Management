package com.team6.internetPortal.service.impl;

import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.team6.internetPortal.constants.Constants;
import com.team6.internetPortal.dto.VideoDTO;
import com.team6.internetPortal.entity.Video;
import com.team6.internetPortal.exception.FileStorageException;
import com.team6.internetPortal.exception.MyFileNotFoundException;
import com.team6.internetPortal.repository.INotificationRepository;
import com.team6.internetPortal.repository.ISubscriptionRepository;
import com.team6.internetPortal.repository.IVideoRepository;
import com.team6.internetPortal.service.IVideoService;

@Transactional
@Service
public class VideoService implements IVideoService{
	
	@Autowired
	private IVideoRepository videoRepository;

	@Autowired
	private DocumentServiceImpl documentService;
	
	@Autowired
	private INotificationRepository notificationRepository;
	
	@Autowired
	private ISubscriptionRepository subscriptionRepository;

	@Autowired
	private SendMailService  sendmailService;
	
	Constants c= new Constants();
	@Override
	public List<Video> findAll() {
		return videoRepository.findAll();
	}

	public List<Video> getVideoByCategory(int id){
		//return videoRepository.findbyCategoryId(id);
		return videoRepository.findByCategoryId(id);
	}
	@Override
	public List<Video> getVideoByCreator(long id) {
		// TODO Auto-generated method stub
		return videoRepository.findByCreatorId(id);
	}
	@Override
	public List<Video> getVideoBySubscription(long id) {
		return videoRepository.findBySubscription(id);
	}
	@Override
	public Video updateVideo(Video video) 
	{
      return videoRepository.save(video);
	}
	@Override
	public void deleteVideo(long id) {
		videoRepository.deleteForeignLikes(id);
		//Add for delete commentReports
		videoRepository.deleteForeignCommentReports(id);
		videoRepository.deleteForeignComments(id);
		videoRepository.deleteForeignReports(id);
		videoRepository.deleteById(id);
	}

	@Override
	public VideoDTO getVideo(long id) {

		Optional<Video> optional = videoRepository.findById(id);
		if(optional.isPresent()){
			Video video = optional.get();
			byte[] bytes = documentService.retrieveFile(video.getPath());
			String data = Base64.getEncoder().encodeToString(bytes);
			return new VideoDTO(video, data);
		}
		return null;
	}


	
	public Video storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            String path = documentService.saveFile(file, file.getOriginalFilename());
            Video dbfile = new Video();
            dbfile.setPath(path);
			System.out.println(path);
            return videoRepository.save(dbfile);
        } catch (Exception ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
}
    
    public int savefile(Video dbfile) {
    	dbfile.setCreatedOn(new Date(System.currentTimeMillis()));
    	dbfile.setLastModifiedOn(new Date(System.currentTimeMillis()));
    	dbfile.setStatus(c.status.PENDING);
    	dbfile.setCreator(dbfile.getCreator());
    	dbfile.setViews(0);
    	return videoRepository.update(dbfile.getId(),dbfile.getTitle(),dbfile.getDescription(),dbfile.getCreator(),dbfile.getCreatedOn(),dbfile.getLastModifiedOn(),dbfile.getCategory(),dbfile.getStatus());
    }

    public Video getFile(long fileId) {
        return videoRepository.findById(fileId)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
    }

	@Override
	public List<Video> getReportedVideo() {
		
		return videoRepository.findReportedVideos();
	}

	@Override
	public List<Video> getApprovedVideos() {
		return videoRepository.findApprovedVideos(c.status.APPROVED);
	}

	@Override
	public List<Video> getPendingVideos() {
		// TODO Auto-generated method stub
		return videoRepository.findPendingVideos(c.status.PENDING);
	}

	@Override
	public Video updateStatus(Video video) {
		System.out.println(video);
		Video v = videoRepository.save(video);
		System.out.println(v);
		String[] user = new String[1];
		user[0]=video.getCreator().getEmail();
		if(v.getStatus()==c.status.APPROVED)
		{
			
			//user approved notification
			String content = "Your New Video in the Category "+video.getCategory().getCategoryName() +" titled "+video.getTitle()+" is Approved!.";
			sendmailService.sendEmail(user,content);
			notificationRepository.postNotifications(video.getCreator().getId(), content);
			
			//subscribers notification
			int[] subscribed_users_id = subscriptionRepository.findAllUserByCategory(v.getCategory().getId());
			System.out.println("suser"+subscribed_users_id);
			String description = "New Video "+v.getTitle()+" Published";
	    	for(int i=0;i<subscribed_users_id.length;i++)
			       {
				
				     System.out.println(subscribed_users_id[i]);
				     notificationRepository.postNotifications(subscribed_users_id[i],description);
			    
          		}
		
	}
		if(v.getStatus()==c.status.REJECTED) {
			//user video rejected notification
			String content = "Your New Video in the Category "+video.getCategory().getCategoryName() +" titled "+video.getTitle()+" is Rejected!.";
			notificationRepository.postNotifications(video.getCreator().getId(), content);
			sendmailService.sendEmail(user,content);
		}
	return v;
	}

	@Override
	public Video editDetails(Video video) {
		System.out.println(video);
		video.setLastModifiedOn(new Date(System.currentTimeMillis()));
		Video v = videoRepository.save(video);
		return v;
	}

	@Override
	public long videoViewed(Video video) {
		// TODO Auto-generated method stub
		long count = videoRepository.getViewCount(video.getId());
		System.out.println("init"+count);
		count++;
		video.setViews(count);	
		Video v=videoRepository.save(video);
		System.out.println(v.getViews());
		return v.getViews();
	}

	@Override
	public List<Video> mostViewedVideo() {
		// TODO Auto-generated method stub
		List<Video> most_viewed_video = videoRepository.findAll();
		return most_viewed_video;
		
	}
}
