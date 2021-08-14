package com.micro.ege.user.usermicro.core.exception;

public class ExceptionInfo {
    Long errCode;
    String errMessage;

    public ExceptionInfo(Long code, String msg) {
        this.errCode = code;
        this.errMessage = msg;
    }
}
