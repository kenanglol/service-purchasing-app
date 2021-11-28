package com.micro.ege.advert.advertservice.service;

import com.micro.ege.advert.advertservice.dto.AdvertDto;

public class City implements ISpecification<AdvertDto>{

    private Integer city;

    public City(Integer city) {
        this.city = city;
    }

    @Override
    public Boolean isAcceptable(AdvertDto advert) {
        return advert.getCity().equals(city);
    }
}
