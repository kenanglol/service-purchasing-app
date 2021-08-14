package com.micro.ege.user.usermicro.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateUserRequest {

    @NotNull(message = "UserId is not null")
    @Schema(description = "UserId", example = "Kenan", required = true)
    private String userId;

    @Schema(description = "Name", example = "Kenan", required = true)
    private String name;

    @Schema(description = "Surname", example = "Gulol", required = true)
    private String surname;
}
