package com.micro.ege.offer.offermicro.dto;

import javax.persistence.*;

@Entity
@Table(name = "offer", schema = "public")
public class OfferDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "offer_id")
    private Long offerID;
    @Column(name = "provider_id")
    private Long serviceProviderID;
    @Column(name = "customer_id")
    private Long customerID;
    @Column(name = "advert_id")
    private Long advertID;
    @Column(name = "conditions")
    private String freeText;
    @Column(name = "status")
    private Short serviceStatus;
    @Column(name = "session")
    private Long session;

    public Long getOfferID() {
        return offerID;
    }

    public void setOfferID(Long offerID) {
        this.offerID = offerID;
    }

    public Long getServiceProviderID() {
        return serviceProviderID;
    }

    public void setServiceProviderID(Long serviceProviderID) {
        this.serviceProviderID = serviceProviderID;
    }

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public Long getAdvertID() {
        return advertID;
    }

    public void setAdvertID(Long advertID) {
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

    public Long getSession() {
        return session;
    }

    public void setSession(Long session) {
        this.session = session;
    }
}
