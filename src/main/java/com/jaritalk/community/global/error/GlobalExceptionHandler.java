package com.jaritalk.community.global.error;

import com.jaritalk.community.global.error.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * javax.validation.Valid 또는 @Valid binding error가 발생한 경우
     */
    @ExceptionHandler(BindException.class)
    protected ResponseEntity<ErrorResponseDTO> handleBindException(BindException exception) {
        log.error("handle bind exception: ", exception);

        List<String> messages = new ArrayList<>();

        BindingResult result = exception.getBindingResult();
        if (result.hasErrors()) {
            result.getFieldErrors()
                    .forEach(e -> messages.add(e.getDefaultMessage()));
        }

        ErrorResponseDTO body = ErrorResponseDTO.of(HttpStatus.BAD_REQUEST, messages);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(body);
    }

    /**
     * 주로 @RequestParam Enum으로 binding을 하지 못했을 경우 발생
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<ErrorResponseDTO> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException exception) {
        log.error("handle method argument type mismatch exception: ", exception);

        List<String> messages = Collections.singletonList(exception.getMessage());
        ErrorResponseDTO body = ErrorResponseDTO.of(HttpStatus.BAD_REQUEST, messages);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(body);
    }

    /**
     * 지원하지 않은 HTTP method 호출 할 경우 발생
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ResponseEntity<ErrorResponseDTO> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException exception) {
        log.error("handle http request method not supported exception: ", exception);

        List<String> messages = Collections.singletonList(exception.getMessage());
        ErrorResponseDTO body = ErrorResponseDTO.of(HttpStatus.METHOD_NOT_ALLOWED, messages);
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
                .body(body);
    }

    /**
     * 비즈니스 로직 실행 중 오류 발생
     */
    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ErrorResponseDTO> handleBusinessException(BusinessException exception) {
        log.error("handle business exception: ", exception);

        List<String> messages = Collections.singletonList(exception.getMessage());
        HttpStatus status = HttpStatus.valueOf(exception.getStatus());
        ErrorResponseDTO body = ErrorResponseDTO.of(status, messages);
        return ResponseEntity.status(status)
                .body(body);
    }

    /**
     * 나머지 예외 발생
     */
    @ExceptionHandler(Exception.class)
    protected  ResponseEntity<ErrorResponseDTO> handleException(Exception exception) {
        log.error("handle exception: ", exception);

        List<String> messages = Collections.singletonList(exception.getMessage());
        ErrorResponseDTO body = ErrorResponseDTO.of(HttpStatus.INTERNAL_SERVER_ERROR, messages);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(body);
    }
}
