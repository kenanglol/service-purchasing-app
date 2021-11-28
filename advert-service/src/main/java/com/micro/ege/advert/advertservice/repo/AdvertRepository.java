package com.micro.ege.advert.advertservice.repo;

import com.micro.ege.advert.advertservice.dto.AdvertDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface AdvertRepository extends PagingAndSortingRepository<AdvertDto,Long> {

    public List<AdvertDto> findByCategory(String Category);

    public AdvertDto findByAdvertNameAAndServiceProviderID(String advertName, Long serviceProviderId);

    public List<AdvertDto> findByServiceProviderID(Long providerId);
}
