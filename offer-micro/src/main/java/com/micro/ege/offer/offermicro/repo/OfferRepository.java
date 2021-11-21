package com.micro.ege.offer.offermicro.repo;

import com.micro.ege.offer.offermicro.dto.OfferDto;
import com.micro.ege.offer.offermicro.dto.OfferDetails;
import com.micro.ege.offer.offermicro.dto.ServiceOfferDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OfferRepository extends JpaRepository<OfferDto,String> {
//    @Query("")
//    OfferDto getOfferWithProviderIdAndTime(String serviceProviderID, Integer Time);
//
//    List<OfferDto> listOfferWithAdvert(String advertId);
//
//    List<OfferDto> listOfferWithProvider(String providerId);
//
//    List<OfferDto> listOfferWithAdvertAndStat(String advertId, short serviceStatus);
//
//    List<OfferDto> listOfferWithProviderAndStat(String providerId,short serviceStatus);
//
//    List<OfferDto> listOffer(String providerId, String advertId,short serviceStatus);

}
