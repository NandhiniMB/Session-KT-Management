package com.team6.internetPortal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team6.internetPortal.entity.Comment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ICommentRepository extends JpaRepository<Comment, Long>  {

	Comment findByCommentorId(Long id);

	List<Comment> findByVideoId(Long vid);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM comment where id = :cid", nativeQuery = true)
	public int deleteComment(@Param("cid") long cid);

}
