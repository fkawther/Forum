package com.example.kaouther.service;

import com.example.kaouther.entity.Users;
import com.example.kaouther.repository.UsersRespository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UsersRespository usersRespository;

    public List<Users> getAll(){
        return usersRespository.findAll();
    }
    public Users save(Users users){
        return usersRespository.save(users);
    }

    public int LoginInternaute(String email, String password){
        Users user = usersRespository.findByEmailAndPassword(email,password);
        if (user != null){
            return user.getId();
        } else return 0;
    }
    public int LoginInternaute1(String email){
        Users user = usersRespository.findByEmail(email);
        if (user != null){
            return user.getId();
        } else return 0;
    }


}