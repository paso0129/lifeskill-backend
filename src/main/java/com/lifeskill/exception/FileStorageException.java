package com.lifeskill.exception;

import org.springframework.http.HttpStatus;

public class FileStorageException extends BusinessException {
    public FileStorageException(String message) {
        super(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
