package com.micro.ege.offer.offermicro.service;

import com.micro.ege.offer.offermicro.api.model.*;
import com.micro.ege.offer.offermicro.core.exception.BusinessException;
import com.micro.ege.offer.offermicro.dto.OfferDto;

public interface OfferService {
    ManipulationResponse createOffer(CreateOfferRequest createOfferRequest);

    ManipulationResponse updateOffer(UpdateOfferRequest updateOfferRequest);

    ManipulationResponse deleteOffer(Long offerId);

    ListOfferResponse listOffer(ListOfferRequest listOfferRequest);

    OfferDto getOffer(Long offerId) throws BusinessException;
}
