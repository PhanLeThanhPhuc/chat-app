package com.chat.chat.controller;

import com.chat.chat.request.UserCreatRequest;
import com.chat.chat.response.ApiResponse;
import com.chat.chat.response.UserResponse;
import com.chat.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("users")
    public List<UserResponse> findAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("user/{id}"  )
    public UserResponse findAllUsers(@PathVariable String id  ){
        return userService.findAllUserById(id);
    }

    @PostMapping("users")
    public ApiResponse<UserResponse> createUser(@RequestBody UserCreatRequest userCreatRequest){
        ApiResponse<UserResponse> response = new ApiResponse<>();
        response.setResult(userService.createUser(userCreatRequest));
        return response;
    }
}
