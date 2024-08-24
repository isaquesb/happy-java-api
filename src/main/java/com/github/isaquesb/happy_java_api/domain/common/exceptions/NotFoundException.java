package com.github.isaquesb.happy_java_api.domain.common.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("User not found");
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
