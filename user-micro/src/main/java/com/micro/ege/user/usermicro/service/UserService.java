package com.micro.ege.user.usermicro.service;

import com.micro.ege.user.usermicro.core.exception.BussinessException;
import com.micro.ege.user.usermicro.core.exception.DataManipulationException;
import com.micro.ege.user.usermicro.core.exception.DataNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    CreateUserServiceOutput createUser(CreateUserServiceInput request) throws DataManipulationException;

    GetUserServiceOutput getUser(GetUserServiceInput request) throws DataNotFoundException;

    UpdateUserServiceOutput updateUser(UpdateUserServiceInput request) throws BussinessException;
}
