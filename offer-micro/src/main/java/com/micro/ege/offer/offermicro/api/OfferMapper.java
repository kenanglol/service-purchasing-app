package com.micro.ege.offer.offermicro.api;

import com.micro.ege.offer.offermicro.service.model.*;
import org.mapstruct.Mapper;

@Mapper
public interface OfferMapper {
    public ListOfferServiceInput mapApiRequestToServiceInput(ListOfferRequest listOfferRequest);
    public ListOfferResponse mapServiceOutputToApiResponse(ListOfferServiceOutput listOfferResponse);

}
