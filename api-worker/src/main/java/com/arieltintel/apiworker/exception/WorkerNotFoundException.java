package com.arieltintel.apiworker.exception;

public class WorkerNotFoundException extends RuntimeException {

    public WorkerNotFoundException(String message) {
        super(message);
    }

}
