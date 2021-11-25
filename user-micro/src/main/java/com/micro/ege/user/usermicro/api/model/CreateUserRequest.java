package com.micro.ege.user.usermicro.api.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Data
public class CreateUserRequest {
    @NotNull(message = "Is Provider is not null")
    @Schema(description = "Is Provider", example = "true", required = true)
    private Boolean isProvider;

    @NotNull(message = "Name is not null")
    @Schema(description = "Name", example = "Kenan", required = true)
    private String firstName;

    @NotNull(message = "Middle name is not null")
    @Schema(description = "Middle Name", example = "F.")
    private String middleName;

    @NotNull(message = "Surname is not null")
    @Schema(description = "Surname", example = "Gülol", required = true)
    private String surName;

    @NotNull(message = "Mail Address is not null")
    @Schema(description = "Mail Address", example = "abc@gmail.com", required = true)
    private String mail;

    @NotNull(message = "Password is not null")
    @Schema(description = "Password", example = "dfh54dh5d3", required = true)
    private String cipher;

    @NotNull(message = "Location is not null")
    @Schema(description = "Location", example = "Izmir/Turkey", required = true)
    private String location;

    @NotNull(message = "Experience is not null")
    @Schema(description = "Experience", example = "5")
    private Integer experience;

    @NotNull(message = "Expertise is not null")
    @Schema(description = "Expertise", example = "Private Math Tutor")
    private String expertise;

    @NotNull(message = "User Score is not null")
    @Schema(description = "User Score", example = "8.6", required = true)
    private Double userScore;
}
