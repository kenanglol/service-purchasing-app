package com.micro.ege.advert.advertservice.service;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateAdvertServiceInput {
    private String serviceProviderID;
    private String advertName;
    private String summary;
    private Integer minPrice;
    private LocalDateTime advertCreateTime;
    private String category;
    private String city;
}
