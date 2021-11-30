package com.micro.ege.advert.advertservice.service;

import com.micro.ege.advert.advertservice.api.model.*;
import com.micro.ege.advert.advertservice.core.exception.BusinessException;
import com.micro.ege.advert.advertservice.core.exception.DataNotFoundException;
import com.micro.ege.advert.advertservice.dto.AdvertDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.micro.ege.advert.advertservice.repo.AdvertRepository;

import java.util.List;
import java.util.Optional;

import static com.micro.ege.advert.advertservice.core.constant.AdvertMicroConstants.*;
import static com.micro.ege.advert.advertservice.core.exception.AdvertExceptions.*;

@RequiredArgsConstructor
@Service
public class AdvertServiceImpl implements AdvertService {

    private final AdvertRepository advertRepository;

    @Override
    public ManipulationResponse createAdvert(CreateAdvertRequest createAdvertRequest) throws BusinessException, DataNotFoundException {
            AdvertDto existAdvert = advertRepository.findAdvertDtoByAdvertNameAndServiceProviderID(
                    createAdvertRequest.getAdvertName(),
                    createAdvertRequest.getServiceProviderID());
            if (existAdvert != null) {
                throw new DataNotFoundException(ADVERT_NOT_FOUND);
            }

            if (createAdvertRequest.getPrice()<0) {
                throw new BusinessException(MIN_PRICE_IS_NOT_LOWER_THAN_ZERO);
            }

            AdvertDto advertDto = new AdvertDto();
            advertDto.setServiceProviderID(createAdvertRequest.getServiceProviderID());
            advertDto.setAdvertName(createAdvertRequest.getAdvertName());
            advertDto.setSummary(createAdvertRequest.getSummary());
            advertDto.setCategory(createAdvertRequest.getCategory());
            advertDto.setPrice(createAdvertRequest.getPrice());

            advertRepository.save(advertDto);
            ManipulationResponse result = new ManipulationResponse();
            result.setIsSucceeded(advertRepository.findById(advertDto.getAdvertID()).isPresent());
            result.setErrorCode(SUCCESS_CODE);
            result.setErrorMessage(SUCCESS_MSG);
            return result;
    }

    @Override
    public ManipulationResponse updateAdvert(UpdateAdvertRequest updateAdvertRequest)
            throws DataNotFoundException, BusinessException {
        Optional<AdvertDto> existAdvert = advertRepository.findById(updateAdvertRequest.getAdvertID());
        if(existAdvert.isEmpty()) throw new DataNotFoundException(ADVERT_NOT_FOUND);

        AdvertDto updateAdvert = existAdvert.get();
        updateAdvert.setPrice(updateAdvertRequest.getPrice());
        updateAdvert.setAdvertName(updateAdvertRequest.getAdvertName());
        updateAdvert.setCity(updateAdvertRequest.getCity());
        updateAdvert.setSummary(updateAdvert.getSummary());
        try {
            advertRepository.save(updateAdvert);
        } catch (Exception ex) {
            throw new BusinessException(ADVERT_UPDATE_ERROR);
        }
        return ManipulationResponse.SUCCESS_PROCESS;
    }

    @Override
    public ManipulationResponse deleteAdvert(DeleteAdvertRequest deleteAdvertRequest) throws DataNotFoundException, BusinessException {
        Optional<AdvertDto> existAdvert = advertRepository.findById(deleteAdvertRequest.getAdvertID());
        if(existAdvert.isEmpty()) throw new DataNotFoundException(ADVERT_NOT_FOUND);
        try {
            advertRepository.delete(existAdvert.get());
        } catch (Exception ex) {
            throw new BusinessException(ADVERT_DELETE_ERROR);
        }
        return ManipulationResponse.SUCCESS_PROCESS;
    }

    @Override
    public List<AdvertDto> listAdvert(ListAdvertRequest listAdvertResponse) throws DataNotFoundException {
        List<AdvertDto> selectedAdvertList;
        if (listAdvertResponse.getCity() == null && listAdvertResponse.getPrice() == null) {
            selectedAdvertList = advertRepository.findByCategory(listAdvertResponse.getCategory());
        } else if (listAdvertResponse.getCity() == null) {
            selectedAdvertList = advertRepository.findByCategoryAndPrice(
                    listAdvertResponse.getCategory(),
                    listAdvertResponse.getPrice());

        } else if (listAdvertResponse.getPrice() == null) {
            selectedAdvertList = advertRepository.findByCategoryAndCity(
                    listAdvertResponse.getCategory(),
                    listAdvertResponse.getCity());
        } else {
            selectedAdvertList = advertRepository.findByCategoryAndPriceAndCity(
                    listAdvertResponse.getCategory(),
                    listAdvertResponse.getPrice(),
                    listAdvertResponse.getCity());
        }

        if (selectedAdvertList == null || selectedAdvertList.isEmpty())
            throw new DataNotFoundException(ADVERT_NOT_FOUND);

        return selectedAdvertList;
    }

    @Override
    public AdvertDto getAdvert(Long advertId) throws DataNotFoundException {
        Optional<AdvertDto> advert = advertRepository.findById(advertId);
        if (advert.isEmpty()) throw new DataNotFoundException(ADVERT_NOT_FOUND);
        return advert.get();
    }

    @Override
    public List<AdvertDto> getAdvertListOfProvider(Long providerId) throws DataNotFoundException {
        List<AdvertDto> selectedAdvertList = advertRepository.findByServiceProviderID(providerId);
        if (selectedAdvertList == null || selectedAdvertList.isEmpty())
            throw new DataNotFoundException(ADVERT_NOT_FOUND);

        return selectedAdvertList;
    }

}
