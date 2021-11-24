package com.micro.ege.user.usermicro.dto;

import lombok.Data;

@Entity
public class UserDetailDto {
    private String userId;
    private String name;
    private String surname;
    private String mail;
    private String password;
}
