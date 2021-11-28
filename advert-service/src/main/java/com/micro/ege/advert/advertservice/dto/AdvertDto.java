package com.micro.ege.advert.advertservice.dto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AdvertDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long advertID;
    private String advertName;
    private Long serviceProviderID;
    private String summary;
    private Integer price;
    private String category;
    private String city;

    public Long getAdvertID() {
        return advertID;
    }

    public void setAdvertID(Long advertID) {
        this.advertID = advertID;
    }

    public String getAdvertName() {
        return advertName;
    }

    public void setAdvertName(String advertName) {
        this.advertName = advertName;
    }

    public Long getServiceProviderID() {
        return serviceProviderID;
    }

    public void setServiceProviderID(Long serviceProviderID) {
        this.serviceProviderID = serviceProviderID;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer minPrice) {
        this.price = minPrice;
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
