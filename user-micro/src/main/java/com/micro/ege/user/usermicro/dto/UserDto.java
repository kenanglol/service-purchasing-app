package com.micro.ege.user.usermicro.dto;

import javax.persistence.*;

@Entity
public class UserDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "is_provider")
    private Boolean isProvider;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "surname")
    private String surName;
    @Column(name = "mail")
    private String mail;
    @Column(name = "hash")
    private String password;
    @Column(name = "salt")
    private String salt;
    @Column(name = "location")
    private String location;
    @Column(name = "experience")
    private Integer experience;
    @Column(name = "speciality")
    private String expertise;
    @Column(name = "user_score")
    private Double user_score;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getProvider() {
        return isProvider;
    }

    public void setProvider(Boolean provider) {
        isProvider = provider;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public Double getUser_score() {
        return user_score;
    }

    public void setUser_score(Double user_score) {
        this.user_score = user_score;
    }
}
