package com.micro.ege.offer.offermicro.api.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Schema(description = "Request that used in creating an Offer")
@Data
public class CreateOfferRequest {

    @NotNull(message = "Service Provider ID is not null")
    @Schema(description = "Service Provider ID", example = "12345678910", required = true)
    private String serviceProviderID;

    @NotNull(message = "Advert ID is not null")
    @Schema(description = "Advert ID", example = "12345678910", required = true)
    private String advertID;

    @NotNull(message = "Service Condition Text is not null")
    @Schema(description = "Service Condition Text", example = "Service conditions", required = true)
    private String freeText;

    @NotNull(message = "Service Offer Status is not null")
    @Schema(description = "Service Offer Status", example = "2", required = true)
    private Short serviceStatus;

    @NotNull(message = "Service Offer DateTime is not null")
    @Schema(description = "Service Offer DateTime", example = "198604110900", required = true)
    private Long session;

}
