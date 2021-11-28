package com.micro.ege.advert.advertservice.service;

import com.micro.ege.advert.advertservice.api.model.CreateAdvertRequest;
import com.micro.ege.advert.advertservice.api.model.ListAdvertResponse;
import com.micro.ege.advert.advertservice.api.model.ManipulationResponse;
import com.micro.ege.advert.advertservice.api.model.UpdateAdvertRequest;
import com.micro.ege.advert.advertservice.core.exception.BusinessException;
import com.micro.ege.advert.advertservice.core.exception.DataNotFoundException;
import com.micro.ege.advert.advertservice.dto.AdvertDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.micro.ege.advert.advertservice.core.exception.AdvertExceptions;
import com.micro.ege.advert.advertservice.dto.AdvertDetailsDto;
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
            AdvertDto existAdvert = advertRepository.findByAdvertNameAAndServiceProviderID(
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
    public ManipulationResponse updateAdvert(UpdateAdvertRequest updateAdvertRequest) throws DataNotFoundException, BusinessException {
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

    }

    @Override
    public DeleteAdvertServiceOutput deleteAdvert(DeleteAdvertServiceInput deleteAdvertServiceInput) {
        DeleteAdvertServiceOutput result = new DeleteAdvertServiceOutput();

        try{
            Optional<AdvertDto> existAdvert = AdvertRepository
                    .findById(deleteAdvertServiceInput.getAdvertID());
            if (existAdvert.isEmpty()) {
                throw new BusinessException(ADVERT_NOT_FOUND);
            }

            AdvertRepository.delete(existAdvert.get());

            result.setIsSucceeded(true);
            result.setErrorCode(0L);
            result.setErrorMessage("İşlem Başarıyla Gerçekleştirildi.");
            return result;
        }
        catch (Exception exception) {
            result.setIsSucceeded(false);
            result.setErrorCode(99999L);
            result.setErrorMessage(exception.getMessage());
            return result;
        }
    }

    @Override
    public ListAdvertResponse listAdvert(ListAdvertRequest listAdvertResponse) {
        List<AdvertDetailsDto> AdvertDetailsList = null;
//        try{
//            if ((listAdvertServiceInput.getAdvertID() != null)
//                    && (listAdvertServiceInput.getServiceProviderID() != null)
//                    && (listAdvertServiceInput.getServiceStatus() != null)
//                    && (listAdvertServiceInput.getMinPrice() != null)) {
//                AdvertDetailsList = AdvertRepository.listAdvert(listAdvertServiceInput.getServiceProviderID(),
//                        listAdvertServiceInput.getAdvertID(),
//                        listAdvertServiceInput.getMinPrice());
//
//            }else if ((listAdvertServiceInput.getAdvertID() != null)
//                    && (listAdvertServiceInput.getServiceStatus() != null)) {
//                AdvertDetailsList = AdvertRepository.listAdvertWithAdvertAndStat(listAdvertServiceInput.getAdvertID());
//
//            }else if ((listAdvertServiceInput.getServiceProviderID() != null)
//                    && (listAdvertServiceInput.getServiceStatus() != null)) {
//                AdvertDetailsList = AdvertRepository.listAdvertWithProviderAndStat(
//                        listAdvertServiceInput.getServiceProviderID());
//
//
//            }else if (listAdvertServiceInput.getServiceProviderID() != null) {
//                AdvertDetailsList = AdvertRepository.listAdvertWithProvider(listAdvertServiceInput.getServiceProviderID());
//
//            }else {
//                throw new BusinessException(AdvertExceptions.BAD_LIST_ADVERT_REQUEST);
//            }
            result.setAdvertDetailsList(AdvertDetailsList);
            result.setErrorCode(0L);
            result.setErrorMessage("İşlem Başarıyla Gerçekleştirildi.");
            return result;
//        }catch (BusinessException businessException) {
//
//            result.setErrorCode(businessException.getErrorCode());
//            result.setErrorMessage(businessException.getErrorMessage());
//            return result;
//        }
//        catch (Exception exception) {
//            result.setErrorCode(99999L);
//            result.setErrorMessage(exception.getMessage());
//            return result;
//        }
    }

}
