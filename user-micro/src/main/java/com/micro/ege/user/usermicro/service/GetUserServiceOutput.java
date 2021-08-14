package com.micro.ege.user.usermicro.service;

import lombok.Data;

@Data
public class GetUserServiceOutput {
    private String userId;
    private String name;
    private String surname;
    private String mail;
}
