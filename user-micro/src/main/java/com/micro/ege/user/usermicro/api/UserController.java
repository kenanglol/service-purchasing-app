package com.micro.ege.user.usermicro.api;

import com.micro.ege.user.usermicro.api.model.CreateUserRequest;
import com.micro.ege.user.usermicro.api.model.ManipulationResponse;
import com.micro.ege.user.usermicro.api.model.UpdateUserRequest;
import com.micro.ege.user.usermicro.dto.UserDto;
import com.micro.ege.user.usermicro.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "User Microservice")
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Create User",description = "Create User")
    @ApiResponse(responseCode = "201", description = "Create User Response")
    @PostMapping(path = "/create")
    public ResponseEntity<ManipulationResponse> createUser(
            @Parameter(description = "Request object for create",required = true)
            @RequestBody CreateUserRequest createUserRequest) throws DataManipulationException {
        return new ResponseEntity<>(userService.createUser(createUserRequest), HttpStatus.CREATED);
    }

    @Operation(summary = "Get User",description = "Get User")
    @ApiResponse(responseCode = "201", description = "Get User Response")
    @GetMapping(path = "/{userId}")
    public ResponseEntity<UserDto> getUser(
            @Parameter(description = "Request object for get",required = true)
            @PathVariable Long userId) throws DataNotFoundException {
        return new ResponseEntity<>(userService.getUser(userId), HttpStatus.OK);
    }

    @Operation(summary = "Update Offer",description = "Update User")
    @ApiResponse(responseCode = "201", description = "Update User Response")
    @PutMapping(path = "/update")
    public ResponseEntity<ManipulationResponse> updateUser(
            @Parameter(description = "Request object for create",required = true)
            @RequestBody UpdateUserRequest updateUserRequest) throws BussinessException {
        return new ResponseEntity<>(userService.updateUser(updateUserRequest), HttpStatus.ACCEPTED);
    }

}
