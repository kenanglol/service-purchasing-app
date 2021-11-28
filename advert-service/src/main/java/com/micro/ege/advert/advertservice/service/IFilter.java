package com.micro.ege.advert.advertservice.service;

public interface IFilter<AdvertDto> {
    Iterable<AdvertDto> filter(Iterable<AdvertDto> advertList, ISpecification specification);
}
