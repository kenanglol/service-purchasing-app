package com.micro.ege.user.usermicro.api.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LoginUserRequest {
    @NotNull
    @Schema(description = "Mail", example = "abc@gmail.com")
    private String mail;

    @NotNull
    @Schema(description = "Password", example = "sfdg547fdgsd")
    private String password;
}
