package com.micro.ege.offer.offermicro.repo;

import com.micro.ege.offer.offermicro.dto.OfferDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OfferRepository extends JpaRepository<OfferDto,String> {
    @Query( value = "SELECT OFFER_ID AS offerID,CUSTOMER_ID AS customerID,PROVIDER_ID AS serviceProviderID,\n" +
            "       ADVERT_ID AS advertID,CONDITIONS AS freeText,STATUS AS serviceStatus,SESSION AS session\n" +
            "FROM OFFER\n" +
            "WHERE PROVIDER_ID = ?1 AND SESSION = ?2",
    nativeQuery = true)
    OfferDto getOfferWithProviderIdAndTime(String providerId, Long session);
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
