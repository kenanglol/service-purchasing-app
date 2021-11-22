package com.micro.ege.offer.offermicro.service.model;

import lombok.Data;

@Data
public class UpdateOfferServiceInput {
    private String offerID;
    private String freeText;
    private Short serviceStatus;
}
