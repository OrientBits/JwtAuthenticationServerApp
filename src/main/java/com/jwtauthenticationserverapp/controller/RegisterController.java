package com.jwtauthenticationserverapp.controller;

import com.jwtauthenticationserverapp.entities.User;
import com.jwtauthenticationserverapp.entities.UserResponse;
import com.jwtauthenticationserverapp.model.JwtResponse;
import com.jwtauthenticationserverapp.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class RegisterController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/registerUser")
    public ResponseEntity<?> registerUser(@RequestBody User user) {

        System.out.println("REGISTER USER FROM UI: " + user);
        userRepository.save(user);
        return ResponseEntity.ok(new UserResponse("Success"));
    }

}
