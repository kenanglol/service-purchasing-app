package com.micro.ege.user.usermicro.service;

import com.micro.ege.user.usermicro.api.model.CreateUserRequest;
import com.micro.ege.user.usermicro.api.model.ManipulationResponse;
import com.micro.ege.user.usermicro.api.model.UpdateUserRequest;
import com.micro.ege.user.usermicro.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    ManipulationResponse createUser(CreateUserRequest request) throws DataManipulationException;

    UserDto getUser(Long userId) throws DataNotFoundException;

    ManipulationResponse updateUser(UpdateUserRequest request) throws BussinessException;
}
