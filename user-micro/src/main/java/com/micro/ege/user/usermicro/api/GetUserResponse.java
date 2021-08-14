package com.micro.ege.user.usermicro.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class GetUserResponse {

    @Schema(description = "UserId", example = "Kenan")
    private String userId;

    @Schema(description = "Name", example = "Kenan")
    private String name;

    @Schema(description = "Surname", example = "Gulol")
    private String surname;

    @Schema(description = "Mail", example = "abc@gmial.com")
    private String mail;

}
