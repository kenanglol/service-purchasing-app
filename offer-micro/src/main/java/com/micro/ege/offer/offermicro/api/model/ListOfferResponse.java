package com.micro.ege.offer.offermicro.api.model;

import com.micro.ege.offer.offermicro.dto.OfferDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "Response that used in list an Offer")

@Data
public class ListOfferResponse extends BaseResponse {

    @Schema(description = "Offer Details List", required = true)
    private List<OfferDto> offerDetailsList;
}
