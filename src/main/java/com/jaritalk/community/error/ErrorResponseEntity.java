package com.jaritalk.community.error;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Builder
public class ErrorResponseEntity {

    private int status;

    private List<String> messages;

    public static ErrorResponseEntity of(HttpStatus status, List<String> messages) {
        return ErrorResponseEntity.builder()
                .status(status.value())
                .messages(messages)
                .build();
    }

}
