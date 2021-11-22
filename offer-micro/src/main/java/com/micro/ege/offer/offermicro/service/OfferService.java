package com.micro.ege.offer.offermicro.service;

import com.micro.ege.offer.offermicro.api.CreateOfferRequest;
import com.micro.ege.offer.offermicro.api.ManipulationResponse;
import com.micro.ege.offer.offermicro.api.UpdateOfferRequest;
import com.micro.ege.offer.offermicro.core.exception.BusinessException;
import com.micro.ege.offer.offermicro.dto.OfferDto;
import com.micro.ege.offer.offermicro.service.model.*;

public interface OfferService {
    ManipulationResponse createOffer(CreateOfferRequest createOfferRequest);

    ManipulationResponse updateOffer(UpdateOfferRequest updateOfferRequest);

    ManipulationResponse deleteOffer(String offerId);

    ListOfferServiceOutput listOffer(ListOfferServiceInput listOfferServiceInput);

    OfferDto getOffer(String offerId) throws BusinessException;
}
