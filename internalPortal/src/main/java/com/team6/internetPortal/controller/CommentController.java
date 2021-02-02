package com.team6.internetPortal.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.team6.internetPortal.entity.Comment;
import com.team6.internetPortal.service.ICommentService;

@RestController
public class CommentController
{
    @Autowired
    private ICommentService userCommentsService;

    //save
    @PostMapping("/comments")
    public Comment saveComment(@RequestBody Comment user_comments){

        user_comments.setCommentedOn(new Date(System.currentTimeMillis()));
        return userCommentsService.saveComment(user_comments);
    }

    //get by vid
    @GetMapping("/comments/{id}")
    public Optional<Comment> getComment(@PathVariable Long id)
    {
        System.out.println(id);
        return userCommentsService.getComment(id);
    }

    // get by Cmnt_id
    @GetMapping("/commentid/{id}")
    public Optional<Comment> findBycmnt_id(@PathVariable Long id)
    {
        System.out.println(id);
        return userCommentsService.findByCommentId(id);
    }

    // get by commentor id
    @GetMapping("/commentorid/{id}")
    public Comment findwithcommenterid(@PathVariable Long id)
    {
        System.out.println(id);
        return userCommentsService.findwithCommentrId(id);
    }




}
