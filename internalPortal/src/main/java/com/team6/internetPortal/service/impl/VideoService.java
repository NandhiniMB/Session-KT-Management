package com.team6.internetPortal.service.impl;

import java.util.Base64;
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
//	  Optional<Video> v = videoRepository.findById(video.getId());
//	  Video new_video = new Video();
//      new_video.setTitle(video.getTitle());
//      new_video.setDescription(video.getDescription());
//      new_video.setCreator(video.getCreator());
//      new_video.setCategory(video.getCategory());
//      new_video.setCreated_on(video.getCreated_on());
//      new_video.setIs_archived(video.isIs_archived());
//      new_video.setLast_modified_on(new Date(System.currentTimeMillis()));
      return videoRepository.save(video);
	}
	@Override
	public void deleteVideo(long id) {
		
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

//	@Override
//	public Video getVideo(long id){
//		return videoRepository.findById(id).get();
//	}


	
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
    	System.out.println(dbfile);
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
		// TODO Auto-generated method stub
		return videoRepository.findApprovedVideos(c.status.APPROVED);
	}

	@Override
	public Video updateStatus(Video video) {
		// TODO Auto-generated method stub
		System.out.println(video);
		Video v = videoRepository.save(video);
		System.out.println(v);
		String[] user = new String[1];
		user[0]=video.getCreator().getEmail();
		if(v.getStatus()==c.status.APPROVED)
		{
			
			//user approved notification
			String content = "Greetings of the day!, \n\nYour New Video in the Category "+video.getCategory().getCategoryName() +" titled "+video.getTitle()+" is Approved!.\n\n Regards,\nInternal Portal Team";
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
			String content = "Greetings of the day!, \n\nYour New Video in the Category "+video.getCategory().getCategoryName() +" titled "+video.getTitle()+" is Rejected!.\n\n Regards,\nInternal Portal Team";
			notificationRepository.postNotifications(video.getCreator().getId(), content);
			sendmailService.sendEmail(user,content);
		}
	return v;
	}
}
