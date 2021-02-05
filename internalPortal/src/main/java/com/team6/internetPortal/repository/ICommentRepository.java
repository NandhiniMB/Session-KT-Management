package com.team6.internetPortal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team6.internetPortal.entity.Comment;
import org.springframework.data.jpa.repository.Query;

public interface ICommentRepository extends JpaRepository<Comment, Long>  {

	Comment findByCommentorId(Long id);

	List<Comment> findByVideoId(Long vid);

}
