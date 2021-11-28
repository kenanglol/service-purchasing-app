package com.micro.ege.advert.advertservice.core.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class BusinessException extends CustomException {
    private HttpStatus status;

    public BusinessException(ExceptionData exceptionData, HttpStatus status) {
        super(exceptionData);
        this.status = status;
    }

    public BusinessException(ExceptionData exceptionData) {
        super(exceptionData);
        this.status = HttpStatus.BAD_REQUEST;
    }
}
