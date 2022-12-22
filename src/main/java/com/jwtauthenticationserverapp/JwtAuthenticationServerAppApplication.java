package com.jwtauthenticationserverapp;

import com.jwtauthenticationserverapp.entities.User;
import com.jwtauthenticationserverapp.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
public class JwtAuthenticationServerAppApplication implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;
    Random random = new Random();
    int id;

    public static void main(String[] args) {
        SpringApplication.run(JwtAuthenticationServerAppApplication.class, args);
    }


    public void createUsers(){
        User user = new User();
        id = random.nextInt(100);

        user.setName("user"+id);
        user.setUsername("user"+id);
        user.setEmail("user"+id+"@gmail.com");
        user.setPassword("user"+id);
        user.setRole("Admin");
        user.setEnabled(true);

        User save = userRepository.save(user);
        System.out.println(save);
    }


    @Override
    public void run(String... args) throws Exception {
    //    createUsers();
    }
}
