package com.micro.ege.user.usermicro.api.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class LoginUserResponse {
    @Schema(description = "isSuccess", example = "true")
    private Boolean isSuccess;
}
