package com.micro.ege.offer.offermicro.repo;

import com.micro.ege.offer.offermicro.dto.OfferDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<OfferDto,Long> {

    OfferDto findByServiceProviderIDAndSession(Long providerId, Long session);

}
