package com.team6.internetPortal.service;

import java.util.List;
import java.util.Optional;

import com.team6.internetPortal.entity.Comment;

public interface ICommentService {


	Comment saveComment(Comment user_comments);

	List<Comment> getComment(Long id);

	Optional<Comment> findByCommentId(Long id);

	Comment findwithCommentrId(Long id);

}
