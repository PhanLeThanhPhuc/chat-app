package com.chat.chat.service;

import com.chat.chat.entity.Users;
import com.chat.chat.request.UserCreatRequest;
import com.chat.chat.response.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> findAllUsers();
    UserResponse findAllUserById(String id);
    UserResponse createUser(UserCreatRequest userCreatRequest);
}
