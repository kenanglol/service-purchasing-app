package com.micro.ege.offer.offermicro.service;

import com.micro.ege.offer.offermicro.core.exception.BusinessException;
import com.micro.ege.offer.offermicro.core.exception.OfferExceptions;
import com.micro.ege.offer.offermicro.core.utils.OfferUtils;
import com.micro.ege.offer.offermicro.dto.OfferDto;
import com.micro.ege.offer.offermicro.dto.OfferDetails;
import com.micro.ege.offer.offermicro.dto.ServiceOfferDto;
import com.micro.ege.offer.offermicro.repo.OfferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.micro.ege.offer.offermicro.core.constant.OfferMicroConstants.PROCESS_SUCCEED;

@Service
@RequiredArgsConstructor
public class OfferServiceImpl implements OfferService{

    private final OfferRepository offerRepository;

    @Override
    public CreateOfferServiceOutput createOffer(CreateOfferServiceInput createOfferServiceInput) {

        CreateOfferServiceOutput result = new CreateOfferServiceOutput();
        try{
            if (createOfferServiceInput.getServiceStatus()<0 || createOfferServiceInput.getServiceStatus()>6) {
                throw new BusinessException(OfferExceptions.OFFER_STATUS_NOT_FOUND);
            }
            ServiceOfferDto existOffer = offerRepository
                    .getOfferWithProviderIdAndTime(
                            createOfferServiceInput.getServiceProviderID(),
                            createOfferServiceInput.getSession());
            if (existOffer != null) {
                throw new BusinessException(OfferExceptions.TIME_IS_FILLED_ALREADY);
            }
            OfferDto offerDto = new OfferDto();
            offerDto.setServiceProviderID(createOfferServiceInput.getServiceProviderID());
            offerDto.setAdvertID(createOfferServiceInput.getAdvertID());
            offerDto.setFreeText(createOfferServiceInput.getFreeText());
            offerDto.setServiceStatus(createOfferServiceInput.getServiceStatus());
            offerDto.setSession(createOfferServiceInput.getSession());
            offerRepository.save(offerDto);

            result.setIsSucceeded(true);
            result.setErrorCode(0L);
            result.setErrorMessage(PROCESS_SUCCEED);
            return result;

        } catch (BusinessException businessException) {
            result.setIsSucceeded(false);
            result.setErrorCode(businessException.getErrorCode());
            result.setErrorMessage(businessException.getErrorMessage());
            return result;
        }

    }

    @Override
    public UpdateOfferServiceOutput updateOffer(UpdateOfferServiceInput updateOfferServiceInput) {

        UpdateOfferServiceOutput result = new UpdateOfferServiceOutput();

        try{
            if (updateOfferServiceInput.getServiceStatus()<0 || updateOfferServiceInput.getServiceStatus()>6) {
                throw new BusinessException(OfferExceptions.OFFER_STATUS_NOT_FOUND);
            }

            Optional<OfferDto> existOffer = offerRepository.findById(updateOfferServiceInput.getOfferID());
            if (existOffer.isEmpty()) {
                throw new BusinessException(OfferExceptions.OFFER_NOT_FOUND);
            }
            OfferDto updateOffer = existOffer.get();
            if (!OfferUtils.checkServiceStatusChange(updateOffer.getServiceStatus(),
                    updateOfferServiceInput.getServiceStatus())) {
                throw new BusinessException(OfferExceptions.STATUS_CHANGE_NOT_VALID);
            }
            updateOffer.setServiceStatus(updateOfferServiceInput.getServiceStatus());
            updateOffer.setFreeText(updateOfferServiceInput.getFreeText());
            offerRepository.save(existOffer.get());

            result.setIsSucceeded(true);
            result.setErrorCode(0L);
            result.setErrorMessage(PROCESS_SUCCEED);
            return result;

        }catch (BusinessException businessException) {
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
    public DeleteOfferServiceOutput deleteOffer(DeleteOfferServiceInput deleteOfferServiceInput) {
        DeleteOfferServiceOutput result = new DeleteOfferServiceOutput();

        try{
            Optional<OfferDto> existOffer = offerRepository.findById(deleteOfferServiceInput.getOfferID());
            if (existOffer.isEmpty()) {
                throw new BusinessException(OfferExceptions.OFFER_NOT_FOUND);
            }

            offerRepository.deleteById(deleteOfferServiceInput.getOfferID());

            result.setIsSucceeded(true);
            result.setErrorCode(0L);
            result.setErrorMessage(PROCESS_SUCCEED);
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
    public ListOfferServiceOutput listOffer(ListOfferServiceInput listOfferServiceInput) {
        ListOfferServiceOutput result = new ListOfferServiceOutput();
        List<OfferDetails> offerDetailsList = null;
        try{
            if ((listOfferServiceInput.getAdvertID() != null)
                    && (listOfferServiceInput.getServiceProviderID() != null)
                    && (listOfferServiceInput.getServiceStatus() != null)) {
                offerDetailsList = offerRepository.listOffer(listOfferServiceInput.getServiceProviderID(),
                        listOfferServiceInput.getAdvertID(),
                        listOfferServiceInput.getServiceStatus());

            }else if ((listOfferServiceInput.getAdvertID() != null)
                    && (listOfferServiceInput.getServiceStatus() != null)) {
                offerDetailsList = offerRepository.listOfferWithAdvertAndStat(listOfferServiceInput.getAdvertID(),
                        listOfferServiceInput.getServiceStatus());

            }else if ((listOfferServiceInput.getServiceProviderID() != null)
                    && (listOfferServiceInput.getServiceStatus() != null)) {
                offerDetailsList = offerRepository.listOfferWithProviderAndStat(
                        listOfferServiceInput.getServiceProviderID(), listOfferServiceInput.getServiceStatus());

            }else if (listOfferServiceInput.getAdvertID() != null) {
                offerDetailsList = offerRepository.listOfferWithAdvert(listOfferServiceInput.getAdvertID());

            }else if (listOfferServiceInput.getServiceProviderID() != null) {
                offerDetailsList = offerRepository.listOfferWithProvider(listOfferServiceInput.getServiceProviderID());

            }else {
                throw new BusinessException(OfferExceptions.BAD_LIST_OFFER_REQUEST);
            }
            result.setOfferDetailsList(offerDetailsList);
            result.setErrorCode(0L);
            result.setErrorMessage(PROCESS_SUCCEED);
            return result;
        }catch (BusinessException businessException) {

            result.setErrorCode(businessException.getErrorCode());
            result.setErrorMessage(businessException.getErrorMessage());
            return result;
        }
        catch (Exception exception) {
            result.setErrorCode(99999L);
            result.setErrorMessage(exception.getMessage());
            return result;
        }
    }
}
