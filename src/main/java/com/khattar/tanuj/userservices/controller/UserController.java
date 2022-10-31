package com.khattar.tanuj.userservices.controller;

import com.khattar.tanuj.userservices.models.LoginRequest;
import com.khattar.tanuj.userservices.models.SignupRequest;
import com.khattar.tanuj.userservices.models.User;
import com.khattar.tanuj.userservices.models.response.BaseResponse;
import com.khattar.tanuj.userservices.models.response.SuccessResponse;
import com.khattar.tanuj.userservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String firstApi(){
        return "this is my first Api";
    }

    @PostMapping("/signup")
    public BaseResponse registerUser(@RequestBody SignupRequest request){
        String id = userService.registerUser(request);
        return new SuccessResponse("User registered with id :"+id);
    }

    @GetMapping("/getalluser")
    public BaseResponse getAllUser(){
        return new SuccessResponse(userService.getAllUser());
    }

    @GetMapping("/{id}")
    public BaseResponse getUserById(@PathVariable String id){
        return new SuccessResponse(userService.getUserById(id));
    }
    @GetMapping("/login")
    public BaseResponse login(@RequestBody LoginRequest request){
        return new SuccessResponse(userService.loginUser(request));
    }
}
