package com.jwtauthenticationserverapp.controller;

import com.jwtauthenticationserverapp.service.CustomUserDetailService;
import com.jwtauthenticationserverapp.helper.JwtUtil;
import com.jwtauthenticationserverapp.model.JwtRequest;
import com.jwtauthenticationserverapp.model.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtController{

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {

        System.out.println(jwtRequest);

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(),jwtRequest.getPassword()));
            System.out.println("Hello Darling");
        }catch (UsernameNotFoundException | BadCredentialsException e) {
            e.printStackTrace();
            throw new Exception("Bad Credential");
        }


        UserDetails userDetails = this.customUserDetailService.loadUserByUsername(jwtRequest.getUsername());

        String token = this.jwtUtil.generateToken(userDetails);

        System.out.println("JWT: "+token);

        return ResponseEntity.ok(new JwtResponse(token));
    }

}
