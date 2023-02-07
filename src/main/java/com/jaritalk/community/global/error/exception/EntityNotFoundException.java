package com.jaritalk.community.global.error.exception;

public class EntityNotFoundException extends BusinessException {

    public EntityNotFoundException(ErrorCode code) {
        super(code);
    }

}
