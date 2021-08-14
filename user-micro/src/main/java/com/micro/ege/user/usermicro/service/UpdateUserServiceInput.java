package com.micro.ege.user.usermicro.service;

import lombok.Data;

@Data
public class UpdateUserServiceInput {
    private String userId;
    private String name;
    private String surname;
}
