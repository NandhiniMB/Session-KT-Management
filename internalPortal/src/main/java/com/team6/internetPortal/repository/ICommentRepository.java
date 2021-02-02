package com.team6.internetPortal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team6.internetPortal.entity.Comment;

public interface ICommentRepository extends JpaRepository<Comment, Long>  {

	Comment findByCommentorId(Long id);

	Optional<Comment> findByVideoId(Long vid);

}
