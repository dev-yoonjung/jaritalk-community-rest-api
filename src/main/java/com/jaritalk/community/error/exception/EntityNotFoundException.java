package com.jaritalk.community.error.exception;

public class EntityNotFoundException extends BusinessException {

    public EntityNotFoundException(ErrorCode code) {
        super(code);
    }

}
