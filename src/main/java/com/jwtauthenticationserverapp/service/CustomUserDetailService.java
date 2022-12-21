package com.jwtauthenticationserverapp.service;


import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;


@Service
public class CustomUserDetailService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (username.equals("Orient")){
            System.out.println("UserMatched");
            return new User("Orient","Orient@Bits",new ArrayList<>());
        }else{
            throw new UsernameNotFoundException("User not found !!");
        }

    }


}
