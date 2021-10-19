package com.micro.ege.user.usermicro.dto;

import lombok.Data;

@Data
public class UserDetailDto {
    private String userId;
    private String name;
    private String surname;
    private String mail;
    private String password;
}
