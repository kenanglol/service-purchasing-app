package com.micro.ege.advert.advertservice.service;

import com.micro.ege.advert.advertservice.dto.AdvertDto;

public class Price implements ISpecification<AdvertDto>{

    private Integer price;

    public Price(Integer price) {
        this.price = price;
    }

    @Override
    public Boolean isAcceptable(AdvertDto advert) {
        return advert.getPrice()<price;
    }
}
