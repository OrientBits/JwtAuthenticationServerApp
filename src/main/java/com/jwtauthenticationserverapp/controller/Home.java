package com.jwtauthenticationserverapp.controller;

import com.jwtauthenticationserverapp.entities.User;
import com.jwtauthenticationserverapp.model.JwtRequest;
import com.jwtauthenticationserverapp.repo.UserRepository;
import com.jwtauthenticationserverapp.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin (origins = "*")
public class Home {

    @Autowired
    CustomUserDetailService customUserDetailService;

    @GetMapping("/welcome")
    public String welcome(){
        return "Hello JWT token not allowed to unauthenticated users";
    }

    @GetMapping("/getusers")
    public User getUser(){
        System.out.println("Get User");


        return customUserDetailService.user;
    }

}
