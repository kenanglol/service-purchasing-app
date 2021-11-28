package com.micro.ege.advert.advertservice.service;

import com.micro.ege.advert.advertservice.api.model.*;
import com.micro.ege.advert.advertservice.core.exception.BusinessException;

public interface AdvertService {
    ManipulationResponse createAdvert(CreateAdvertRequest createAdvertRequest) throws BusinessException;

    ManipulationResponse updateAdvert(UpdateAdvertRequest updateAdvertRequest);

    ManipulationResponse deleteAdvert(DeleteAdvertRequest deleteAdvertRequest);

    ListAdvertResponse listAdvert(ListAdvertRequest listAdvertResponse);

    Object getAdvert(Long advertId);
}
