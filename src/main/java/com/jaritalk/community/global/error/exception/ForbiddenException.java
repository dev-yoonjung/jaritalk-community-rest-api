package com.jaritalk.community.global.error.exception;

public class ForbiddenException extends BusinessException {

    public ForbiddenException(ErrorCode code) {
        super(code);
    }

}
