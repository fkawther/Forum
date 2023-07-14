package com.example.kaouther.controllers;

import com.example.kaouther.Dto.PostDto;
import com.example.kaouther.entity.Comments;
import com.example.kaouther.entity.Posts;
import com.example.kaouther.service.CommentService;
import com.example.kaouther.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "api/post") // valeur eli bch tasti bih //
public class PostControllers {
    @Autowired
    PostService service;
    @Autowired
    CommentService serviceComm;

    @GetMapping(value = "/getAllPost")
    public List<Posts> getAll(){
        return service.getAllPosts();
    }
    @GetMapping(value = "/getByID/{id}")
    public Posts get(@PathVariable int id){
        return service.getPostByID(id);
    }

    @GetMapping(value = "/getall/{id}")
    public List<Comments> getComByPostID(@PathVariable("id") int id){
        return serviceComm.GetAllCommentsByPostID(id);
    }
    @PostMapping(value = "/create")
    public Posts create(@RequestBody PostDto postDto){
        return service.Insert(postDto);
    }

}
