package com.micro.ege.offer.offermicro.core.exception;

import com.micro.ege.offer.offermicro.api.BaseResponse;
import lombok.Data;

@Data
public class CustomException extends Exception {
    Long errorCode;
    String errorMessage;

    public CustomException(ExceptionData exceptionData) {
        this.errorCode = exceptionData.errCode;
        this.errorMessage = exceptionData.errMessage;
    }

    public BaseResponse convertResponse() {
        BaseResponse response = new BaseResponse();
        response.setErrorMessage(this.errorMessage);
        response.setErrorCode(this.errorCode);
        return response;
    }
}
