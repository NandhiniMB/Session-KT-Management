package com.team6.internetPortal.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.json.JSONObject;
import org.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.team6.internetPortal.entity.Comment;
import com.team6.internetPortal.service.ICommentService;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
public class CommentController
{
    @Autowired
    private ICommentService userCommentsService;

    //save
    @PostMapping("/comments")
    @CrossOrigin(origins="http://localhost:4200")
    public Comment saveComment(@RequestBody Comment user_comments){
        user_comments.setCommentedOn(new Date(System.currentTimeMillis()));
        return userCommentsService.saveComment(user_comments);
    }

    //get by vid
    @GetMapping(value = "/comments/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Comment> getComment(@PathVariable Long id)
    {
        List<Comment> arrComments=userCommentsService.getComment(id);
        return arrComments;
    }

    // get by Cmnt_id
    @GetMapping("/commentid/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Optional<Comment> findBycmnt_id(@PathVariable Long id)
    {
        return userCommentsService.findByCommentId(id);
    }

    // get by commentor id
    @GetMapping("/commentorid/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Comment findwithcommenterid(@PathVariable Long id)
    {
        return userCommentsService.findwithCommentrId(id);
    }
    
    
    @DeleteMapping("/comment/{id}")
    public void deleteComment(@PathVariable long id) {
    	userCommentsService.deleteComment(id);
    }

}
