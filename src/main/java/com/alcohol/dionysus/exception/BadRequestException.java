package com.alcohol.dionysus.exception;

public class BadRequestException extends AgoraRuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
