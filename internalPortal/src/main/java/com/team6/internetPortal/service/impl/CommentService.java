package com.team6.internetPortal.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team6.internetPortal.entity.Comment;
import com.team6.internetPortal.repository.ICommentRepository;
import com.team6.internetPortal.service.ICommentService;

@Service
public class CommentService implements ICommentService {

	    @Autowired
	    private ICommentRepository userCommentsRepository;

	    //save
	    public Comment saveComment(Comment user_comments){
	    	user_comments.setCommentedOn(new Date(System.currentTimeMillis()));
	        return userCommentsRepository.save(user_comments);
	    }

	    //get by vid
	    public List<Comment> getComment(Long vid)
		{
	        return userCommentsRepository.findByVideoId(vid);
	    }

		@Override
		public Optional<Comment> findByCommentId(Long id) {
			return userCommentsRepository.findById(id);
		}

		@Override
		public Comment findwithCommentrId(Long id) {
			return userCommentsRepository.findByCommentorId(id);
		}

		@Override
		public void deleteComment(long id) {
		
			userCommentsRepository.deleteById(id);	
		}


}
