package com.micro.ege.user.usermicro.service;

import com.micro.ege.user.usermicro.core.constant.UserMicroConstants;
import com.micro.ege.user.usermicro.core.exception.BussinessException;
import com.micro.ege.user.usermicro.core.exception.DataNotFoundException;
import com.micro.ege.user.usermicro.core.exception.UserExceptions;
import com.micro.ege.user.usermicro.dto.CreateUserDto;
import com.micro.ege.user.usermicro.dto.UserDetailDto;
import com.micro.ege.user.usermicro.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public CreateUserServiceOutput createUser(CreateUserServiceInput request) {
        CreateUserServiceOutput result = new CreateUserServiceOutput();
        CreateUserDto createUserDto = new CreateUserDto();
        createUserDto.setName(request.getName());
        createUserDto.setSurname(request.getSurname());
        createUserDto.setMail(request.getMail());
        createUserDto.setCipher(request.getCipher());


        result.setIsSucceeded(userRepository.createUser(createUserDto));
        result.setErrorCode(UserMicroConstants.SUCCESS_CODE);
        result.setErrorMessage(UserMicroConstants.SUCCESS_MSG);
        return result;
    }

    @Override
    public GetUserServiceOutput getUser(GetUserServiceInput request) throws DataNotFoundException {

        GetUserServiceOutput response = new GetUserServiceOutput();
        UserDetailDto userDetails = null;

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
    public UpdateUserServiceOutput updateUser(UpdateUserServiceInput request) throws BussinessException {
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


}
