package com.micro.ege.advert.advertservice.repo;

import com.micro.ege.advert.advertservice.dto.AdvertDto;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AdvertRepository extends CrudRepository<AdvertDto,String> {

    List<AdvertDto> findByCategory(String Category);

    List<AdvertDto> findByServiceProviderID(String serviceProviderID);

    AdvertDto findByServiceProviderIDAndAdvertCreateTime(String serviceProviderID,
                                                         LocalDateTime advertCreateTime);
}
