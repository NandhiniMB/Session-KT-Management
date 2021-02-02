package com.team6.internetPortal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team6.internetPortal.entity.Like;
import com.team6.internetPortal.repository.ILikeRepository;
import com.team6.internetPortal.service.ILikeService;

@Service
public class LikeService implements ILikeService {


    @Autowired
    private ILikeRepository userLikesRepository;

    //save
    public Like saveLike(Like like){
        return userLikesRepository.save(like);
    }
}
