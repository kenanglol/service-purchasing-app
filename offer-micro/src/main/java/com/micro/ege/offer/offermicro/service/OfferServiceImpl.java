package com.micro.ege.offer.offermicro.service;

import com.micro.ege.offer.offermicro.api.model.*;
import com.micro.ege.offer.offermicro.core.exception.BusinessException;
import com.micro.ege.offer.offermicro.core.exception.OfferExceptions;
import com.micro.ege.offer.offermicro.core.utils.OfferUtils;
import com.micro.ege.offer.offermicro.dto.OfferDto;
import com.micro.ege.offer.offermicro.repo.OfferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OfferServiceImpl implements OfferService{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final OfferRepository offerRepository;


    @Override
    public ManipulationResponse createOffer(CreateOfferRequest createOfferRequest) {
        try {
            String vendor = Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection().getSchema();
        } catch (SQLException sql){
            sql.printStackTrace();
        }

        ManipulationResponse result = new ManipulationResponse();
        try{
            if (createOfferRequest.getServiceStatus()<0 || createOfferRequest.getServiceStatus()>6) {
                throw new BusinessException(OfferExceptions.OFFER_STATUS_NOT_FOUND, HttpStatus.NOT_FOUND);
            }
            OfferDto existOffer = offerRepository.findByServiceProviderIDAndSession(
                            createOfferRequest.getServiceProviderID(),
                            createOfferRequest.getSession());
            if (existOffer != null) {
                throw new BusinessException(OfferExceptions.TIME_IS_FILLED_ALREADY);
            }
            OfferDto offerDto = new OfferDto();
            offerDto.setServiceProviderID(createOfferRequest.getServiceProviderID());
            offerDto.setAdvertID(createOfferRequest.getAdvertID());
            offerDto.setFreeText(createOfferRequest.getFreeText());
            offerDto.setServiceStatus(createOfferRequest.getServiceStatus());
            offerDto.setSession(createOfferRequest.getSession());
            offerDto.setCustomerID(createOfferRequest.getCustomerID());
            offerRepository.save(offerDto);

            return ManipulationResponse.SUCCESS_PROCESS;

        } catch (BusinessException businessException) {
            result.setIsSucceeded(false);
            result.setErrorCode(businessException.getErrorCode());
            result.setErrorMessage(businessException.getErrorMessage());
            return result;
        }

    }

    @Override
    public ManipulationResponse updateOffer(UpdateOfferRequest updateOfferRequest) {

        ManipulationResponse result = new ManipulationResponse();

        try{
            if (updateOfferRequest.getServiceStatus()<0 || updateOfferRequest.getServiceStatus()>6) {
                throw new BusinessException(OfferExceptions.OFFER_STATUS_NOT_FOUND);
            }

            Optional<OfferDto> existOffer = offerRepository.findById(updateOfferRequest.getOfferID());
            if (existOffer.isEmpty()) {
                throw new BusinessException(OfferExceptions.OFFER_NOT_FOUND, HttpStatus.NOT_FOUND);
            }
            OfferDto updateOffer = existOffer.get();
            if (updateOfferRequest.getServiceStatus() != null &&
                    !updateOffer.getServiceStatus().equals(updateOfferRequest.getServiceStatus())){
                if (!OfferUtils.checkServiceStatusChange(updateOffer.getServiceStatus(),
                        updateOfferRequest.getServiceStatus())) {
                    throw new BusinessException(OfferExceptions.STATUS_CHANGE_NOT_VALID);
                } else {
                    updateOffer.setServiceStatus(updateOfferRequest.getServiceStatus());
                }
            }
            updateOffer.setFreeText(updateOfferRequest.getFreeText());
            offerRepository.save(existOffer.get());

            return ManipulationResponse.SUCCESS_PROCESS;

        } catch (BusinessException businessException) {
            result.setIsSucceeded(false);
            result.setErrorCode(businessException.getErrorCode());
            result.setErrorMessage(businessException.getErrorMessage());
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
    public ManipulationResponse deleteOffer(Long offerId) {
        ManipulationResponse result = new ManipulationResponse();

        try{
            Optional<OfferDto> existOffer = offerRepository.findById(offerId);
            if (existOffer.isEmpty()) {
                throw new BusinessException(OfferExceptions.OFFER_STATUS_NOT_FOUND, HttpStatus.NOT_FOUND);
            }

            offerRepository.deleteById(offerId);

            return ManipulationResponse.SUCCESS_PROCESS;
        }
        catch (Exception exception) {
        result.setIsSucceeded(false);
        result.setErrorCode(99999L);
        result.setErrorMessage(exception.getMessage());
        return result;
        }
    }

    @Override
    public ListOfferResponse listOffer(ListOfferRequest listOfferRequest) {
        return null;
    }

    @Override
    public OfferDto getOffer(Long offerId) throws BusinessException {
        Optional<OfferDto> existOffer = offerRepository.findById(offerId);
        if (existOffer.isEmpty()) {
            throw new BusinessException(OfferExceptions.OFFER_NOT_FOUND);
        }
        return existOffer.get();
    }
}
