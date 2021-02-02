package com.team6.internetPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team6.internetPortal.entity.Like;
import com.team6.internetPortal.entity.Video;

public interface ILikeRepository extends JpaRepository<Like,Long>{

	Like save(Like like);

}
