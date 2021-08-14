package com.micro.ege.user.usermicro.service;

import lombok.Data;

@Data
public class UpdateUserServiceOutput {
    private Boolean isSucceeded;
    private Long errorCode;
    private String errorMessage;
}
