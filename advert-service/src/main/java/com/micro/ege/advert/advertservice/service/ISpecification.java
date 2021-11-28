package com.micro.ege.advert.advertservice.service;

public interface ISpecification<AdvertDto> {

    Boolean isAcceptable(AdvertDto advert);
}
