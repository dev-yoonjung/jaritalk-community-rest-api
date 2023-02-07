package com.jaritalk.community.error.exception;

public class ForbiddenException extends BusinessException {

    public ForbiddenException(ErrorCode code) {
        super(code);
    }

}
