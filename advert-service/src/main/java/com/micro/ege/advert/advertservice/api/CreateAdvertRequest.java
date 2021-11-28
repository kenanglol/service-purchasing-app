package com.micro.ege.advert.advertservice.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Schema(description = "Request that used in creating an Advert")
public class CreateAdvertRequest {
    @NotNull(message = "Service Provider ID is not null")
    @Schema(description = "Service Provider ID", example = "12345678910", required = true)
    private Long serviceProviderID;

    @NotNull(message = "Advert Name is not null")
    @Schema(description = "Advert Name", example = "Matematik Dersi", required = true)
    private String advertName;

    @NotNull(message = "Service Condition Text is not null")
    @Schema(description = "Service Condition Text", example = "Service summary", required = true)
    private String summary;

    @NotNull(message = "Service Advert Price is not null")
    @Schema(description = "Service Advert Price", example = "50", required = true)
    private Integer price;

    @NotNull(message = "Service Category is not null")
    @Schema(description = "Service Category", example = "Web site", required = true)
    private String category;
}
