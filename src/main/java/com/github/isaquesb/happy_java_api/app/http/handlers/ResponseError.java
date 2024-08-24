package com.github.isaquesb.happy_java_api.app.http.handlers;

public class ResponseError {

    private String message;

    public ResponseError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
