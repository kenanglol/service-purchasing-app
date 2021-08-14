package com.micro.ege.user.usermicro.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CreateUserResponse {
    @Schema(description = "Is Succeeded", example = "true")
    private Boolean isSucceeded;

    @Schema(description = "Error Code", example = "11545L")
    private Long errorCode;

    @Schema(description = "Error Message", example = "This time range can not select")
    private String errorMessage;
}
