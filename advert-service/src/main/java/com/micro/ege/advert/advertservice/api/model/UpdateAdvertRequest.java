package com.micro.ege.advert.advertservice.api.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Schema(description = "Request that used in updating an Advert")
@Data
public class UpdateAdvertRequest {
    @NotNull(message = "Advert ID is not null")
    @Schema(description = "Advert ID", example = "12345678910", required = true)
    private Long advertID;

    @NotNull(message = "Advert name is not null")
    @Schema(description = "Advert Name", example = "Hello World Project!", required = true)
    private String advertName;

    @NotNull(message = "Service Condition Summary is not null")
    @Schema(description = "Service Condition Summary", example = "Service summary", required = true)
    private String summary;

    @NotNull(message = "Service Advert Price is not null")
    @Schema(description = "Service Advert Price", example = "50", required = true)
    private Integer price;

    @NotNull(message = "Service City is not null")
    @Schema(description = "Service City", example = "Ankara", required = true)
    private String city;
}
