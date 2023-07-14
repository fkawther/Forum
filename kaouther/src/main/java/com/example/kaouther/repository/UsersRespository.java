package com.example.kaouther.repository;

import com.example.kaouther.entity.Posts;
import com.example.kaouther.entity.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRespository extends JpaRepository<Users,Integer> {
    @Query("select u from Users u where u.email = ?1 and u.password = ?2")
    public Users findByEmailAndPassword(String email, String password);
    @Query("select u from Users u where u.email = ?1")
    public Users findByEmail(String email);

}
