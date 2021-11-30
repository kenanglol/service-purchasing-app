package com.micro.ege.advert.advertservice.repo;

import com.micro.ege.advert.advertservice.dto.AdvertDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface AdvertRepository extends CrudRepository<AdvertDto,Long> {

    public List<AdvertDto> findByCategory(String category);

    public List<AdvertDto> findByCategoryAndPrice(String category, Integer price);

    public List<AdvertDto> findByCategoryAndCity(String category, String city);

    public List<AdvertDto> findByCategoryAndPriceAndCity(String category, Integer price, String city);

    public AdvertDto findAdvertDtoByAdvertNameAndServiceProviderID(String advertName, Long serviceProviderId);

    public List<AdvertDto> findByServiceProviderID(Long providerId);
}
