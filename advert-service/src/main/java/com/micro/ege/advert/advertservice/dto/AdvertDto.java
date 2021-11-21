package com.micro.ege.advert.advertservice.dto;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AdvertDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String advertID;
    private String advertName;
    private String serviceProviderID;
    private String summary;
    private Integer minPrice;
    private LocalDateTime advertCreateTime;
    private String category;
    private String city;

    public LocalDateTime getAdvertCreateTime() {
        return advertCreateTime;
    }

    public void setAdvertCreateTime(LocalDateTime advertCreateTime) {
        this.advertCreateTime = advertCreateTime;
    }

    public String getAdvertID() {
        return advertID;
    }

    public void setAdvertID(String advertID) {
        this.advertID = advertID;
    }

    public String getAdvertName() {
        return advertName;
    }

    public void setAdvertName(String advertName) {
        this.advertName = advertName;
    }

    public String getServiceProviderID() {
        return serviceProviderID;
    }

    public void setServiceProviderID(String serviceProviderID) {
        this.serviceProviderID = serviceProviderID;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
