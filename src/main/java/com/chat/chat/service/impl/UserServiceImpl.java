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
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Override
    public List<UserResponse> findAllUsers() {
        List<Users> users = userRepository.findAll();
//        List<UserResponse> responses = new ArrayList<>();
//
//        for (Users item : users) {
//            UserResponse response = new UserResponse();
//            response.setId(item.getId());
//            response.setEmail(item.getEmail());
//            response.setUsername(item.getUsername());
//            response.setCreatedAt(item.getCreatedAt());
//            responses.add(response);
//        }
//
//        return responses;
        return users.stream()
                .map(user -> new UserResponse(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse findAllUserById(String id) {
        return new UserResponse(userRepository.findById(id).get());
    }

    @Override
    public UserResponse createUser(UserCreatRequest userCreatRequest) {

        if(userRepository.existsByEmail(userCreatRequest.getEmail()))
            throw new AppException(ErrorCode.USER_EXISTED);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        Users users = Users.builder()
                .username(userCreatRequest.getUsername())
                .password(passwordEncoder.encode(userCreatRequest.getPassword()))
                .email(userCreatRequest.getEmail())
                .createdAt(new Date())
                .build();
        return new UserResponse(userRepository.save(users));
    }
}
