package com.jwtauthenticationserverapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

    @GetMapping("/welcome")
    public String welcome(){
        return "Hello JWT token not allowed to unauthenticated users";
    }

}
