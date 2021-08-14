package com.micro.ege.user.usermicro.service;

import com.micro.ege.user.usermicro.core.exception.BussinessException;
import com.micro.ege.user.usermicro.core.exception.DataNotFoundException;

public interface UserService {
    CreateUserServiceOutput createUser(CreateUserServiceInput request);

    GetUserServiceOutput getUser(GetUserServiceInput request) throws DataNotFoundException;

    UpdateUserServiceOutput updateUser(UpdateUserServiceInput request) throws BussinessException;

}
