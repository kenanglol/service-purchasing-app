package com.micro.ege.user.usermicro.service;

import com.micro.ege.user.usermicro.api.model.CreateUserRequest;
import com.micro.ege.user.usermicro.api.model.ManipulationResponse;
import com.micro.ege.user.usermicro.api.model.UpdateUserRequest;
import com.micro.ege.user.usermicro.core.constant.UserMicroConstants;
import com.micro.ege.user.usermicro.core.exception.UserExceptions;
import com.micro.ege.user.usermicro.dto.UserDto;
import com.micro.ege.user.usermicro.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.micro.ege.user.usermicro.core.exception.UserExceptions.*;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public ManipulationResponse createUser(CreateUserRequest request) throws DataManipulationException {
        CreateUserServiceOutput result = new CreateUserServiceOutput();
        UserDto createUserDto = new UserDto();
        if (userRepository.findByMail(request.getMail()) == null) {
            throw new BussinessException(USER_NOT_FOUND);
        }
        createUserDto.setFirstName(request.getFirstName());
        createUserDto.setMiddleName(request.getMiddleName());
        createUserDto.setSurName(request.getSurName());
        createUserDto.getMail(request.getMail());
        createUserDto.setFirstName(request.getFirstName());
        createUserDto.setMiddleName(request.getMiddleName());
        createUserDto.setFirstName(request.getFirstName());
        createUserDto.setMiddleName(request.getMiddleName());
        createUserDto.setMail(request.getMail());
        createUserDto.setCipher(bCryptPasswordEncoder.encode(request.getCipher()));

        Boolean isComplete = userRepository.createUser(createUserDto);
        result.setIsSucceeded(isComplete);
        if (isComplete) {
            result.setErrorCode(UserMicroConstants.SUCCESS_CODE);
            result.setErrorMessage(UserMicroConstants.SUCCESS_MSG);
        } else {
            throw new DataManipulationException(USER_CREATE_ERROR);
        }

        return result;
    }

    @Override
    public UserDto getUser(Long userId) throws DataNotFoundException {

        UserDto response = new UserDto();
        UserDto userDetails = null;

        if (request.getUserId() != null) {
           userDetails = userRepository.getUserWithId(request.getUserId());
        } else if (request.getMail() != null){
            userDetails = userRepository.getUserWithMail(request.getMail());
        } else {
            throw new DataNotFoundException(UserExceptions.GET_REQ_EMPTY);
        }

        if (userDetails == null) {
            throw new DataNotFoundException(UserExceptions.USER_NOT_FOUND);
        }

        response.setUserId(userDetails.getUserId());
        response.setMail(userDetails.getMail());
        response.setName(userDetails.getName());
        response.setSurname(userDetails.getSurname());
        return response;

    }

    @Override
    public ManipulationResponse updateUser(UpdateUserRequest request) throws BussinessException {
        UpdateUserServiceOutput response = new UpdateUserServiceOutput();
        Boolean isComplete = userRepository.updateUser(request.getUserId(), request.getName(), request.getSurname());
        if (!isComplete) {
            throw new BussinessException(UserExceptions.USER_UPDATE_ERROR);
        }

        response.setIsSucceeded(true);
        response.setErrorCode(UserMicroConstants.SUCCESS_CODE);
        response.setErrorMessage(UserMicroConstants.SUCCESS_MSG);
        return  response;
    }



    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDetailDto userDetailDto = userRepository.getUserWithMail(s);
        if (userDetailDto == null)  throw new UsernameNotFoundException(s);

        return new User(userDetailDto.getMail(),userDetailDto.getPassword(),
                true, true, true, true,
                new ArrayList<>());
    }
}
