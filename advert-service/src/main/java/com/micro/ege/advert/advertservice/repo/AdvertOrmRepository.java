package com.micro.ege.advert.advertservice.repo;

import com.micro.ege.advert.advertservice.dto.AdvertDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertOrmRepository extends  JpaRepository<AdvertDto, String> {

}
