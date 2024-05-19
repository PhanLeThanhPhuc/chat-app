package com.chat.chat.service.impl;

import com.chat.chat.entity.GroceryItem;
import com.chat.chat.entity.Users;
import com.chat.chat.exception.AppException;
import com.chat.chat.exception.ErrorCode;
import com.chat.chat.repository.UserRepository;
import com.chat.chat.request.UserCreatRequest;
import com.chat.chat.response.GroceryItemResponse;
import com.chat.chat.response.UserResponse;
import com.chat.chat.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserResponse> findAllUsers() {
        List<Users> users = userRepository.findAll();
        List<UserResponse> responses = new ArrayList<>();

        for (Users item : users) {
            UserResponse response = new UserResponse();
            response.setId(item.getId());
            response.setEmail(item.getEmail());
            response.setUsername(item.getUsername());
            response.setCreatedAt(item.getCreatedAt());
            responses.add(response);
        }

        return responses;
    }

    @Override
    public UserResponse findAllUserById(String id) {
        Users user = userRepository.findById(id).get();
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setEmail(user.getEmail());
        response.setUsername(user.getUsername());
        return response;
    }

    @Override
    public UserResponse createUser(UserCreatRequest userCreatRequest) {

        if(userRepository.existsByEmail(userCreatRequest.getEmail()))
            throw new AppException(ErrorCode.USER_EXISTED);

        System.out.println("sssss");
        Users users = new Users();
        users.setUsername(userCreatRequest.getUsername());
        users.setPassword(userCreatRequest.getPassword());
        users.setEmail(userCreatRequest.getEmail());
        users.setCreatedAt(new Date());

        users = userRepository.save(users);

        UserResponse response = new UserResponse();
        response.setId(users.getId());
        response.setUsername(users.getUsername());
        response.setEmail(users.getEmail());
        response.setCreatedAt(users.getCreatedAt());
        return response ;
    }
}
