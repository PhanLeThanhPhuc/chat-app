package com.chat.chat.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

//import java.util.Date;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Users {

    @Id
     String id;
     String username;
     String email;
     String password;

    @Field("created_at")
     Date createdAt;


}