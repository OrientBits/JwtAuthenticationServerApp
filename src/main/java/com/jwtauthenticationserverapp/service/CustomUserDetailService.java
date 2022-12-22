package com.jwtauthenticationserverapp.service;

import com.jwtauthenticationserverapp.entities.CustomUserDetails;
import com.jwtauthenticationserverapp.repo.UserRepository;
import com.jwtauthenticationserverapp.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class CustomUserDetailService implements UserDetailsService {

    public User user;

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //user database

        user = userRepository.getUserByUsername(username);

        System.out.println("USER: " + user);

        if (user == null){
            throw new UsernameNotFoundException("User not found !!");
        }else
            return new CustomUserDetails(user);


//        if (username.equals("Orient")) {
//            System.out.println("UserMatched");
//            return new User("Orient", "Orient@Bits", new ArrayList<>());
//        } else {
//            throw new UsernameNotFoundException("User not found !!");
//        }


    }


}
