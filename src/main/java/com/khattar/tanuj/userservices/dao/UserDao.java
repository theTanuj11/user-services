package com.khattar.tanuj.userservices.dao;

import com.khattar.tanuj.userservices.models.LoginRequest;
import com.khattar.tanuj.userservices.models.LoginResponse;
import com.khattar.tanuj.userservices.models.SignupRequest;
import com.khattar.tanuj.userservices.models.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
public interface UserDao {

    public String registerUser(@RequestBody SignupRequest request);

    public List<User> getAllUser();

    User getUSerById(String id);

    boolean isUserRegistered(LoginRequest request);


    LoginResponse loginUser(LoginRequest request);
}
