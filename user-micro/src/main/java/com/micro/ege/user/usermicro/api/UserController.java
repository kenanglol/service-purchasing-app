package com.micro.ege.user.usermicro.api;

import com.micro.ege.user.usermicro.core.exception.BussinessException;
import com.micro.ege.user.usermicro.core.exception.DataManipulationException;
import com.micro.ege.user.usermicro.core.exception.DataNotFoundException;
import com.micro.ege.user.usermicro.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "User Microservice")
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService) {
        this.userMapper = Mappers.getMapper(UserMapper.class);
        this.userService = userService;
    }

    @Operation(summary = "Create User",description = "Create User")
    @ApiResponse(responseCode = "201", description = "Create User Response")
    @PostMapping(path = "/create")
    public ResponseEntity<CreateUserResponse> createUser(
            @Parameter(description = "Request object for create",required = true)
            @RequestBody CreateUserRequest createUserRequest) throws DataManipulationException {
        return new ResponseEntity<CreateUserResponse>(userMapper.mapServiceOutputToApiResponse(
                userService.createUser(userMapper.mapApiRequestToServiceInput(
                        createUserRequest))), HttpStatus.CREATED);
    }

    @Operation(summary = "Get User",description = "Get User")
    @ApiResponse(responseCode = "201", description = "Get User Response")
    @GetMapping(path = "/get")
    public ResponseEntity<GetUserResponse> getUser(
            @Parameter(description = "Request object for get",required = true)
            @RequestBody GetUserRequest getUserRequest) throws DataNotFoundException {
        return new ResponseEntity<GetUserResponse>(userMapper.mapServiceOutputToApiResponse(
                userService.getUser(userMapper.mapApiRequestToServiceInput(getUserRequest))), HttpStatus.CREATED);
    }

    @Operation(summary = "Update Offer",description = "Update User")
    @ApiResponse(responseCode = "201", description = "Update User Response")
    @PutMapping(path = "/update")
    public ResponseEntity<UpdateUserResponse> updateUser(
            @Parameter(description = "Request object for create",required = true)
            @RequestBody UpdateUserRequest updateUserRequest) throws BussinessException {
        return new ResponseEntity<UpdateUserResponse>(userMapper.mapServiceOutputToApiResponse(
                userService.updateUser(userMapper.mapApiRequestToServiceInput(updateUserRequest))), HttpStatus.CREATED);
    }

}
