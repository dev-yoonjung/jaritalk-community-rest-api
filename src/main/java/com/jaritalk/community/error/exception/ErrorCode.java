package com.jaritalk.community.error.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    // 인증
    INVALID_ACCOUNT_TYPE(400, "잘못된 회원 타입입니다."),
    NOT_EXISTS_AUTHENTICATION(401, "Authentication Header가 빈 값입니다.");

    private int status;

    private String message;

    ErrorCode(int status, String message) {
        this.status = status;
        this.message = message;
    }

}
