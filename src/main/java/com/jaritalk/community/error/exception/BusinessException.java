package com.jaritalk.community.error.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private int status;

    public BusinessException(int status, String message) {
        super(message);
        this.status = status;
    }

    public BusinessException(ErrorCode code) {
        super(code.getMessage());
        this.status = code.getStatus();
    }

    public BusinessException(String message) {
        super(message);
    }

}
