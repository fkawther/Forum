package com.example.kaouther.service;

import com.example.kaouther.Dto.PostDto;
import com.example.kaouther.entity.Posts;
import com.example.kaouther.entity.Users;
import com.example.kaouther.repository.PostRepository;
import com.example.kaouther.repository.UsersRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    public PostRepository repo;
    @Autowired
    public UsersRespository usersRespository;

    public Posts Insert(PostDto postDto){
        Users u= usersRespository.findById(postDto.user_id).get();
        Posts post=new Posts();
        post.setText(postDto.text);
        post.setUsers(u);
        return repo.save(post);

    }
    public List<Posts> getAllPosts(){
        return repo.findAll();
    }
    public Posts getPostByID(int id){
        return repo.findById(id).get();
    }


}
