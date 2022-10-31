package com.khattar.tanuj.userservices.service.Impl;

import com.khattar.tanuj.userservices.dao.UserDao;
import com.khattar.tanuj.userservices.models.LoginRequest;
import com.khattar.tanuj.userservices.models.LoginResponse;
import com.khattar.tanuj.userservices.models.SignupRequest;
import com.khattar.tanuj.userservices.models.User;
import com.khattar.tanuj.userservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;


     @Override
        public String registerUser(SignupRequest request) {
            return userDao.registerUser(request);
     }

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public User getUserById(String id) {
        return userDao.getUSerById(id);
    }

    @Override
    public String loginUser(LoginRequest request) {
        if(userDao.isUserRegistered(request)){
           LoginResponse response = userDao.loginUser(request);
           if(response.isLoggedIn()){
               return "User logged in successfully";
           }else{
               return response.getReason();
           }
        }
        return "User not registered , please try again";
    }
}

