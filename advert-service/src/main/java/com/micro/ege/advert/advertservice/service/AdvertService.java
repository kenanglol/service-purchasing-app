package com.micro.ege.advert.advertservice.service;

import com.micro.ege.advert.advertservice.api.*;

public interface AdvertService {
    CreateAdvertResponse createAdvert(CreateAdvertRequest createAdvertRequest);

    UpdateAdvertResponse updateAdvert(UpdateAdvertRequest updateAdvertRequest);

    DeleteAdvertReponse deleteAdvert(DeleteAdvertRequest deleteAdvertRequest);

    ListAdvertResponse listAdvert(ListAdvertRequest listAdvertResponse);

    Object getAdvert(Long advertId);
}
