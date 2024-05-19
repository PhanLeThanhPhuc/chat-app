package com.chat.chat.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    USER_EXISTED(1001, "User da ton tai")

    ;
    private int code;
    private String message;
}
