package com.example.kaouther.controllers;

import com.example.kaouther.Dto.CommentsDto;
import com.example.kaouther.entity.Comments;
import com.example.kaouther.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "api/comments")
public class CommentControllers {
    @Autowired
    CommentService service;
        @GetMapping(value = "/wlc/{id}")
        public int li(@PathVariable("id") int id){
            return id;
        }
    @GetMapping(value = "/getall/{id}")
    public List<Comments> getComByPostID(@PathVariable("id") int id){
        return service.GetAllCommentsByPostID(id);
    }
    @PostMapping(value = "/addComment")
    public Comments add(@RequestBody CommentsDto commentsDto){
            return service.addComment(commentsDto);
    }
    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") int id){
            return service.delete(id);
    }
    @PutMapping(value = "/update/{id}")
    public Comments update(@RequestBody CommentsDto commentsDto,@PathVariable("id") int id){
        return service.update(commentsDto,id);
    }
     @GetMapping(value = "/getCommbyCommID/{id}")
    public Comments getSingleComme(@PathVariable("id") int id){
            return service.getSingleComm(id);
     }
}
