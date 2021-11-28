package com.micro.ege.advert.advertservice.service;

import com.micro.ege.advert.advertservice.api.model.*;
import com.micro.ege.advert.advertservice.core.exception.BusinessException;
import com.micro.ege.advert.advertservice.core.exception.DataNotFoundException;

public interface AdvertService {
    ManipulationResponse createAdvert(CreateAdvertRequest createAdvertRequest) throws BusinessException, DataNotFoundException;

    ManipulationResponse updateAdvert(UpdateAdvertRequest updateAdvertRequest) throws DataNotFoundException, BusinessException;

    ManipulationResponse deleteAdvert(DeleteAdvertRequest deleteAdvertRequest);

    ListAdvertResponse listAdvert(ListAdvertRequest listAdvertResponse);

    Object getAdvert(Long advertId);
}
