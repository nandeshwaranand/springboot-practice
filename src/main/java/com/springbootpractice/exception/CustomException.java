package com.springbootpractice.exception;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

    private String description;

    public CustomException(String message) {
        this(message, null);
    }

    public CustomException(String message, String description) {
        this(message, description, null);
    }

    public CustomException(String message, String description, Throwable cause){
        super(message,cause);
        this.description = description;
    }
}
