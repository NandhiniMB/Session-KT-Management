package com.team6.internetPortal.service.impl;

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
	        return userCommentsRepository.save(user_comments);
	    }

	    //get by vid
	    public Optional<Comment> getComment(Long vid){
	        return userCommentsRepository.findByVideoId(vid);
	    }

		@Override
		public Optional<Comment> findByCommentId(Long id) {
			return userCommentsRepository.findById(id);
		}

		@Override
		public Comment findwithCommentrId(Long id) {
			return userCommentsRepository.findByCommentorId(id);}


}
