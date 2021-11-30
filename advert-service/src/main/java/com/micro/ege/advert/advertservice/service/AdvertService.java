package com.micro.ege.advert.advertservice.service;

import com.micro.ege.advert.advertservice.api.model.*;
import com.micro.ege.advert.advertservice.core.exception.BusinessException;
import com.micro.ege.advert.advertservice.core.exception.DataNotFoundException;
import com.micro.ege.advert.advertservice.dto.AdvertDto;

import java.util.List;

public interface AdvertService {
    ManipulationResponse createAdvert(CreateAdvertRequest createAdvertRequest) throws BusinessException, DataNotFoundException;

    ManipulationResponse updateAdvert(UpdateAdvertRequest updateAdvertRequest) throws DataNotFoundException, BusinessException;

    ManipulationResponse deleteAdvert(DeleteAdvertRequest deleteAdvertRequest) throws DataNotFoundException, BusinessException;

    List<AdvertDto> listAdvert(ListAdvertRequest listAdvertResponse) throws DataNotFoundException;

    AdvertDto getAdvert(Long advertId) throws DataNotFoundException;

    List<AdvertDto> getAdvertListOfProvider(Long providerId) throws DataNotFoundException;
}
