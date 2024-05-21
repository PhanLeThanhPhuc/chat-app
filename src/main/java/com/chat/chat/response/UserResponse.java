package com.chat.chat.response;
import com.chat.chat.entity.Users;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@NoArgsConstructor
public class UserResponse {

    private String id;
    private String username;
    private String email;
    private Date createdAt;

    public UserResponse(Users users){
        this.id = users.getId();
        this.username = users.getUsername();
        this.email = users.getEmail();
        this.createdAt = users.getCreatedAt();
    }
}
