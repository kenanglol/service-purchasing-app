package com.micro.ege.user.usermicro.service;

import com.micro.ege.user.usermicro.api.model.CreateUserRequest;
import com.micro.ege.user.usermicro.api.model.ManipulationResponse;
import com.micro.ege.user.usermicro.api.model.UpdateUserRequest;
import com.micro.ege.user.usermicro.core.exception.*;
import com.micro.ege.user.usermicro.dto.UserDto;
import com.micro.ege.user.usermicro.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

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
    public ManipulationResponse createUser(CreateUserRequest request) throws CustomException {
        UserDto createUserDto = new UserDto();
        if (userRepository.findByMail(request.getMail()).isPresent()) {
            throw new BusinessException(USER_ALREADY_EXIST);
        }
        createUserDto.setFirstName(request.getFirstName());
        createUserDto.setMiddleName(request.getMiddleName());
        createUserDto.setSurName(request.getSurName());
        createUserDto.setMail(request.getMail());
        createUserDto.setProvider(request.getIsProvider());
        if(request.getIsProvider()){
            createUserDto.setExpertise(request.getExpertise());
            createUserDto.setExperience(request.getExperience());
        }
        createUserDto.setUserScore(5.0);
        createUserDto.setLocation(request.getLocation());
        createUserDto.setPassword(bCryptPasswordEncoder.encode(request.getCipher()));

        userRepository.save(createUserDto);
        return ManipulationResponse.SUCCESS_PROCESS;
    }

    @Override
    public UserDto getUser(String mail) throws CustomException {
        Optional<UserDto> user = userRepository.findByMail(mail);
        if(user.isEmpty()){
            throw new DataNotFoundException(USER_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        return user.get();
    }

    @Override
    public UserDto getUser(Long userId) throws CustomException {
        Optional<UserDto> user = userRepository.findById(userId);
        if(user.isEmpty()){
            throw new DataNotFoundException(USER_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        return user.get();
    }

    @Override
    public ManipulationResponse updateUser(UpdateUserRequest request) throws CustomException {
        Optional<UserDto> updateUser = userRepository.findById(request.getUserId());
        if(updateUser.isEmpty()) {
            throw new BusinessException(USER_NOT_FOUND);
        }
        UserDto user = updateUser.get();
        user.setFirstName(request.getFirstName());
        user.setMiddleName(request.getMiddleName());
        user.setSurName(request.getSurName());
        user.setLocation(request.getLocation());
        userRepository.save(user);
        return ManipulationResponse.SUCCESS_PROCESS;
    }



    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<UserDto> userDetailDto = userRepository.findByMail(s);
        if (userDetailDto.isEmpty())  throw new UsernameNotFoundException(s);
        UserDto user = userDetailDto.get();
        return new User(user.getMail(),user.getPassword(),
                true, true, true, true,
                new ArrayList<>());
    }
}
