package com.chat.chat.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    USER_EXISTED(1001, "User da ton tai"),
    USER_NOT_EXITSTED(1005, "User not exitsted"),
    UNAUTHENTICATED(1006, "Unauthenticated")
    ;
    private int code;
    private String message;
}
