package com.khattar.tanuj.userservices.service;

import com.khattar.tanuj.userservices.models.LoginRequest;
import com.khattar.tanuj.userservices.models.SignupRequest;
import com.khattar.tanuj.userservices.models.User;
import com.khattar.tanuj.userservices.models.response.BaseResponse;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserService {

    public String registerUser(@RequestBody SignupRequest request);

    public List<User> getAllUser();

    public User getUserById(String id);

    String loginUser(LoginRequest request);
}
