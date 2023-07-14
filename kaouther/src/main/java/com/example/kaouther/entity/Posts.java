package com.example.kaouther.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String text;
        @ManyToOne
        private Users users;
    @OneToMany
    @JsonIgnore
    private List<Comments> CommentList;
    public Integer getId() {
        return id;
    }

    public Posts() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public List<Comments> getCommentList() {
        return CommentList;
    }

    public void setCommentList(List<Comments> commentList) {
        CommentList = commentList;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
