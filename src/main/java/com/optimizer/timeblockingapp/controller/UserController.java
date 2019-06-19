package com.optimizer.timeblockingapp.controller;

import com.optimizer.timeblockingapp.dto.UserDto;
import com.optimizer.timeblockingapp.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/user")
@Api(tags = "Apps: User")
public class UserController {

    @Autowired
    private UserService userService;


    @ApiOperation(
            value = "Retrieve single User",
            produces = "application/json",
            response = UserDto.class
    )
    @GetMapping(path = "/{id}")
    @ResponseBody
    public List<UserDto> getUser(@ApiParam(value = "The ID of the requested User") @PathVariable(value = "id") Optional<Long> id) {
        return userService.getUser(id);
    }

    @ApiOperation(
            value = "Creates a User",
            produces = "application/json",
            response = UserDto.class
    )
    @PostMapping
    @ResponseBody
    public UserDto createUser(@ApiParam(value = "The User model that need to be created") @RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

}
