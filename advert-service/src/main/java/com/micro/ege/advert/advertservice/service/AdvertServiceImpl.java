package com.micro.ege.advert.advertservice.service;

import com.micro.ege.advert.advertservice.api.CreateAdvertRequest;
import com.micro.ege.advert.advertservice.api.CreateAdvertResponse;
import com.micro.ege.advert.advertservice.api.ListAdvertRequest;
import com.micro.ege.advert.advertservice.api.ListAdvertResponse;
import com.micro.ege.advert.advertservice.dto.AdvertDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.micro.ege.advert.advertservice.core.exception.BusinessException;
import com.micro.ege.advert.advertservice.core.exception.AdvertExceptions;
import com.micro.ege.advert.advertservice.dto.AdvertDetailsDto;
import com.micro.ege.advert.advertservice.repo.AdvertRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AdvertServiceImpl implements AdvertService {

    private final AdvertRepository AdvertRepository;

    @Override
    public CreateAdvertResponse createAdvert(CreateAdvertRequest createAdvertRequest) {
        try{
            AdvertDto existAdvert = AdvertRepository.findByServiceProviderIDAndAdvertCreateTime(
                    createAdvertServiceInput.getServiceProviderID(),
                    createAdvertServiceInput.getAdvertCreateTime()
            );
            if (existAdvert != null) {
                throw new BusinessException(AdvertExceptions.TIME_IS_FILLED_ALREADY);
            }

            if (createAdvertServiceInput.getMinPrice()<0) {
                throw new BusinessException(AdvertExceptions.MIN_PRICE_IS_NOT_LOWER_THAN_ZERO);
            }

            AdvertDto advertDto = new AdvertDto();
            advertDto.setServiceProviderID(createAdvertServiceInput.getServiceProviderID());
            advertDto.setAdvertName(createAdvertServiceInput.getAdvertName());
            advertDto.setSummary(createAdvertServiceInput.getSummary());
            advertDto.setCategory(createAdvertServiceInput.getCategory());
            advertDto.setPrice(createAdvertServiceInput.getMinPrice());

            AdvertRepository.save(advertDto);


            result.setIsSucceeded(AdvertRepository.findById(advertDto.getAdvertID()).isPresent());
            result.setErrorCode(0L);
            result.setErrorMessage("İşlem Başarıyla Gerçekleştirildi.");
            return result;

        } catch (BusinessException businessException) {
            result.setIsSucceeded(false);
            result.setErrorCode(businessException.getErrorCode());
            result.setErrorMessage(businessException.getErrorMessage());
            return result;
        }

    }

    @Override
    public UpdateAdvertServiceOutput updateAdvert(UpdateAdvertServiceInput updateAdvertServiceInput) {

        UpdateAdvertServiceOutput result = new UpdateAdvertServiceOutput();
//        try{
//
//            ServiceAdvertDto existAdvert = AdvertRepository
//                    .getAdvertWithAdvertId(
//                            updateAdvertServiceInput.getAdvertID());
//            if (existAdvert == null) {
//                throw new BusinessException(AdvertExceptions.ADVERT_NOT_FOUND);
//            }
//            ServiceAdvertDto filledAdvert = AdvertRepository
//                    .getAdvertWithProviderIdAndTime(existAdvert.getServiceProviderID(),
//                            updateAdvertServiceInput.getAdvertCreateTime());
//            if (filledAdvert != null && (!filledAdvert.getAdvertID().equals(updateAdvertServiceInput.getAdvertID()))) {
//                throw new BusinessException(AdvertExceptions.TIME_IS_FILLED_ALREADY);
//            }
//
//            if (!AdvertUtils.checkServiceStatusChange(existAdvert.getServiceStatus(),
//                    updateAdvertServiceInput.getServiceStatus())) {
//                throw new BusinessException(AdvertExceptions.STATUS_CHANGE_NOT_VALID);
//            }
//            Boolean success = AdvertRepository.updateAdvert(updateAdvertServiceInput.getAdvertName(),
//                    updateAdvertServiceInput.getAdvertID(),
//                    updateAdvertServiceInput.getSummary(),
//                    updateAdvertServiceInput.getAdvertCreateTime(),
//                    updateAdvertServiceInput.getMinPrice(),
//                    updateAdvertServiceInput.getCity(),
//                    updateAdvertServiceInput.getCategory());
//
//            result.setIsSucceeded(success);
            result.setErrorCode(0L);
            result.setErrorMessage("İşlem Başarıyla Gerçekleştirildi.");
            return result;


//        }catch (BusinessException businessException) {
//            result.setIsSucceeded(false);
//            result.setErrorCode(businessException.getErrorCode());
//            result.setErrorMessage(businessException.getErrorMessage());
//            return result;
//        }
//        catch (Exception exception) {
//            result.setIsSucceeded(false);
//            result.setErrorCode(99999L);
//            result.setErrorMessage(exception.getMessage());
//            return result;
//        }
    }

    @Override
    public DeleteAdvertServiceOutput deleteAdvert(DeleteAdvertServiceInput deleteAdvertServiceInput) {
        DeleteAdvertServiceOutput result = new DeleteAdvertServiceOutput();

        try{
            Optional<AdvertDto> existAdvert = AdvertRepository
                    .findById(deleteAdvertServiceInput.getAdvertID());
            if (existAdvert.isEmpty()) {
                throw new BusinessException(AdvertExceptions.ADVERT_NOT_FOUND);
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
