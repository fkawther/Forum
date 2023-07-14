package com.example.kaouther.service;

import com.example.kaouther.Dto.CommentsDto;
import com.example.kaouther.entity.Comments;
import com.example.kaouther.repository.CommentRepository;
import com.example.kaouther.repository.PostRepository;
import com.example.kaouther.repository.UsersRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    UsersRespository usersRespository;

    public List<Comments> GetAllCommentsByPostID( int idPost){
        return commentRepository.findAllByPostsId(idPost);
    }
    public Comments addComment(CommentsDto commentsDto){
        Comments c= new Comments();
        c.setText(commentsDto.text);
        c.setUsers(usersRespository.findById(commentsDto.idUser).get());
        c.setPosts(postRepository.findById(commentsDto.idPost).get());
        return commentRepository.save(c);
    }
    public String delete(int id){
        commentRepository.deleteById(id);
        return "deleted";
    }


    public Comments update(CommentsDto commentsDto ,int id) {
        Comments comments=commentRepository.findById(id).get();
        comments.setPosts(postRepository.findById(commentsDto.idPost).get());
        comments.setUsers(usersRespository.findById(commentsDto.idUser).get());
        comments.setText(commentsDto.text);
       return commentRepository.save(comments);
    }

    public Comments getSingleComm(int id) {
        return commentRepository.findById(id).get();
    }
}
