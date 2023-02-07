package com.jaritalk.community.error;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Builder
public class ErrorResponseDTO {

    private int status;

    private List<String> messages;

    public static ErrorResponseDTO of(HttpStatus status, List<String> messages) {
        return ErrorResponseDTO.builder()
                .status(status.value())
                .messages(messages)
                .build();
    }

}
