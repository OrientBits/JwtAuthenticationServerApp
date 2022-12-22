package com.jwtauthenticationserverapp.repo;

import com.jwtauthenticationserverapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User getUserByUsername(String username);
}
