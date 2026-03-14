package com.lifeskill.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends BusinessException {
    public ResourceNotFoundException(String resource, Long id) {
        super(resource + "을(를) 찾을 수 없습니다. (ID: " + id + ")", HttpStatus.NOT_FOUND);
    }

    public ResourceNotFoundException(String resource, String identifier) {
        super(resource + "을(를) 찾을 수 없습니다. (" + identifier + ")", HttpStatus.NOT_FOUND);
    }
}
