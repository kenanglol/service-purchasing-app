package com.micro.ege.user.usermicro.api.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateUserRequest {

    @NotNull(message = "UserId is not null")
    @Schema(description = "UserId", example = "4541", required = true)
    private Long userId;

    @Schema(description = "Name", example = "Kenan")
    private String firstName;

    @Schema(description = "Middle Name", example = "F.")
    private String middleName;

    @Schema(description = "Surname", example = "Gülol")
    private String surName;

    @Schema(description = "Location", example = "Istanbul/Turkey")
    private String location;
}
