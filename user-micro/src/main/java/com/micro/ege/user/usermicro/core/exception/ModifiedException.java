package com.micro.ege.user.usermicro.core.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModifiedException extends Exception {
    Long errorCode;
    String errorMessage;
    public ModifiedException(ExceptionInfo exceptionInfo) {
        this.errorCode = exceptionInfo.errCode;
        this.errorMessage = exceptionInfo.errMessage;
    }
}
