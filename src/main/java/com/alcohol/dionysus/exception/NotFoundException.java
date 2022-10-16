package com.alcohol.dionysus.exception;

public class NotFoundException extends AgoraRuntimeException {
    public NotFoundException(String message, String errorMsg) {
        super(message, errorMsg);
    }

    public NotFoundException(String message) {
        super(message);
    }
}
