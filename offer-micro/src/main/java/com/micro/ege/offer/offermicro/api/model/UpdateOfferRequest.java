package com.micro.ege.offer.offermicro.api.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Schema(description = "Request that used in updating an Offer")
@Data
public class UpdateOfferRequest {
    @NotNull(message = "Offer ID is not null")
    @Schema(description = "Offer ID", example = "12345678910", required = true)
    private Long offerID;

    @NotNull(message = "Service Condition Text is not null")
    @Schema(description = "Service Condition Text", example = "Service conditions", required = true)
    private String freeText;

    @NotNull(message = "Service Offer Status is not null")
    @Schema(description = "Service Offer Status", example = "2", required = true)
    private Short serviceStatus;
}
