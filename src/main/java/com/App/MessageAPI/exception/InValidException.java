package com.App.MessageAPI.exception;

import org.springframework.context.annotation.Configuration;

@Configuration
public class InValidException extends RuntimeException{
    public InValidException() {
        super();
    }

    public InValidException(String message) {
        super(message);
    }

    public InValidException(String message, Throwable cause) {
        super(message, cause);
    }
}
