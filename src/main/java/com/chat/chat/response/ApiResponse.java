package com.chat.chat.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
@NoArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ApiResponse <T>{

    private int code = 1000;
    private String message;
    private T result;

}
