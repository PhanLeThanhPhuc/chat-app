package com.chat.chat.request;

import lombok.Data;

import java.util.Date;

@Data
public class UserCreatRequest {
    private String username;
    private String email;
    private String password;
}
