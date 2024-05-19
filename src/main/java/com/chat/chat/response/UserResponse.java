package com.chat.chat.response;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
public class UserResponse {

    private String id;
    private String username;
    private String email;
    private Date createdAt;
}
