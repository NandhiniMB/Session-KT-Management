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
        System.out.println(user_comments.getComment());
        return userCommentsService.saveComment(user_comments);
    }

    //get by vid
    @GetMapping(value = "/comments/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Comment> getComment(@PathVariable Long id)
    {

//        Commmented because it was used in Testing
//        System.out.println(id);
//        System.out.println("got the id");
//        Comment obj=new Comment();
//        obj.setComment("great");
//        List<Comment> l1
//                = new ArrayList<Comment>();
//        l1.add(obj);
//        System.out.println(l1.get(0).getComment());
//        return l1;


        List<Comment> arrComments=userCommentsService.getComment(id);
        System.out.println(arrComments.size());
        System.out.println("got the id");


        return arrComments;
    }

    // get by Cmnt_id
    @GetMapping("/commentid/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Optional<Comment> findBycmnt_id(@PathVariable Long id)
    {
        System.out.println(id);
        return userCommentsService.findByCommentId(id);
    }

    // get by commentor id
    @GetMapping("/commentorid/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Comment findwithcommenterid(@PathVariable Long id)
    {
        System.out.println(id);
        return userCommentsService.findwithCommentrId(id);
    }
}
