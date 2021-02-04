package com.team6.internetPortal.service.impl;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.team6.internetPortal.constants.Constants;
import com.team6.internetPortal.dto.VideoDTO;
import com.team6.internetPortal.entity.Video;
import com.team6.internetPortal.exception.FileStorageException;
import com.team6.internetPortal.exception.MyFileNotFoundException;
import com.team6.internetPortal.repository.IVideoRepository;
import com.team6.internetPortal.service.IVideoService;


@Service
public class VideoService implements IVideoService{
	
	@Autowired
	private IVideoRepository videoRepository;

	@Autowired
	private DocumentServiceImpl documentService;

	Constants c= new Constants();
	@Override
	public List<Video> findAll() {
		return videoRepository.findApprovedVideos(c.status.APPROVED);
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
    	return videoRepository.update(dbfile.getId(),dbfile.getTitle(),dbfile.getDescription(),dbfile.getCreatedOn(),dbfile.getLastModifiedOn());
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
	public List<Video> getPendingVideos() {
		// TODO Auto-generated method stub
		return videoRepository.findPendingVideos(c.status.PENDING);
	}
}
