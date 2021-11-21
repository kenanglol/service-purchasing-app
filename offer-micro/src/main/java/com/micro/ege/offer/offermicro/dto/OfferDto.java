package com.micro.ege.offer.offermicro.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OfferDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String offerID;
    private String serviceProviderID;
    private String advertID;
    private String freeText;
    private Short serviceStatus;
    private Integer offerTime;

    public String getOfferID() {
        return offerID;
    }

    public void setOfferID(String offerID) {
        this.offerID = offerID;
    }

    public String getServiceProviderID() {
        return serviceProviderID;
    }

    public void setServiceProviderID(String serviceProviderID) {
        this.serviceProviderID = serviceProviderID;
    }

    public String getAdvertID() {
        return advertID;
    }

    public void setAdvertID(String advertID) {
        this.advertID = advertID;
    }

    public String getFreeText() {
        return freeText;
    }

    public void setFreeText(String freeText) {
        this.freeText = freeText;
    }

    public Short getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(Short serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public Integer getOfferTime() {
        return offerTime;
    }

    public void setOfferTime(Integer offerTime) {
        this.offerTime = offerTime;
    }
}
