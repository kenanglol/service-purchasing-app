package com.micro.ege.offer.offermicro.dto;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "offer")
public class OfferDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "offer_id")
    private String offerID;
    @Column(name = "provider_id")
    private String serviceProviderID;
    @Column(name = "advert_id")
    private String advertID;
    @Column(name = "conditions")
    private String freeText;
    @Column(name = "status")
    private Short serviceStatus;
    @Column(name = "session")
    private LocalDateTime session;

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

    public LocalDateTime getSession() {
        return session;
    }

    public void setSession(LocalDateTime session) {
        this.session = session;
    }
}
