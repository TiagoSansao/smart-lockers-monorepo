package com.smartlockers.residentsmanager.exception;

public class AlreadyExistentResidentInCondominiumException extends RuntimeException {
    public AlreadyExistentResidentInCondominiumException(String message) {
        super(message);
    }
}
