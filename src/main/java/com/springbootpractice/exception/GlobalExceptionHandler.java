package com.springbootpractice.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

/**
 * Spring Boot provides a flexible way to handle exceptions globally.
 * You can create custom exceptions and handle them gracefully using @ControllerAdvice and @ExceptionHandler.
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException userNotFoundException, HttpServletRequest httpServletRequest){
        APIError apiError = buildAPIError(userNotFoundException, httpServletRequest);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }

    private APIError buildAPIError(CustomException customException, HttpServletRequest httpServletRequest) {
        return APIError.builder()
                .timestamp(LocalDateTime.now())
                .message(customException.getMessage())
                .description(ObjectUtils.isEmpty(customException.getCause()) ? customException.getDescription()
                        : customException.getCause().getMessage())
                .path(httpServletRequest.getRequestURI())
                .build();
    }
}
