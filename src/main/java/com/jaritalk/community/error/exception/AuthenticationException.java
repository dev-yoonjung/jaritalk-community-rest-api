package com.jaritalk.community.error.exception;

public class AuthenticationException extends BusinessException {

    public AuthenticationException(ErrorCode code) {
        super(code);
    }

}
