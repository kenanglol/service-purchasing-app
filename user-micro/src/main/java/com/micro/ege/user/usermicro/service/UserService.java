package com.micro.ege.user.usermicro.service;

import com.micro.ege.user.usermicro.api.model.CreateUserRequest;
import com.micro.ege.user.usermicro.api.model.ManipulationResponse;
import com.micro.ege.user.usermicro.api.model.UpdateUserRequest;
import com.micro.ege.user.usermicro.core.exception.BusinessException;
import com.micro.ege.user.usermicro.core.exception.CustomException;
import com.micro.ege.user.usermicro.core.exception.DataManipulationException;
import com.micro.ege.user.usermicro.core.exception.DataNotFoundException;
import com.micro.ege.user.usermicro.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    ManipulationResponse createUser(CreateUserRequest request) throws BusinessException, DataManipulationException, CustomException;

    UserDto getUser(Long userId) throws DataNotFoundException, CustomException;

    UserDto getUser(String mail) throws DataNotFoundException, CustomException;

    ManipulationResponse updateUser(UpdateUserRequest request) throws BusinessException, CustomException;
}
