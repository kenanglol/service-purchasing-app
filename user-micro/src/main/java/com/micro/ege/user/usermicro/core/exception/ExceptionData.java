package com.micro.ege.user.usermicro.core.exception;

public class ExceptionData {
    Long errCode;
    String errMessage;

    public ExceptionData(Long code, String msg) {
        this.errCode = code;
        this.errMessage = msg;
    }
}
