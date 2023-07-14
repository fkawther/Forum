package com.example.kaouther.controllers;

import com.example.kaouther.Dto.Login;
import com.example.kaouther.entity.Users;
import com.example.kaouther.repository.UsersRespository;
import com.example.kaouther.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "api/users")
public class UserControllers {
    @Autowired
    UserService service;

    @PostMapping(value = "/login")
    public int login(@RequestBody Login request){
        return service.LoginInternaute(request.email ,request.password);
    }



}
