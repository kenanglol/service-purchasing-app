package com.micro.ege.offer.offermicro.service.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateOfferServiceInput {
    private String serviceProviderID;
    private String advertID;
    private String freeText;
    private Short serviceStatus;
    private LocalDateTime session;
}
