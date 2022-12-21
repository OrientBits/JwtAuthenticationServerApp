package com.jwtauthenticationserverapp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin (origins = "*")
public class Home {

    @GetMapping("/welcome")
    public String welcome(){
        return "Hello JWT token not allowed to unauthenticated users";
    }

    @GetMapping("/getusers")
    public String getUser(){
        System.out.println("Get User");
        return "{\"name\":\"OrientBits\"}";
    }

}
