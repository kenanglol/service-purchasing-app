package com.micro.ege.user.usermicro.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class GetUserRequest {

    @Schema(description = "UserId", example = "U2837459827492")
    private String userId;

    @Schema(description = "Mail", example = "abc@gmail.com")
    private String mail;
}
