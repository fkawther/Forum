package com.example.kaouther.repository;

import com.example.kaouther.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comments,Integer> {
    @Query("select c from Comments c where c.posts.id = ?1")
    public List<Comments> findAllByPostsId(int id);
}
