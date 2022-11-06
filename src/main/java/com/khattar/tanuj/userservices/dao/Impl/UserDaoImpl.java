package com.khattar.tanuj.userservices.dao.Impl;

import com.khattar.tanuj.userservices.dao.UserDao;
import com.khattar.tanuj.userservices.models.LoginRequest;
import com.khattar.tanuj.userservices.models.LoginResponse;
import com.khattar.tanuj.userservices.models.SignupRequest;
import com.khattar.tanuj.userservices.models.User;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserDaoImpl implements UserDao {

    private Map<String, User> userDatabase;

    public UserDaoImpl() {
        userDatabase = new HashMap<>();
    }

    @Override
    public String registerUser(SignupRequest request) {
        String id = UUID.randomUUID().toString();
        User user = CreateUser(id, request);
        //    System.out.println(user);
        userDatabase.put(id, user);
        return id;
    }

    @Override
    public List<User> getAllUser() {
        return userDatabase.values().stream().toList();
    }

    @Override
    public User getUSerById(String id) {

        if (userDatabase.containsKey(id)) {
            return userDatabase.get(id);
        } else {
            User user = new User();
            user.setId(null);
            return user;
        }
    }


    private User CreateUser(String id, SignupRequest request) {
        User user = new User();
        user.setId(id);
        user.setName(request.getName());
        user.setPassword(request.getPassword());
        user.setAge(request.getAge());
        user.setEmail(request.getEmail());
        user.setCity(request.getCity());
        return user;
    }

    @Override
    public boolean isUserRegistered(LoginRequest request) {
       for(User value : userDatabase.values()) {
           if (value.getEmail().equalsIgnoreCase(request.getEmail())){
               return true;
           }
       }
       return false;
    }

    @Override
    public LoginResponse loginUser(LoginRequest request) {
        LoginResponse response = new LoginResponse();
        response.setReason("Something went wrong, please try again.");
        for(User value : userDatabase.values()){

            if (value.getEmail().equalsIgnoreCase(request.getEmail()) ){
                if(value.getPassword().equals(request.getPassword())){
                    response.setLoggedIn(true);
                    //response.setReason("Password matched");
                }else {
                    response.setReason("Password mismatched");
                }
                return response;
            }
        }
        return response;
    }


}




