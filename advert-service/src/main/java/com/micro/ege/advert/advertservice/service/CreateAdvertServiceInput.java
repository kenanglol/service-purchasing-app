package com.micro.ege.advert.advertservice.service;

import lombok.Data;

@Data
public class CreateAdvertServiceInput {
    private String serviceProviderID;
    private String advertName;
    private String summary;
    private Integer minPrice;
    private Integer advertCreateTime;
    private String category;
    private String city;
}
