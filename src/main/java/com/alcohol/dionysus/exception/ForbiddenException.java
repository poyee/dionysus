package com.alcohol.dionysus.exception;

public class ForbiddenException extends AgoraRuntimeException {
    public ForbiddenException(String message, String errorMsg) {
        super(message, errorMsg);
    }

    public ForbiddenException(String message) {
        super(message);
    }
}
