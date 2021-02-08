package com.team6.internetPortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team6.internetPortal.entity.Like;

public interface ILikeRepository extends JpaRepository<Like,Long>{

	Like save(Like like);
	
	List<Like> findAll();

}
