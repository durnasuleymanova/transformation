package com.transformation.model;

import lombok.Getter;

@Getter
public class ValidationException extends RuntimeException {
    public ValidationException() {
        super();
    }
}
