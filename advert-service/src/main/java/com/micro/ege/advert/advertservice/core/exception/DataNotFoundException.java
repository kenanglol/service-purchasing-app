package com.micro.ege.advert.advertservice.core.exception;

import org.springframework.http.HttpStatus;

public class DataNotFoundException extends CustomException {
    private HttpStatus status;

    public DataNotFoundException(ExceptionData exceptionData, HttpStatus status) {
        super(exceptionData);
        this.status = status;
    }

    public DataNotFoundException(ExceptionData exceptionData) {
        super(exceptionData);
        this.status = HttpStatus.NOT_FOUND;
    }
}
