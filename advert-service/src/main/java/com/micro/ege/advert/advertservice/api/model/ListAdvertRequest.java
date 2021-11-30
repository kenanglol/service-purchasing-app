package com.micro.ege.advert.advertservice.api.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Schema(description = "Request that used in list an Advert")
public class ListAdvertRequest {

    @Schema(description = "Service Category", example = "Web site", required = true)
    private String category;

    @Schema(description = "Service Advert Price", example = "120")
    private Integer price;

    @Schema(description = "Service City", example = "Ankara")
    private String city;
}
