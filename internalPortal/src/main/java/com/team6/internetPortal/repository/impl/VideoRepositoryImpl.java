package com.team6.internetPortal.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.team6.internetPortal.entity.User;
import com.team6.internetPortal.entity.Video;
import com.team6.internetPortal.repository.IVideoRepository;

@Repository
@Transactional
public abstract class VideoRepositoryImpl implements IVideoRepository {
	
	
}
